package blockchainvideoapp.com.goviddo.goviddo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddo.Fragments.HomeFragment;
import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.RecyclerCardViewModel;

public class Home_RecyclerAdapter_Cardview extends RecyclerView.Adapter<Home_RecyclerAdapter_Cardview.MyViewHolder> {


    private ArrayList<RecyclerCardViewModel> recyclerModels; // this data structure carries our title and description

    int mPosition;


    private Home_Video_Adapter mRecyclerAdapterVideo;
    private ArrayList<RecyclerCardViewModel> mRecyclerModelsVideo;
    LinearLayoutManager mLinearLayoutManagerVideo;

    String url1 ="https://pngimage.net/genie-aladdin-png-6/";


    public Home_RecyclerAdapter_Cardview(ArrayList<RecyclerCardViewModel> recyclerModels) {
        this.recyclerModels = recyclerModels;
    }

    @Override
    public Home_RecyclerAdapter_Cardview.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.home_video, parent, false );

        final MyViewHolder mViewHolder = new MyViewHolder( view );




        mViewHolder.textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( mViewHolder.context, recyclerModels.get( mViewHolder.getPosition() ).getHeading(), Toast.LENGTH_SHORT ).show();
            }
        } );


        // inflate your custom row layout here
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final Home_RecyclerAdapter_Cardview.MyViewHolder holder, int position) {

        mPosition = position;



        mRecyclerModelsVideo = new ArrayList<>();
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );
        mRecyclerModelsVideo.add( new RecyclerCardViewModel( url1,5) );

            holder.textView.setText(recyclerModels.get( mPosition ).getHeading()  );

            mRecyclerAdapterVideo = new Home_Video_Adapter(mRecyclerModelsVideo, holder.context);
            holder.recyclerView.setAdapter(mRecyclerAdapterVideo);
            mRecyclerAdapterVideo.notifyDataSetChanged();


            mLinearLayoutManagerVideo = new LinearLayoutManager(holder.context, LinearLayoutManager.HORIZONTAL, false);
            holder.recyclerView.setLayoutManager(mLinearLayoutManagerVideo);
            holder.recyclerView.setHasFixedSize(true);

            //we can now set adapter to recyclerView;
            Toast.makeText(holder.context, "size"+recyclerModels.size(), Toast.LENGTH_SHORT).show();


    }


    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our custom row layout, so intialize your variables here

       RecyclerView recyclerView;
        TextView textView;
        Context context;

        MyViewHolder(View view) {
            super( view );

            textView = view.findViewById( R.id.card_text);
            context = view.getContext();
          recyclerView = view.findViewById( R.id.video_recycler );


        }


    }
}

