package com.example.achar.javatokotlin.activity.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.achar.javatokotlin.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutTrainActivity extends AppCompatActivity {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_train);
        ButterKnife.bind(this);


        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);

        LinearLayout linearLayout = (LinearLayout) tablayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.layout_divider_vertical));


    }


    class MyFragmentPageAdapter extends FragmentPagerAdapter {
        private Context mContext;
        public final int COUNT = 8;
        private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5","asdasdasdadasda","ass","a"};

        public MyFragmentPageAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
