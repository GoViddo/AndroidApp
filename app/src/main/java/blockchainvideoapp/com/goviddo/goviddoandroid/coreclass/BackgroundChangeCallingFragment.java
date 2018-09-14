package blockchainvideoapp.com.goviddo.goviddoandroid.coreclass;

import android.content.Context;

public class BackgroundChangeCallingFragment {

    public static int mFlag;
   public static Context mContext;

    public BackgroundChangeCallingFragment(int mFlag, Context mContext) {
        this.mFlag = mFlag;
        this.mContext = mContext;
    }


    public static int getFlag() {
        return mFlag;
    }

    public static Context getContext() {
        return mContext;
    }
}
