package com.example.user.worldmeal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import android.databinding.DataBindingUtil;

import com.example.user.worldmeal.databinding.LvMealsRowBinding;

import java.util.List;

public class MealsAdapter extends ArrayAdapter<Meals> {
    public MealsAdapter(Context context, int resource, List<Meals> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Meals meal = getItem(position);
        Log.w("MMMM", meal.toString());

        LvMealsRowBinding binding;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.lv_meals_row, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        binding.tvMeal.setText(meal.getNombre());
        binding.tvCategory.setText( meal.getCategoria());
        Glide.with(getContext()).load(meal.getImagen()).into(binding.ivImage);

        return binding.getRoot();
    }

}
