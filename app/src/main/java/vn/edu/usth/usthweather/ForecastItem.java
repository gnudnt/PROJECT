package vn.edu.usth.usthweather;

public class ForecastItem {
    public String day;
    public int iconRes;
    public String comment;
    public String temp;

    public ForecastItem(String day, int iconRes, String comment, String temp) {
        this.day = day;
        this.iconRes = iconRes;
        this.comment = comment;
        this.temp = temp;
    }
}
