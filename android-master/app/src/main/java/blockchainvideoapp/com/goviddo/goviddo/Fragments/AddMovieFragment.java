package blockchainvideoapp.com.goviddo.goviddo.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import blockchainvideoapp.com.goviddo.goviddo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddMovieFragment extends Fragment {


    public AddMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false);
    }

}
