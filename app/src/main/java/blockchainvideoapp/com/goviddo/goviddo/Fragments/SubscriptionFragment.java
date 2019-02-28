package blockchainvideoapp.com.goviddo.goviddo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecycleAdapterSubscription;
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecyclerAdapter;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.RecyclerModel;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.Recycler_Subscription;

public class SubscriptionFragment extends Fragment {

    public SubscriptionFragment() {
        // Required empty public constructor
    }


    RecyclerView mRecyclerViewPreview;

    private RecycleAdapterSubscription mRecyclerAdapterPreview;
    private ArrayList<Recycler_Subscription> mRecyclerModelsPreview;

    ProgressWheel mProgressWheelPreview;

    LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.subscription_fragment, container, false);
       String url ="https://pngimage.net/genie-aladdin-png-6/";
        mRecyclerModelsPreview = new ArrayList<>();
        mRecyclerModelsPreview.add( new Recycler_Subscription( url ) );
        mRecyclerAdapterPreview = new RecycleAdapterSubscription(mRecyclerModelsPreview);

        mRecyclerViewPreview =  view.findViewById(R.id.recycle_subscribe_roundimg);

        mLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );

        mRecyclerViewPreview.setLayoutManager( mLayoutManager );

        //we can now set adapter to recyclerView;
        mRecyclerViewPreview.setAdapter( mRecyclerAdapterPreview );






        return view;

    }
}
