package com.example.achar.javatokotlin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.achar.javatokotlin.fragment.TabContentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tl_tab)
    TabLayout tlTab;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.tl_tab2)
    TabLayout tlTab2;
    @BindView(R.id.tl_tab3)
    TabLayout tlTab3;
    @BindView(R.id.tl_tab4)
    TabLayout tlTab4;
    @BindView(R.id.tl_tab5)
    TabLayout tlTab5;
    @BindView(R.id.tl_tab6)
    TabLayout tlTab6;

    private List<String> tabIndicators;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        initContent();
        initTab();

    }

    private void initContent() {
        tabIndicators = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tabIndicators.add("Tab " + i);
        }
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(TabContentFragment.newInstance(s));
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        vpContent.setAdapter(contentAdapter);
    }


    private void initTab() {
        tlTab.setTabMode(TabLayout.MODE_FIXED);
        tlTab.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        tlTab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));

        ViewCompat.setElevation(tlTab, 50);
        ViewCompat.setElevation(tlTab2, 40);
        ViewCompat.setElevation(tlTab3, 30);
        ViewCompat.setElevation(tlTab4, 0);
        ViewCompat.setElevation(tlTab5, -10);
        ViewCompat.setElevation(tlTab6, -20);


        test(tlTab);
        test(tlTab2);
        test(tlTab3);
        test(tlTab4);
        test(tlTab5);
        test(tlTab6);




    }

    private void test(TabLayout view) {
        view.setTabMode(TabLayout.MODE_FIXED);
        view.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        view.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        view.setupWithViewPager(vpContent);
    }


    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }
    }

}
