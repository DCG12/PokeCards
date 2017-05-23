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

        String categoria = preferences.getString("strCategory", "Vegetarian");
        String area = preferences.getString("strArea", "Indian");
        String tipoConsulta = preferences.getString("strCategory", "strArea");

        ArrayList<Meals> result = APIMeals.getTypeMeal(categoria);
/*
            if(tipoConsulta.equals("strCategory")) {
                result = api.getTypeMeal(category);
            }
            else{
                result = api.getNationalMeal(area);
            }
*/
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
