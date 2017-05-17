package com.example.user.worldmeal;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class MealsAdapter extends ArrayAdapter<Meals> {
    public MealsAdapter(Context context, int resource, List<Meals> objects) {
        super(context, resource, objects);
    }

}
