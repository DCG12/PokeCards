package com.example.user.worldmeal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MealsAdapter extends ArrayAdapter<Meals> {
    public MealsAdapter(Context context, int resource, List<Meals> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Meals meal = getItem(position);
        Log.w("MMMM", meal.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_meals_row, parent, false);
        }

        TextView tvNombre = (TextView) convertView.findViewById(R.id.tvMeal);
        TextView tvCategoria = (TextView) convertView.findViewById(R.id.tvCategory);
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);

        tvNombre.setText(meal.getNombre());
        tvCategoria.setText( meal.getCategoria());

        return convertView;
    }

}
