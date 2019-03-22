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
import blockchainvideoapp.com.goviddo.goviddo.adapter.RecylerAdapterOthers;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.OtherRecyclerModel;


public class OthersFragment extends Fragment {


    public OthersFragment(){
        //Required empty public constructor
    }

    RecyclerView mRecyclerViewPreview;

    private RecylerAdapterOthers mRecyclerAdapterPreview;
    private ArrayList<OtherRecyclerModel> mRecyclerModelsPreview;

    LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate( R.layout.others_fragment, container, false );

        mRecyclerModelsPreview = new ArrayList<>();
        mRecyclerModelsPreview.add( new OtherRecyclerModel( "Setting" ) );
        mRecyclerModelsPreview.add( new OtherRecyclerModel( "Sign Out" ) );


        mRecyclerAdapterPreview = new RecylerAdapterOthers(mRecyclerModelsPreview);

        mRecyclerViewPreview = view.findViewById( R.id.recycle);
        mLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false );

        mRecyclerViewPreview.setLayoutManager( mLayoutManager );

        //we can now set adapter to recyclerView;
        mRecyclerViewPreview.setAdapter( mRecyclerAdapterPreview );

        return view;
    }


}