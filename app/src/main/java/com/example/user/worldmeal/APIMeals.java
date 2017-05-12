package com.example.user.worldmeal;

import android.net.Uri;

import java.io.IOException;

/**
 * Created by user on 12/05/2017.
 */

public class APIMeals {

    private static String B_URL = "http://www.themealdb.com/api/json/v1/1/randomselection.php";

    String getMeal() {
        Uri builtUri = Uri.parse(B_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
