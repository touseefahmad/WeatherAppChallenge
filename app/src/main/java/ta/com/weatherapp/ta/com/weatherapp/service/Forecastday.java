package ta.com.weatherapp.ta.com.weatherapp.service;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Touseef on 3/28/2016.
 */
public class Forecastday {



    @SerializedName("period")
    @Expose
    private Integer period;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("fcttext")
    @Expose
    private String fcttext;
    @SerializedName("fcttext_metric")
    @Expose
    private String fcttextMetric;
    @SerializedName("pop")
    @Expose
    private String pop;

    /**
     *
     * @return
     * The period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     *
     * @param period
     * The period
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     *
     * @return
     * The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     * The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     *
     * @return
     * The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     *
     * @param iconUrl
     * The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The fcttext
     */
    public String getFcttext() {
        return fcttext;
    }

    /**
     *
     * @param fcttext
     * The fcttext
     */
    public void setFcttext(String fcttext) {
        this.fcttext = fcttext;
    }

    /**
     *
     * @return
     * The fcttextMetric
     */
    public String getFcttextMetric() {
        return fcttextMetric;
    }

    /**
     *
     * @param fcttextMetric
     * The fcttext_metric
     */
    public void setFcttextMetric(String fcttextMetric) {
        this.fcttextMetric = fcttextMetric;
    }

    /**
     *
     * @return
     * The pop
     */
    public String getPop() {
        return pop;
    }

    /**
     *
     * @param pop
     * The pop
     */
    public void setPop(String pop) {
        this.pop = pop;
    }


}
