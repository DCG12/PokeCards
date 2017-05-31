package com.example.user.worldmeal;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class APIMeals {


        private static String NAME_URL = "http://www.themealdb.com/api/json/v1/1/search.php?s";
        private static String ID_URL = "http://www.themealdb.com/api/json/v1/1/search.php?s";

        static ArrayList<Meals> getMeal() {
        Uri builtUri = Uri.parse(NAME_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return doCall(NAME_URL);
    }

       static ArrayList<Meals> getTypeMeal (String categoria){
        Uri builtUri = Uri.parse(NAME_URL)
                .buildUpon()
                .appendQueryParameter("strCategory", categoria)
                .build();
        String url = builtUri.toString();


        return doCall(NAME_URL);
    }

       static ArrayList<Meals> getNationalMeal (String area){
        Uri builtUri = Uri.parse(ID_URL)
                .buildUpon()
                .appendQueryParameter("strArea", area)
                .build();
        String url = builtUri.toString();

        return doCall(ID_URL);
    }


        @Nullable
        private static ArrayList<Meals> doCall (String url){
        try {
            String JsonResponse = HttpUtils.get(url);
            ArrayList<Meals> meals = new ArrayList<>();

            JSONObject data = new JSONObject(JsonResponse);
            JSONArray jsonCartas = data.getJSONArray("meals");

            for (int i = 0; i < jsonCartas.length(); i++) {
                Meals meal = new Meals();
                JSONObject object = jsonCartas.getJSONObject(i);
                if (object.has("strMeal")) {
                    meal.setNombre(object.getString("strMeal"));
                }
                if (object.has("strCategory")) {
                    meal.setStrCategory(object.getString("strCategory"));
                }
                if (object.has("strArea")) {
                    meal.setArea(object.getString("strArea"));
                }
                if (object.has("strInstructions")) {
                    meal.setInstrucciones(object.getString("strInstructions"));
                }
                if (object.has("strMealThumb")) {
                    meal.setImagen(object.getString("strMealThumb"));
                }
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
