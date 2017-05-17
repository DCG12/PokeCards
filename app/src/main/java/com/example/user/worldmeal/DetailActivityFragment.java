package com.example.user.worldmeal;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivityFragment extends Fragment {

    private View view;
    private ImageView ivImage;
    private TextView tvNombre;
    private TextView tvCategory;
    private TextView tvArea;
    private TextView tvInstrucciones;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);

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

        ivImage = (ImageView) view.findViewById(R.id.ivImage);
        tvNombre = (TextView) view.findViewById(R.id.tvNombre);
        tvCategory = (TextView) view.findViewById(R.id.tvCategory);
        tvArea = (TextView) view.findViewById(R.id.tvArea);
        tvInstrucciones = (TextView) view.findViewById(R.id.tvInstrucciones);
    }

}
