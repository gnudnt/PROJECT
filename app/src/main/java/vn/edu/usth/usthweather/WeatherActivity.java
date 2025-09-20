package vn.edu.usth.usthweather;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Thêm ForecastFragment vào container
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ForecastFragment())
                .commit();
    }
}
