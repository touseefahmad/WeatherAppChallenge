package ta.com.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    boolean THREAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        THREAD=true;
        final Thread thread = new Thread()
        {
            @Override
            public void run() {
                try {
                    while(THREAD) {
                        sleep(2000);
                        THREAD =false;
                        //handler.post(runner);
                        /*********************
                         * open next activity
                         ********************/
                        callMain();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }
    public void callMain(){
        Intent intent=new Intent(splash.this,mainActivity.class);
        startActivity(intent);
        splash.this.finish();
    }
}
