package blockchainvideoapp.com.goviddo.goviddo.coreclass;

import android.widget.ImageView;

public class SubscriptionRecyclerModel {
    private String mDescription;
    private String mImageView;
    private String mTitle;

    public SubscriptionRecyclerModel(String imageView, String mTitle) {
        this.mImageView = imageView;
        this.mTitle = mTitle;
    }


    public String getImageView() {
        return mImageView;
    }

    public String getmTitle() {
        return mTitle;
    }

    public SubscriptionRecyclerModel(String imageView, String mTitle, String descriptiom) {
        this.mImageView = imageView;
        this.mTitle = mTitle;
        this.mDescription=descriptiom;
    }
    public String getmDescription() {
        return mDescription;
    }

}

