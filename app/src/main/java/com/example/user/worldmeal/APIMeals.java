package com.example.user.worldmeal;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class APIMeals {

    private static String B_URL = "http://www.themealdb.com/api/json/v1/1/randomselection.php";

    ArrayList<Meals> getMeal() {
        Uri builtUri = Uri.parse(B_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return doCall(B_URL);
    }

    ArrayList<Meals> getTypeMeal() {
        Uri builtUri = Uri.parse(B_URL)
                .buildUpon()
                .appendPath("strMeal")
                .appendPath("strCategory")
                .build();
        String url = builtUri.toString();


        return doCall(B_URL);
    }

    ArrayList<Meals> getNationalMeal() {
        Uri builtUri = Uri.parse(B_URL)
                .buildUpon()
                .appendPath("strMeal")
                .appendPath("strArea")
                .build();
        String url = builtUri.toString();

        return doCall(B_URL);
    }


    @Nullable
    private ArrayList<Meals> doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            ArrayList<Meals> meals = new ArrayList<>();

            JSONObject data = new JSONObject(JsonResponse);
            JSONArray jsonCartas = data.getJSONArray("meals");

            for (int i = 0; i <jsonCartas.length() ; i++) {
                Meals meal = new Meals();
                JSONObject object = jsonCartas.getJSONObject(i);
                meal.setNombre(object.getString("strMeal"));
                meal.setCategoria(object.getString("strCategory"));
                meals.add(meal);
            }

            return meals;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
