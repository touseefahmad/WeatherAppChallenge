package ta.com.weatherapp.ta.com.weatherapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Touseef on 3/29/2016.
 */
public class WeatherDataSource {
    private static final String LOGTAG = "WeatherApp";

    SQLiteOpenHelper helper;
    SQLiteDatabase database;
    Context context;


    private static final String[] allColumns = {
            WeatherAppDBOpenHelper.COLUMN_DATA_ID,
            WeatherAppDBOpenHelper.COLUMN_EPOCH,
            WeatherAppDBOpenHelper.COLUMN_PRETTY,
            WeatherAppDBOpenHelper.COLUMN_DAY,
            WeatherAppDBOpenHelper.COLUMN_MONTHNAME_SHORT,
            WeatherAppDBOpenHelper.COLUMN_YEAR,
            WeatherAppDBOpenHelper.COLUMN_CONDITIONS,
            WeatherAppDBOpenHelper.COLUMN_CELSUIS_LOW,
            WeatherAppDBOpenHelper.COLUMN_CELSUIS_HIGH,
            WeatherAppDBOpenHelper.COLUMN_WEEKDAY,
            WeatherAppDBOpenHelper.COLUMN_ICONURL
    };


    public WeatherDataSource(Context context){
        helper = new WeatherAppDBOpenHelper(context);
        this.context = context;
    }
    public void open(){
        database = helper.getWritableDatabase();
        Log.d(LOGTAG, "Database open...!");
    }
    public void close(){
        helper.close();
        Log.d(LOGTAG, "Database close...!");
    }

    public DataModel add(DataModel dataModel){

        ContentValues values = new ContentValues();

        values.put(WeatherAppDBOpenHelper.COLUMN_EPOCH, dataModel.getEpoch());
        values.put(WeatherAppDBOpenHelper.COLUMN_PRETTY, dataModel.getPretty());
        values.put(WeatherAppDBOpenHelper.COLUMN_DAY, dataModel.getDay());
        values.put(WeatherAppDBOpenHelper.COLUMN_MONTHNAME_SHORT, dataModel.getMonthnameShort());
        values.put(WeatherAppDBOpenHelper.COLUMN_YEAR, dataModel.getYear());
        values.put(WeatherAppDBOpenHelper.COLUMN_CONDITIONS, dataModel.getConditions());
        values.put(WeatherAppDBOpenHelper.COLUMN_CELSUIS_LOW, dataModel.getCelsiusLow());
        values.put(WeatherAppDBOpenHelper.COLUMN_CELSUIS_HIGH, dataModel.getCelsiusHigh());
        values.put(WeatherAppDBOpenHelper.COLUMN_WEEKDAY, dataModel.getWeekDay());
        values.put(WeatherAppDBOpenHelper.COLUMN_ICONURL, dataModel.getIconUrl());

        long id = database.insert(WeatherAppDBOpenHelper.TABLE_DATA, null, values);
        Log.d("no of items added", String.valueOf(id));

        return dataModel;
    }


    public List<DataModel> findAll(){
        Log.i("TA", "inside find all method");

        List<DataModel> dataList = new ArrayList<DataModel>();
        Log.i("DB", "before query");
        Cursor c = database.query(WeatherAppDBOpenHelper.TABLE_DATA, allColumns, null, null, null, null, null);

        Log.i("DB", "after query");

        if(c.getCount() > 0){
            Log.i("DB", "Inside if");
            while(c.moveToNext()){
                DataModel dataModel = new DataModel();

                dataModel.setEpoch(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_EPOCH)));
                dataModel.setPretty(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_PRETTY)));
                dataModel.setDay(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_DAY)));
                dataModel.setMonthnameShort(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_MONTHNAME_SHORT)));
                dataModel.setYear(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_YEAR)));
                dataModel.setConditions(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_CONDITIONS)));
                dataModel.setCelsiusLow(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_CELSUIS_LOW)));
                dataModel.setCelsiusHigh(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_CELSUIS_HIGH)));
                dataModel.setWeekDay(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_WEEKDAY)));
                dataModel.setIconUrl(c.getString(c.getColumnIndex(WeatherAppDBOpenHelper.COLUMN_ICONURL)));

                dataList.add(dataModel);
            }
        }

        return dataList;
    }

    public boolean removeAll(){
        database.execSQL("delete from " + WeatherAppDBOpenHelper.TABLE_DATA);
        return true;
    }





}
