package com.example.achar.javatokotlin.activity.fragmnet_train.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achar.javatokotlin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment1 extends Fragment {


    public SampleFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample1, container, false);
    }

}
