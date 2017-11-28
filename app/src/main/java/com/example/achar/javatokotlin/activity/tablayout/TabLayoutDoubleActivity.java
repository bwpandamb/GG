package com.example.achar.javatokotlin.activity.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.fragment.BlankFragment;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class TabLayoutDoubleActivity extends AppCompatActivity {


    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    CustomViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_double);
        ButterKnife.bind(this);


        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), this);
        vp.setAdapter(adapter);
        vp.setScanScroll(false);
        vp.setOffscreenPageLimit(5);
        tl.setupWithViewPager(vp);

        new QBadgeView(this)
                .setBadgeNumber(11)
                .setGravityOffset(2, 2, true)
                .bindTarget(getTabView(tl, 0))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState) {
                        }
//                            Toast.makeText(BadgeViewActivity.this, R.string.tips_badge_removed, Toast.LENGTH_SHORT)
// .show();
                    }
                });


    }


    //通过这个方法就可以拿到每一个tablayout的子view
    public View getTabView(TabLayout tlView, int index) {
        View tabView = null;
        TabLayout.Tab tab = tlView.getTabAt(index);
        Field view = null;
        try {
            view = TabLayout.Tab.class.getDeclaredField("mView");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        view.setAccessible(true);
        try {
            tabView = (View) view.get(tab);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return tabView;
    }


    class MyFragmentAdapter extends FragmentPagerAdapter {
        private Context mContext;
        private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};

        public MyFragmentAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {

                return new PageFragmentWithTablayout();
            } else if (position == 1) {
                return new PageFragmentWithTablayout2();
            }
            return new BlankFragment();


        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


}
