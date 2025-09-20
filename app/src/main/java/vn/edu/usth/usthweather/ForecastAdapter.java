package vn.edu.usth.usthweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private List<ForecastItem> items;

    public ForecastAdapter(List<ForecastItem> items) { this.items = items; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ForecastItem item = items.get(position);
        holder.day.setText(item.day);
        holder.comment.setText(item.comment);
        holder.temp.setText(item.temp);
        holder.comment.setText(item.comment);
        holder.icon.setImageResource(item.iconRes);
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView day, comment, temp;
        ImageView icon;

        ViewHolder(View v) {
            super(v);
            day = v.findViewById(R.id.item_day);
            comment = v.findViewById(R.id.item_comment);
            temp = v.findViewById(R.id.item_temp);
            icon = v.findViewById(R.id.item_icon);
        }
    }
}
