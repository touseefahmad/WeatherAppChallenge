package ta.com.weatherapp.ta.com.weatherapp.db;

/**
 * Created by Touseef on 3/29/2016.
 */
public class DataModel {


    //private String COLUMN_DATA_ID = "data_id";
    private String  epoch;
    private String pretty;
    private String day;
    private String year;
    private String monthnameShort;
    private String celsiusHigh;
    private String celsiusLow;
    private String conditions;
    private String iconUrl;
    private String weekDay;

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getPretty() {
        return pretty;
    }

    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonthnameShort() {
        return monthnameShort;
    }

    public void setMonthnameShort(String monthnameShort) {
        this.monthnameShort = monthnameShort;
    }

    public String getCelsiusHigh() {
        return celsiusHigh;
    }

    public void setCelsiusHigh(String celsiusHigh) {
        this.celsiusHigh = celsiusHigh;
    }

    public String getCelsiusLow() {
        return celsiusLow;
    }

    public void setCelsiusLow(String celsiusLow) {
        this.celsiusLow = celsiusLow;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
}
