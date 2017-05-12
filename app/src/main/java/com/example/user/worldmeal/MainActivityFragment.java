package com.example.user.worldmeal;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvMeals = (ListView) view.findViewById(R.id.lvMeals);


        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_meals_row,
                R.id.tvMeal,
                items
        );
        lvMeals.setAdapter(adapter);

        return view;
    }
}
