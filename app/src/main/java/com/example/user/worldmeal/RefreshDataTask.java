package com.example.user.worldmeal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.alexvasilkov.events.Events;

import java.util.ArrayList;

public class RefreshDataTask extends AsyncTask<Void, Void, Void> {

private Context context;

        RefreshDataTask(Context context) {
        this.context = context;
        }

    @Override
protected void onPreExecute() {
        super.onPreExecute();

        Events.post("start-downloading-data");
        }

    @Override
    protected Void doInBackground(Void... voids) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        String types = preferences.getString("types", "Grass");
        String rareza = preferences.getString("rarity", "Rare");
        String tipoConsulta = preferences.getString("tipus_consulta", "tipos");

        ArrayList<Meals> result;

            if(tipoConsulta.equals("tipos")) {
                result = APIMeals.getTypeMeal(types);
            }
            else{
                result = APIMeals.getRarezaMeal(rareza);
            }

        Log.d("DEBUG", result != null ? result.toString() : null);
        DataManager.deleteMeals(context);
        DataManager.saveMeals(result, context);

        return null;
    }
    @Override
       protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
                        Events.post("finish-downloading-data");
            }
}
