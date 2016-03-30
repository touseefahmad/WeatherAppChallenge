package ta.com.weatherapp.ta.com.weatherapp.service;
import java.util.Observable;

/**
 * Created by Touseef on 3/28/2016.
 */


public class DataObservor extends Observable {
    protected void triggerObservers() {
        setChanged();
        notifyObservers();
    }
}
