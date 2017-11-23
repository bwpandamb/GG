package com.example.achar.javatokotlin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.fragment.BlankFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityGetSampFragment extends AppCompatActivity {

    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_samp_fragment);
        ButterKnife.bind(this);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_content, new BlankFragment())
                .commit();


    }
}
