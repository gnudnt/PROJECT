package vn.edu.usth.usthweather;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeatherAndForecastFragment extends Fragment {

    public static WeatherAndForecastFragment newInstance() {
        return new WeatherAndForecastFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Tạo layout cha LinearLayout dọc
        RelativeLayout parentLayout = new RelativeLayout(getContext());
        parentLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        // ----- WeatherFragment area (green) -----
        RelativeLayout weatherLayout = new RelativeLayout(getContext());
        weatherLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams weatherParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                550 // chiều cao weather area
        );
        weatherLayout.setLayoutParams(weatherParams);
        weatherLayout.setBackgroundColor(Color.parseColor("#4CAF50"));

        // Nhiệt độ góc trên bên trái
        TextView tempText = new TextView(getContext());
        tempText.setText("Sunny 25°C");
        tempText.setTextSize(20);
        tempText.setTextColor(Color.WHITE);
        RelativeLayout.LayoutParams tempParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        tempParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        tempParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tempParams.setMargins(16, 16, 0, 0);
        weatherLayout.addView(tempText, tempParams);

        // Địa điểm góc trên bên phải
        TextView locationText = new TextView(getContext());
        locationText.setText("Hà Nội");
        locationText.setTextSize(18);
        locationText.setTextColor(Color.WHITE);
        RelativeLayout.LayoutParams locationParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        locationParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        locationParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        locationParams.setMargins(0, 16, 16, 0);
        weatherLayout.addView(locationText, locationParams);

        // Icon chính giữa
        ImageView icon = new ImageView(getContext());
        icon.setImageResource(R.drawable.angry_clouds);
        icon.setAdjustViewBounds(true);
        icon.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams iconParams = new RelativeLayout.LayoutParams(400, 400);
        iconParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        weatherLayout.addView(icon, iconParams);

        parentLayout.addView(weatherLayout);

        // ----- ForecastFragment area (white) -----
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setId(View.generateViewId());
        RelativeLayout.LayoutParams recyclerParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        recyclerParams.addRule(RelativeLayout.BELOW, weatherLayout.getId());
        recyclerView.setLayoutParams(recyclerParams);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<ForecastItem> forecastList = new ArrayList<>();
        forecastList.add(new ForecastItem("Mon", R.drawable.angry_clouds, "Partly Cloudy", "24°C - 31°C"));
        forecastList.add(new ForecastItem("Tue", R.drawable.angry_clouds, "Showers", "24°C - 30°C"));
        forecastList.add(new ForecastItem("Wed", R.drawable.angry_clouds, "Rain", "22°C - 23°C"));
        forecastList.add(new ForecastItem("Thu", R.drawable.angry_clouds, "Scattered Showers", "22°C - 27°C"));
        forecastList.add(new ForecastItem("Fri", R.drawable.angry_clouds, "Mostly Cloudy", "24°C - 30°C"));
        forecastList.add(new ForecastItem("Sat", R.drawable.angry_clouds, "Partly Cloudy", "25°C - 28°C"));
        forecastList.add(new ForecastItem("Sun", R.drawable.angry_clouds, "Thunderstorms", "26°C - 28°C"));

        ForecastAdapter adapter = new ForecastAdapter(forecastList);
        recyclerView.setAdapter(adapter);

        parentLayout.addView(recyclerView);

        return parentLayout;
    }
}
