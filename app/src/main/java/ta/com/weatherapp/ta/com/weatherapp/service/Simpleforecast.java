package ta.com.weatherapp.ta.com.weatherapp.service;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Touseef on 3/28/2016.
 */
public class Simpleforecast {


    @SerializedName("forecastday")
    @Expose
    private List<Forecastday_> forecastday = new ArrayList<Forecastday_>();

    /**
     *
     * @return
     * The forecastday
     */
    public List<Forecastday_> getForecastday() {
        return forecastday;
    }

    /**
     *
     * @param forecastday
     * The forecastday
     */
    public void setForecastday(List<Forecastday_> forecastday) {
        this.forecastday = forecastday;
    }

}
