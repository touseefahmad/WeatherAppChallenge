package ta.com.weatherapp.ta.com.weatherapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Touseef on 3/29/2016.
 */
public class WeatherAppDBOpenHelper extends SQLiteOpenHelper {
    private static final String LOGTAG = "WeatherAPP";

    private static final String DATABASE_NAME = "weatherapp.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_DATA = "data";
    public static final String COLUMN_DATA_ID = "data_id";
    public static final String COLUMN_EPOCH = "epoch";
    public static final String COLUMN_PRETTY = "pretty";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_YDAY = "yday";
    public static final String COLUMN_HOUR = "hour";
    public static final String COLUMN_MIN = "min";
    public static final String COLUMN_SEC = "sec";
    public static final String COLUMN_ISDST = "isdst";
    public static final String COLUMN_MONTHNAME = "monthname";
    public static final String COLUMN_MONTHNAME_SHORT = "monthname_short";
    public static final String COLUMN_WEEKDAY_SHORT = "weekday_short";
    public static final String COLUMN_WEEKDAY = "weekday";
    public static final String COLUMN_AMPM = "ampm";
    public static final String COLUMN_TZ_SHORT = "tz_short";
    public static final String COLUMN_TZ_LONG = "tz_long";
    public static final String COLUMN_PERIOD = "period";
    public static final String COLUMN_CELSUIS_HIGH = "celsius_high";
    public static final String COLUMN_FAHRENHEIT_HIGH = "fahrenheit_high";
    public static final String COLUMN_CELSUIS_LOW = "celsius_low";
    public static final String COLUMN_FAHRENHEIT_LOW = "fahrenheit_low";
    public static final String COLUMN_CONDITIONS = "conditions";
    public static final String COLUMN_ICON = "icon";
    public static final String COLUMN_ICONURL = "icon_url";


    private static final String TABLE_CREATE_DATA =
            "CREATE TABLE " + TABLE_DATA + " (" +
                    COLUMN_DATA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_EPOCH + " TEXT, " +
                    COLUMN_PRETTY + " TEXT, " +
                    COLUMN_DAY + " TEXT, " +
                    COLUMN_MONTHNAME_SHORT + " TEXT, " +
                    COLUMN_YEAR + " TEXT, " +
                    COLUMN_CONDITIONS + " TEXT, " +
                    COLUMN_CELSUIS_LOW + " TEXT, " +
                    COLUMN_CELSUIS_HIGH + " TEXT, " +
                    COLUMN_WEEKDAY + " TEXT, " +
                    COLUMN_ICONURL + " TEXT" +
                    ")";




    public WeatherAppDBOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_DATA);
        Log.d(LOGTAG, "Table created successfully..!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREATE_DATA);
        onCreate(db);

    }
}
