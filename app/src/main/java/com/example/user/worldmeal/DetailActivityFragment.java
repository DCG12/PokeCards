package com.example.user.worldmeal;


import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexvasilkov.events.Events;
import com.bumptech.glide.Glide;
import com.example.user.worldmeal.databinding.FragmentDetailBinding;

public class DetailActivityFragment extends Fragment {

    private FragmentDetailBinding binding;

    public DetailActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        Events.register(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_detail, container, false);
        View view = binding.getRoot();

        Intent i = getActivity().getIntent();

        if (i != null) {
            Meals meal = (Meals) i.getSerializableExtra("meal");

            if (meal != null) {
                updateUi(meal);
            }
        }

        return view;
    }

    @Events.Subscribe("meal-selected")
    private void onMovieSelected(Meals meal) {
        updateUi(meal);
    }

    private void updateUi(Meals meal) {
        Log.d("MEALS", meal.toString());

        binding.tvNombre.setText(meal.getNombre());
        binding.tvCategory.setText(Html.fromHtml("<b>Tipo:</b> " + meal.getTipo()));
        binding.tvArea.setText(Html.fromHtml("<b>Hp:</b> " + meal.getVida()));
        binding.tvInstrucciones.setText(Html.fromHtml("<b>Clase:</b>" + meal.getClase()));
        Glide.with(getContext()).load(meal.getImagen()).into(binding.ivImage);
    }

}
