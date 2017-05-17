package com.example.user.worldmeal;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.databinding.DataBindingUtil;

import com.example.user.worldmeal.databinding.FragmentDetailBinding;

import com.bumptech.glide.Glide;

public class DetailActivityFragment extends Fragment {

    private FragmentDetailBinding binding;

    public DetailActivityFragment() {
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

    private void updateUi(Meals meal) {
        Log.d("MEALS", meal.toString());
        
        binding.tvNombre.setText(meal.getNombre());
        binding.tvCategory.setText(Html.fromHtml("<b>Categoria:</b> " + meal.getCategoria()));
        binding.tvArea.setText(Html.fromHtml("<b>Nacionalidad:</b> " + meal.getArea()));
        binding.tvInstrucciones.setText(Html.fromHtml("<b>Instrucciones:</b>" + meal.getInstrucciones()));
        Glide.with(getContext()).load(meal.getImagen()).into(binding.ivImage);
    }

}
