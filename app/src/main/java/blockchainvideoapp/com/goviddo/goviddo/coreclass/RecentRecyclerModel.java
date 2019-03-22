package blockchainvideoapp.com.goviddo.goviddo.coreclass;

public class RecentRecyclerModel {

    private String mTextFirst;
    private String mImage;
    private String mtext;

    public RecentRecyclerModel(String mImage, String mText) {
        this.mTextFirst = mText;
        this.mImage = mImage;
    }

    public RecentRecyclerModel(String mText) {
        this.mtext = mText;
    }

    public String getmTextFirst() {
        return mTextFirst;
    }

    public String getmImage() {
        return mImage;
    }

    public String getMtext() {
        return mtext;
    }
}
