package com.example.miguel909.bh2018;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by miguel909 on 27/01/2018.
 */

public class BrowseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.browse_fragment, container, false);

        GridView gridView = view.findViewById(R.id.browse_grid);
        gridView.setAdapter(new CategoryAdapter(getActivity()));

        return view;
    }
}
