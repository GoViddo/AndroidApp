package blockchainvideoapp.com.goviddo.goviddo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.RecyclerCardViewModel;

public class Home_RecyclerAdapter_Cardview extends RecyclerView.Adapter<Home_RecyclerAdapter_Cardview.MyViewHolder> {


    private ArrayList<RecyclerCardViewModel> recyclerModels; // this data structure carries our title and description

    int mPosition;

    public Home_RecyclerAdapter_Cardview(ArrayList<RecyclerCardViewModel> recyclerModels) {
        this.recyclerModels = recyclerModels;
    }

    @Override
    public Home_RecyclerAdapter_Cardview.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.video_image_recycler, parent, false );

        final MyViewHolder mViewHolder = new MyViewHolder( view );


        mViewHolder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( mViewHolder.context, recyclerModels.get( mViewHolder.getPosition() ).getName(), Toast.LENGTH_SHORT ).show();
            }
        } );


        // inflate your custom row layout here
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final Home_RecyclerAdapter_Cardview.MyViewHolder holder, int position) {

        mPosition = position;

    }


    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our custom row layout, so intialize your variables here

        CardView cardView;
        ImageView VideoImageView;

        Context context;

        MyViewHolder(View view) {
            super( view );


            VideoImageView = view.findViewById( R.id.video_image );
            context = view.getContext();
            cardView = view.findViewById( R.id.video_image_card_view );


        }


    }
}

