package ta.com.weatherapp.ta.com.weatherapp.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



/**
 * Created by Touseef on 3/28/2016.
 */
//public class Example1 {
//}




public class Example {

    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    /**
     *
     * @return
     * The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     *
     * @return
     * The forecast
     */
    public Forecast getForecast() {
        return forecast;
    }

    /**
     *
     * @param forecast
     * The forecast
     */
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

}