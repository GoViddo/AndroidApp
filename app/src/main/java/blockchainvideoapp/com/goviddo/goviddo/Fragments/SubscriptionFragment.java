package blockchainvideoapp.com.goviddo.goviddo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecyclerAdapterSubscription;
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecyclerAdapterSubscriptionCard;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.SubscriptionRecyclerModel;

public class SubscriptionFragment extends Fragment {

    public SubscriptionFragment() {
        // Required empty public constructor
    }


    RecyclerView mRecyclerViewPreview;

    private RecyclerAdapterSubscription mRecyclerAdapterPreview;
    private ArrayList<SubscriptionRecyclerModel> mRecyclerModelsPreview;

    LinearLayoutManager mLayoutManager;



    RecyclerView mRecyclerView;

    private RecyclerAdapterSubscriptionCard mRecyclerAdapter;
    private ArrayList<SubscriptionRecyclerModel> mRecyclerModels;

    LinearLayoutManager mLinearLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.subscription_fragment, container, false);

       String url ="https://pngimage.net/genie-aladdin-png-6/";

        mRecyclerModelsPreview = new ArrayList<SubscriptionRecyclerModel>();

        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsPreview.add( new SubscriptionRecyclerModel( url,"PS Films" ) );
        mRecyclerAdapterPreview = new RecyclerAdapterSubscription(mRecyclerModelsPreview);

        mRecyclerViewPreview =  view.findViewById(R.id.recycle_subscribe_roundimg);

        mLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );

        mRecyclerViewPreview.setLayoutManager( mLayoutManager );
        mRecyclerViewPreview.setHasFixedSize(true);

        //we can now set adapter to recyclerView;
        mRecyclerViewPreview.setAdapter( mRecyclerAdapterPreview );



       //The Code for CardView in Subscription Tab will be as Below

        String urlcard ="https://pngimage.net/genie-aladdin-png-6/";

        mRecyclerModels = new ArrayList<SubscriptionRecyclerModel>();

        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ) );
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerModels.add( new SubscriptionRecyclerModel( urlcard,"Happy Season 01 Ep01","The Goal is Near" ));
        mRecyclerAdapter = new RecyclerAdapterSubscriptionCard(mRecyclerModels);

        mRecyclerView =  view.findViewById(R.id.recycle_subscribe_cardvideo);

        mLinearLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false );

        mRecyclerView.setLayoutManager( mLinearLayoutManager );
        mRecyclerView.setHasFixedSize(true);

        //we can now set adapter to recyclerView;
        mRecyclerView.setAdapter( mRecyclerAdapter );



        return view;

    }
}
