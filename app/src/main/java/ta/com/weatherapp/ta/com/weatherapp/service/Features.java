package ta.com.weatherapp.ta.com.weatherapp.service;

/**
 * Created by Touseef on 3/28/2016.
 */
//public class Features {
//}



        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class Features {

    @SerializedName("forecast")
    @Expose
    private Integer forecast;

    /**
     *
     * @return
     * The forecast
     */
    public Integer getForecast() {
        return forecast;
    }

    /**
     *
     * @param forecast
     * The forecast
     */
    public void setForecast(Integer forecast) {
        this.forecast = forecast;
    }

}

