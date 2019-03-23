package blockchainvideoapp.com.goviddo.goviddo.coreclass;

public class HomeRecyclerModel {

    private int mVideoId;
    private String mSliderImage;
    private String mShortenText;

    public int getmVideoId() {
        return mVideoId;
    }

    public void setmVideoId(int mVideoId) {
        this.mVideoId = mVideoId;
    }

    public String getmSliderImage() {
        return mSliderImage;
    }

    public void setmSliderImage(String mSliderImage) {
        this.mSliderImage = mSliderImage;
    }

    public String getmShortenText() {
        return mShortenText;
    }

    public void setmShortenText(String mShortenText) {
        this.mShortenText = mShortenText;
    }

    public String getmVdoCipherId() {
        return mVdoCipherId;
    }

    public void setmVdoCipherId(String mVdoCipherId) {
        this.mVdoCipherId = mVdoCipherId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public HomeRecyclerModel(int mVideoId, String mSliderImage, String mShortenText, String mVdoCipherId) {
        this.mVideoId = mVideoId;
        this.mSliderImage = mSliderImage;
        this.mShortenText = mShortenText;
        this.mVdoCipherId = mVdoCipherId;
    }

    private String mVdoCipherId;
    private String mTitle;
    private String mDescription;

    public HomeRecyclerModel(String title, String description) {
        this.mTitle = title;
        this.mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }


}