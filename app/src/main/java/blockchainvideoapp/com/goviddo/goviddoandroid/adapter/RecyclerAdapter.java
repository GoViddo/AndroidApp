package blockchainvideoapp.com.goviddo.goviddoandroid.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddoapp.R;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.BackgrounFullLayoutChange;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.BackgroundChangeCallingFragment;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.RecyclerModel;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<RecyclerModel> recyclerModels; // this data structure carries our title and description

    int mPosition;

    public RecyclerAdapter(ArrayList<RecyclerModel> recyclerModels) {
        this.recyclerModels = recyclerModels;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_layout, parent, false);

        final MyViewHolder mViewHolder = new MyViewHolder(view);

        mViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mViewHolder.context,recyclerModels.get(mViewHolder.getPosition()).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


        // inflate your custom row layout here
        return  mViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.MyViewHolder holder, int position) {


        mPosition = position;


        if (BackgroundChangeCallingFragment.getFlag() == 2)
        {
            BackgrounFullLayoutChange b = new BackgrounFullLayoutChange();
            b.setTextView(holder.title, holder.context);
          /*  b.setTextView(holder.description, holder.context);*/
            b.setCardView(holder.cardView,holder.context);
        }
        else if(BackgroundChangeCallingFragment.getFlag() == 1)
        {
            BackgrounFullLayoutChange b = new BackgrounFullLayoutChange();
            b.setTextView(holder.title, holder.context);
            /*b.setTextView(holder.description, holder.context);*/
            b.setCardView(holder.cardView,holder.context);
        }

        holder.title.setText(recyclerModels.get(position).getTitle());


    }







    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our custom row layout, so intialize your variables here

        private TextView title;
        CardView cardView;
        ImageView roundedImageView;

        Context context;

        MyViewHolder(View view) {
            super(view);


            roundedImageView = view.findViewById(R.id.title);
            title = (TextView) view.findViewById(R.id.description);
            context = view.getContext();

            cardView = view.findViewById(R.id.cardViewSingleItem);


        }




    }









}


