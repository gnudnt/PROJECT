package vn.edu.usth.usthweather;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WeatherFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        RelativeLayout layout = new RelativeLayout(getContext());
        layout.setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        layout.setBackgroundColor(Color.parseColor("#4CAF50")); // Green area

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

        layout.addView(tempText, tempParams);

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

        layout.addView(locationText, locationParams);

        // Icon chính giữa
        ImageView icon = new ImageView(getContext());
        icon.setImageResource(R.drawable.angry_clouds);
        icon.setAdjustViewBounds(true);
        icon.setScaleType(ImageView.ScaleType.FIT_CENTER);

        RelativeLayout.LayoutParams iconParams = new RelativeLayout.LayoutParams(
                400, // chiều rộng
                400  // chiều cao
        );
        iconParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        layout.addView(icon, iconParams);

        return layout;
    }
}
