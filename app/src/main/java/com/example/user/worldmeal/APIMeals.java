package com.example.user.worldmeal;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class APIMeals {

        private static String NAME_URL = "https://api.pokemontcg.io/v1/cards";

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
        Uri builtUri = Uri.parse(NAME_URL)
                .buildUpon()
                .appendQueryParameter("strArea", area)
                .build();
        String url = builtUri.toString();

        return doCall(NAME_URL);
    }

        @Nullable
        private static ArrayList<Meals> doCall (String url){
        try {
            String JsonResponse = HttpUtils.get(url);
            ArrayList<Meals> meals = new ArrayList<>();

            JSONObject data = new JSONObject(JsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");

            for (int i = 0; i < jsonCartas.length(); i++) {
                Meals meal = new Meals();
                JSONObject object = jsonCartas.getJSONObject(i);
                if (object.has("name")) {
                    meal.setNombre(object.getString("name"));
                }
                if (object.has("types")) {
                    meal.setTipo(object.getString("types"));
                }
                if (object.has("hp")) {
                    meal.setVida(object.getString("hp"));
                }
                if (object.has("subtype")) {
                    meal.setEstado(object.getString("subtype"));
                }
                if (object.has("supertype")) {
                    meal.setClase(object.getString("supertype"));
                }
                if (object.has("ability")) {
                    meal.setHabilidad(object.getString("ability"));
                }
                if (object.has("artist")) {
                    meal.setArtista(object.getString("artist"));
                }
                if (object.has("rarity")) {
                    meal.setSerie(object.getString("rarity"));
                }
                if (object.has("imageUrl")) {
                    meal.setImagen(object.getString("imageUrl"));
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
