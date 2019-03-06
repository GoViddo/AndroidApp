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

import java.util.ArrayList;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.RecyclerRecent;

public class RecyclerAdaptorList extends RecyclerView.Adapter<RecyclerAdaptorList.MyViewHolder> {
    private ArrayList<RecyclerRecent> recyclerModels; // this data structure carries our title and description


    int mPosition;

    public RecyclerAdaptorList(ArrayList<RecyclerRecent> recyclerModels) {
        this.recyclerModels = recyclerModels;

    }



    @Override
    public RecyclerAdaptorList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.recent_image, parent, false);

        final RecyclerAdaptorList.MyViewHolder mViewHolder = new RecyclerAdaptorList.MyViewHolder(view);

        mViewHolder.textView.setText( recyclerModels.get( mPosition ).getMtext() );

        mViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mViewHolder.context, recyclerModels.get(mViewHolder.getPosition()).getMtext(), Toast.LENGTH_SHORT).show();
            }
        });






        // inflate your custom row layout here
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdaptorList.MyViewHolder holder, int position) {
        mPosition = position;
        holder.textView.setText(recyclerModels.get( mPosition ).getMtext()  );

    }


    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our others_card layout, so intialize your variables here

        CardView cardView;
        TextView textView;
        Context context;


        MyViewHolder(View view) {
            super(view);

            textView = view.findViewById( R.id.txt_view_list );
            context = view.getContext();
            cardView = view.findViewById(R.id.list_card_view);

        }


    }
}

