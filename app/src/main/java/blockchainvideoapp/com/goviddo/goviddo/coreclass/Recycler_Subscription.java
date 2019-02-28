package blockchainvideoapp.com.goviddo.goviddo.coreclass;

import android.widget.ImageView;

public class Recycler_Subscription {

    private String imageView;
    private String mTitle;

    public Recycler_Subscription(String imageView, String mTitle) {
        this.imageView = imageView;
        this.mTitle = mTitle;
    }


    public String getImageView() {
        return imageView;
    }

    public String getmTitle() {
        return mTitle;
    }
}

