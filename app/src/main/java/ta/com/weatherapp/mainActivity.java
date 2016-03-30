package ta.com.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ta.com.weatherapp.ta.com.weatherapp.db.DataModel;
import ta.com.weatherapp.ta.com.weatherapp.db.WeatherDataSource;
import ta.com.weatherapp.ta.com.weatherapp.service.Example;
import ta.com.weatherapp.ta.com.weatherapp.service.Forecastday_;
import ta.com.weatherapp.ta.com.weatherapp.service.Simpleforecast;
import ta.com.weatherapp.ta.com.weatherapp.service.WeatherService;

/**
 * Created by Touseef on 3/27/2016.
 */
public class mainActivity extends Activity implements Observer {
    ListView listWeather;
    TextView tvResp;
    ConnectionDetector connectionDetector;
    WeatherService weatherService;
    Example example;
    Context context;
    private List<Forecastday_> forecastList;
    Forecastday_ foreCastModel;
    private WeatherListAdapter adapter;
    private WeatherDataSource weatherDataSource;
    List<DataModel> dataList;
    private DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listWeather = (ListView) findViewById(R.id.listWeather);
        tvResp = (TextView) findViewById(R.id.tvResp);
        context = getApplicationContext();
        weatherService = new WeatherService();
        weatherService.addObserver(this);
        dataList = new ArrayList<DataModel>();
        weatherDataSource = new WeatherDataSource(this);
        weatherDataSource.open();
        example = new Example();
        forecastList = new ArrayList<Forecastday_>();
        weatherServiceCall();
    }

    @Override
    public void update(Observable observable, Object data) {
        if (weatherService.getResponse() != null) {
            tvResp.setText("");
            example = weatherService.getResponse();

            Simpleforecast simpleforecast = example.getForecast().getSimpleforecast();

            Log.e("ExampleResponse", example.getForecast().getTxtForecast().getForecastday().toString());

            dataList = weatherDataSource.findAll();
            if (dataList != null) {
                if (dataList.size() > 0) {
                    weatherDataSource.removeAll();
                    dataList.clear();
                }
            }
            for (int i = 0; i < 3; i++) {
                foreCastModel = new Forecastday_();
                foreCastModel = simpleforecast.getForecastday().get(i);
                forecastList.add(foreCastModel);
                dataModel = new DataModel();
                dataModel.setEpoch(forecastList.get(i).getDate().getEpoch());
                dataModel.setDay(forecastList.get(i).getDate().getDay().toString());
                dataModel.setMonthnameShort(forecastList.get(i).getDate().getMonthnameShort().toString());
                dataModel.setYear(forecastList.get(i).getDate().getYear().toString());
                dataModel.setWeekDay(forecastList.get(i).getDate().getWeekday());
                dataModel.setPretty(forecastList.get(i).getDate().getPretty().toString());
                dataModel.setConditions(forecastList.get(i).getConditions().toString());
                dataModel.setCelsiusLow(forecastList.get(i).getLow().getCelsius().toString());
                dataModel.setCelsiusHigh(forecastList.get(i).getHigh().getCelsius().toString());
                dataModel.setIconUrl(forecastList.get(i).getIconUrl().toString());
                dataList.add(dataModel);
                weatherDataSource.add(dataModel);

            }
            retrieveFromDb();
        } else {
            retrieveFromDb();
        }

    }


    public class WeatherListAdapter extends ArrayAdapter<DataModel> {


        public WeatherListAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        public WeatherListAdapter(Context context, int resource, List<DataModel> items) {
            super(context, resource, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {

                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.view_weather, null);

            }

            DataModel model = getItem(position);

            if (model != null) {
                NetworkImageView nivWIcon = (NetworkImageView) v.findViewById(R.id.nivWIcon);
                nivWIcon.setDefaultImageResId(android.R.drawable.dialog_holo_light_frame);
                //    nivWIcon.setErrorImageResId(android.R.drawable.dialog_holo_light_frame);
                nivWIcon.setAdjustViewBounds(true);
                // Log.e("url",model.getIconUrl().toString());
                nivWIcon.setImageUrl(model.getIconUrl(), ImageCacheManager.getInstance().getImageLoader());
                TextView tvDayDate = (TextView) v.findViewById(R.id.tvDayDate);
                TextView tvLow = (TextView) v.findViewById(R.id.tvLow);
                TextView tvHigh = (TextView) v.findViewById(R.id.tvHigh);
                tvDayDate.setText(model.getWeekDay() + "  " + model.getDay() + "-"
                        + model.getMonthnameShort() + " " + model.getYear() + "\n" +
                        model.getConditions());
                tvLow.setText("Low Temp: " + model.getCelsiusLow() + "c");
                tvHigh.setText("High Temp:" + model.getCelsiusHigh() + "c");

            }

            return v;


        }
    }

    public void weatherServiceCall() {

        connectionDetector = new ConnectionDetector(context);
        if (connectionDetector.isConnectionToInternet()) {
            /**********************************************
             * if
             * connected to internet it will make a service call
             * else
             * it will retrieve required data from local database
             ***********************************************/
        if(dataList!=null){
            if(dataList.size()>0){
                dataList.clear();
                tvResp.setText("");
            }else{
                tvResp.setText("Wait while we retrieve data");
            }
        }else{
            tvResp.setText("Wait while we retrieve data");
        }

            weatherService.getWeatherData(context);
        } else {
            //if not connected to internet
            retrieveFromDb();
        }
    }

    public void retrieveFromDb() {
        /*************************************
         * in case there is already some data in
         * datalist it will clear it
         * ************************************/
        if (dataList != null) {
            if (dataList.size() > 0)
                dataList.clear();
        }
        /*****************************************
         * retrive data from data  list
         * if there is some data stored in local DataBase
         * it will display it
         * else
         * it will show that something went wrong
         ******************************************/
        dataList = weatherDataSource.findAll();
        if (dataList != null) {
            if (dataList.size() > 0) {
                tvResp.setText("");
                adapter = new WeatherListAdapter(this, R.layout.view_weather, dataList);
                listWeather.setAdapter(adapter);

            } else {
                tvResp.setText("Something Went Wrong");
            }
        }
    }

    @Override
    protected void onPause() {

        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (dataList != null) {
            dataList.clear();
            retrieveFromDb();

        }
        tvResp.setText("");
        weatherServiceCall();

    }
}


