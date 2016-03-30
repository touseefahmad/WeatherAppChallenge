package ta.com.weatherapp.ta.com.weatherapp.service;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Touseef on 3/28/2016.
 */
public class TxtForecast {


    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("forecastday")
    @Expose
    private List<Forecastday> forecastday = new ArrayList<Forecastday>();

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The forecastday
     */
    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    /**
     *
     * @param forecastday
     * The forecastday
     */
    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

}
