package com.example.achar.javatokotlin.activity.fragmentTabHost;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import com.example.achar.javatokotlin.R;

public class Activity4FragmentTabHost extends AppCompatActivity {

    private FragmentTabHost fragmentTabHost;

    private Class<?> mFragmentClasses[] = {FragmentOne.class, FragmentTwo.class};

    private String[] text = {"标签一", "标签二"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_fragment_tab_host);

        fragmentTabHost = (FragmentTabHost) findViewById(R.id.tabhost);

        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);


        for (int i = 0; i < text.length; i++) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(i + "").setIndicator(getIndicatorView(i));

            fragmentTabHost.addTab(tabSpec, mFragmentClasses[i], null);
        }

    }




    private View getIndicatorView(int i){

        View view = View.inflate(this, R.layout.layout_indicator_view, null);


        return view;
    }
}
