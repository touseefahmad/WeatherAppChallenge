package ta.com.weatherapp.ta.com.weatherapp.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Touseef on 3/28/2016.
 */
public class Forecast {

    @SerializedName("txt_forecast")
    @Expose
    private TxtForecast txtForecast;
    @SerializedName("simpleforecast")
    @Expose
    private Simpleforecast simpleforecast;



    /**
     *
     * @return
     * The txtForecast
     */
    public TxtForecast getTxtForecast() {
        return txtForecast;
    }

    /**
     *
     * @param txtForecast
     * The txt_forecast
     */
    public void setTxtForecast(TxtForecast txtForecast) {
        this.txtForecast = txtForecast;
    }

    /**
     *
     * @return
     * The simpleforecast
     */
    public Simpleforecast getSimpleforecast() {
        return simpleforecast;
    }

    /**
     *
     * @param simpleforecast
     * The simpleforecast
     */
    public void setSimpleforecast(Simpleforecast simpleforecast) {
        this.simpleforecast = simpleforecast;
    }

}
