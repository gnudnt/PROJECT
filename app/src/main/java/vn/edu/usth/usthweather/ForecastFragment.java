package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ForecastFragment extends Fragment {

    private RecyclerView recyclerView;
    private ForecastAdapter adapter;
    private List<ForecastItem> forecastList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        forecastList = new ArrayList<>();
        forecastList.add(new ForecastItem("Mon", R.drawable.angry_clouds, "Partly Cloudy", "24°C - 31°C"));
        forecastList.add(new ForecastItem("Tue", R.drawable.angry_clouds, "Showers", "24°C - 30°C"));
        forecastList.add(new ForecastItem("Wed", R.drawable.angry_clouds, "Rain", "22°C - 23°C"));
        forecastList.add(new ForecastItem("Thu", R.drawable.angry_clouds, "Scattered Showers", "22°C - 27°C"));
        forecastList.add(new ForecastItem("Fri", R.drawable.angry_clouds, "Mostly Cloudy", "24°C - 30°C"));
        forecastList.add(new ForecastItem("Sat", R.drawable.angry_clouds, "Partly Cloudy", "25°C - 28°C"));
        forecastList.add(new ForecastItem("Sun", R.drawable.angry_clouds, "Thunderstorms", "26°C - 28°C"));

        adapter = new ForecastAdapter(forecastList);
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }
}
