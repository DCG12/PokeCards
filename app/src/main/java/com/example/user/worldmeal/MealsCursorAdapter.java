package com.example.user.worldmeal;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.user.worldmeal.databinding.LvMealsRowBinding;


public class MealsCursorAdapter extends CupboardCursorAdapter<Meals> {

    public MealsCursorAdapter(Context context, Class<Meals> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, Meals model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LvMealsRowBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.lv_meals_row, parent, false);

        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Meals model) {
        LvMealsRowBinding binding = DataBindingUtil.getBinding(view);
        binding.tvMeal.setText(model.getNombre());
        binding.tvCategory.setText(model.getStrCategory());
        Glide.with(context).load(model.getImagen()).into(binding.ivImage);
    }
}
