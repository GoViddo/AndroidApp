package blockchainvideoapp.com.goviddo.goviddo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.RecyclerCardViewModel;

public class Home_Video_Adapter extends RecyclerView.Adapter<Home_Video_Adapter.MyViewHolder> {

    private ArrayList<RecyclerCardViewModel> recyclerModels; // this data structure carries our title and description

    int mPosition;
    Context mContext;

    public Home_Video_Adapter(ArrayList<RecyclerCardViewModel> recyclerModels, Context context) {
        this.recyclerModels = recyclerModels;
        mContext = context;
    }

    @Override
    public Home_Video_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_image_recycler, parent, false);

        final Home_Video_Adapter.MyViewHolder mViewHolder = new Home_Video_Adapter.MyViewHolder(view);


        mViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, recyclerModels.get(mViewHolder.getPosition()).getVideoid(), Toast.LENGTH_SHORT).show();
            }
        });


        // inflate your custom row layout here
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final Home_Video_Adapter.MyViewHolder holder, int position) {
        mPosition = position;

        Picasso.with( mContext).load( recyclerModels.get( position ).getUrl() ).into( holder.ImageView );

    }


    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our custom row layout, so intialize your variables here

        CardView cardView;
        ImageView ImageView;



        MyViewHolder(View view) {
            super(view);


            ImageView = view.findViewById(R.id.video_image);
            Picasso.with( mContext ).load(u  ).into(ImageView );
            cardView = view.findViewById(R.id.video_image_card_view);



        }


    }
}
