package com.example.user.worldmeal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.databinding.DataBindingUtil;
import android.net.Uri;

import com.example.user.worldmeal.databinding.FragmentMainBinding;

import nl.littlerobots.cupboard.tools.provider.UriHelper;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<Meals> items;
    private MealsAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();

        items = new ArrayList<>();
        adapter = new MealsAdapter(
                getContext(),
                R.layout.lv_meals_row,
                items
        );
        binding.lvMeals.setAdapter(adapter);

        binding.lvMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Meals meal = (Meals) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("meal", meal);
                startActivity(intent);
            }
        });

        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_meals_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.refresh_settings) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }
*/
    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

            String categoria = preferences.getString("strCategory", "Vegetarian");
            String area = preferences.getString("strArea", "Indian");
            String tipoConsulta = preferences.getString("strCategory", "strArea");

            ArrayList<Meals> result = APIMeals.getTypeMeal(categoria);
/*
            if(tipoConsulta.equals("strCategory")) {
                result = api.getTypeMeal(category);
            }
            else{
                result = api.getNationalMeal(area);
            }
*/
            Log.d("DEBUG", result != null ? result.toString() : null);
            DataManager.deleteMovies(getContext());
            DataManager.saveMovies(result, getContext());

            return null;
        }

    }
}
