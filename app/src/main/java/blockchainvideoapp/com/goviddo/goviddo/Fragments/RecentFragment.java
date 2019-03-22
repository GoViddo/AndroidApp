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
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecyclerAdaptorListRecent;
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecyclerAdaptorRecent;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.RecentRecyclerModel;

public class RecentFragment extends Fragment {

    public RecentFragment() {
        // Required empty public constructor
    }

    RecyclerView mRecyclerViewRecentImage;
    private RecyclerAdaptorRecent mRecyclerAdapterRecentImage;
    private ArrayList<RecentRecyclerModel> mRecyclerModelsRecentImage;
    LinearLayoutManager mLinearLayoutManagerRecentImage;


    RecyclerView mRecyclerViewRecentList;
    private RecyclerAdaptorListRecent mRecyclerAdapterRecentList;
    private ArrayList<RecentRecyclerModel> mRecyclerModelsRecentList;
    LinearLayoutManager mLinearLayoutManagerRecentList;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recent_fragment, container, false);

        String url ="https://pngimage.net/genie-aladdin-png-6/";
        mRecyclerModelsRecentImage = new ArrayList<>();
        mRecyclerModelsRecentImage.add( new RecentRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsRecentImage.add( new RecentRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsRecentImage.add( new RecentRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsRecentImage.add( new RecentRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsRecentImage.add( new RecentRecyclerModel( url,"PS Films" ) );
        mRecyclerModelsRecentImage.add( new RecentRecyclerModel( url,"PS Films" ) );
        mRecyclerAdapterRecentImage = new RecyclerAdaptorRecent(mRecyclerModelsRecentImage);


        mRecyclerViewRecentImage =  view.findViewById(R.id.image_recyler_view);

        mLinearLayoutManagerRecentImage = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );

        mRecyclerViewRecentImage.setLayoutManager( mLinearLayoutManagerRecentImage );
        mRecyclerViewRecentImage.setHasFixedSize(true);

        //we can now set adapter to recyclerView;
        mRecyclerViewRecentImage.setAdapter( mRecyclerAdapterRecentImage );

        //The Code for CardView in recent

        mRecyclerModelsRecentList = new ArrayList<>();
        mRecyclerModelsRecentList.add( new RecentRecyclerModel( "History" ) );
        mRecyclerModelsRecentList.add( new RecentRecyclerModel( "Privacy" ) );
        mRecyclerModelsRecentList.add( new RecentRecyclerModel( "Account" ) );
        mRecyclerModelsRecentList.add( new RecentRecyclerModel( "Transaction" ) );
        mRecyclerModelsRecentList.add( new RecentRecyclerModel( "Watch Later" ) );


        mRecyclerAdapterRecentList = new RecyclerAdaptorListRecent(mRecyclerModelsRecentList);

        mRecyclerViewRecentList = view.findViewById( R.id.list_recyler_view);
        mLinearLayoutManagerRecentList = new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false );

        mRecyclerViewRecentList.setLayoutManager( mLinearLayoutManagerRecentList );

        //we can now set adapter to recyclerView;
        mRecyclerViewRecentList.setAdapter( mRecyclerAdapterRecentList );

        return view;



    }
}
