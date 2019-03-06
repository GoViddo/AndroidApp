package blockchainvideoapp.com.goviddo.goviddo.coreclass;

public class RecyclerRecent {

    private String mText;
    private String mImage;
    private String mtext;

    public RecyclerRecent(String mImage, String mText) {
        this.mText = mText;
        this.mImage = mImage;
    }

    public RecyclerRecent( String mText) {
        this.mtext = mText;
    }

    public String getmText() {
        return mText;
    }

    public String getmImage() {
        return mImage;
    }

    public String getMtext() {
        return mtext;
    }
}
