package blockchainvideoapp.com.goviddo.goviddoandroid.coreclass;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import blockchainvideoapp.com.goviddo.goviddoapp.R;

public class BackgrounFullLayoutChange {


    ConstraintLayout mConstraintLayout;
    CoordinatorLayout mCoordinatorLayout;
    LinearLayout mLinearLayout;
    RelativeLayout mRelativeLayout;
    FrameLayout mFrameLayout;
    TextView mTextView;
    CardView mCardView;



    public static int mFlag;

    Context mContext;

    public ConstraintLayout getConstraintLayout() {
        return mConstraintLayout;
    }

    public void setConstraintLayout(ConstraintLayout constraintLayout) {
        this.mConstraintLayout = constraintLayout;
    }

    public CoordinatorLayout getCoordinatorLayout() {
        return mCoordinatorLayout;
    }

    public void setCoordinatorLayout(CoordinatorLayout coordinatorLayout, Context context) {
        this.mCoordinatorLayout = coordinatorLayout;
        this.mContext = context;


        if (mFlag == 1)
        {
            mCoordinatorLayout.setBackgroundColor(context.getResources().getColor(R.color.backgroundColorNormal));
        }
        else if (mFlag == 2){
            mCoordinatorLayout.setBackgroundColor(context.getResources().getColor(R.color.backgroundColorChange));
        }

    }

    public LinearLayout getLinearLayout() {
        return mLinearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.mLinearLayout = linearLayout;
    }

    public RelativeLayout getRelativeLayout() {
        return mRelativeLayout;
    }

    public void setRelativeLayout(RelativeLayout relativeLayout) {
        this.mRelativeLayout = relativeLayout;
    }

    public FrameLayout getFrameLayout() {
        return mFrameLayout;
    }

    public void setFrameLayout(FrameLayout frameLayout) {
        this.mFrameLayout = frameLayout;
    }

    public static int getFlag() {
        return mFlag;
    }

    public void setFlag(int flag) {
        this.mFlag = flag;
    }



    public void setTextView(TextView mTextView, Context context) {
        this.mTextView = mTextView;


        if (mFlag == 1)
        {
            mTextView.setTextColor(context.getResources().getColor(R.color.normalTextColor));
        }
        else if (mFlag == 2){
            mTextView.setTextColor(context.getResources().getColor(R.color.changeTextColor));
        }

    }


    public void setCardView(CardView mCardView,Context context) {
        this.mCardView = mCardView;

        if (mFlag == 1)
        {
            mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.backgroundColorNormal));
        }
        else if (mFlag == 2){
            mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.backgroundColorChange));
        }

    }
}

