package ta.com.weatherapp.ta.com.weatherapp.service;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Touseef on 3/28/2016.
 */
public class Response {


    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("termsofService")
    @Expose
    private String termsofService;
    @SerializedName("features")
    @Expose
    private Features features;

    /**
     *
     * @return
     * The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     * The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return
     * The termsofService
     */
    public String getTermsofService() {
        return termsofService;
    }

    /**
     *
     * @param termsofService
     * The termsofService
     */
    public void setTermsofService(String termsofService) {
        this.termsofService = termsofService;
    }

    /**
     *
     * @return
     * The features
     */
    public Features getFeatures() {
        return features;
    }

    /**
     *
     * @param features
     * The features
     */
    public void setFeatures(Features features) {
        this.features = features;
    }
}
