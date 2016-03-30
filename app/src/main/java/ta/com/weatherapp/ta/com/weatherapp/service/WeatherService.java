package ta.com.weatherapp.ta.com.weatherapp.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import ta.com.weatherapp.GsonRequest;
import ta.com.weatherapp.SingletonClass;

/**
 * Created by Touseef on 3/28/2016.
 */
public class WeatherService extends DataObservor{
    Example response;

    public Example getResponse(){
        return response;
    }


    public void getWeatherData(Context context){
//        phoneMap<String, String> params = new HashMap<String, String>();
//        params.put("user_id",user_id);
//        params.put("phone",phone);



        String uri = "http://api.wunderground.com/api/838ed9367e8876bf%20/forecast/q/EG/Cairo.json";
        RequestQueue requestQueue = SingletonClass.getInstance().getRequestQueue();
        GsonRequest<Example> request = new GsonRequest<>(
                Request.Method.GET, uri, Example.class, null,
                successListener(), errorListener());
        requestQueue.add(request);
/* String url=context.getResources().getString(R.string.url)
					+"signIn"
					+"&email="+email
					+"&password="+password
					+"&token="+token;
		 Log.d("URL String:", url);
		 RequestQueue requestQueue = AssayTech.getInstance().getRequestQueue();
		 GsonRequest<AtLoginResponse> request = new GsonRequest<AtLoginResponse>(
					Method.GET, url, AtLoginResponse.class, null,
					successListener(), errorListener());
		 requestQueue.add(request)

        RequestQueue requestQueue = SingletonClass.getInstance().getRequestQueue();

        /************************
         *   getMethodCall
         ***********************/





    }

    private com.android.volley.Response.Listener<Example> successListener() {
        return new com.android.volley.Response.Listener<Example>() {

            @Override
            public void onResponse(Example response) {

                try{
                    WeatherService.this.response=response;

                     }catch(Exception e)
                {
                    WeatherService.this.response=new Example();
                    WeatherService.this.response.getResponse().setVersion("0");
                    Log.d("WeatherService", WeatherService.this.getResponse().toString());
                  //  WeatherService.this.response.getResponse().set;
                }
                triggerObservers();
            }
        };
    }

    private com.android.volley.Response.ErrorListener errorListener() {

        return new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                WeatherService.this.response= new Example();
                WeatherService.this.response=null;

                //WeatherService.this.response.setMessage(error.toString());
                triggerObservers();

            }
        };
    }



}
