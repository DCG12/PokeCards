package com.example.user.worldmeal;

 import android.content.Context;
 //import android.content.CursorLoader;
 import android.net.Uri;
 import java.util.ArrayList;
 import nl.littlerobots.cupboard.tools.provider.UriHelper;

 import android.support.v4.content.CursorLoader;
 import android.support.v4.content.Loader;

 import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class DataManager {

        private static UriHelper URI_HELPER = UriHelper.with(ContentProvider.AUTHORITY);
        private static Uri MEAL_URI = URI_HELPER.getUri(Meals.class);

        static void saveMeals(ArrayList<Meals> movies, Context context) {
            cupboard().withContext(context).put(MEAL_URI, Meals.class, movies);
        }
        static void deleteMeals(Context context) {
            cupboard().withContext(context).delete(MEAL_URI, "_id > ?", "0");
         }
        static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, MEAL_URI, null, null, null, null);
        }

}
