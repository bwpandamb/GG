package com.example.achar.javatokotlin.activity.tablayout;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achar.javatokotlin.R;

/**
 * 这是一个简单的包含tablayout的fragment的复制版本
 * 我想使用这个fragment要显示tab在上面的这种形式
 *
 *
 * 我发现一个问题，当我使用同一个layout文件，会出现tablayout的一些bug问题（会有一个fragment的tablayout内容丢失，滑动卡死）
 * 即使使用不用的Layout文件，如果内部的控件名字一样一样会出现上面的问题
 * 这就是我建立这个fragment希望测试得到的东西
 *
 * 我就是使用这个fragment解决了上面的问题，找到了问题的根源，因为这个fragment就不存在那个问题
 * 我是在测试bottomNavBar的时候又遇到的了上面的问题，从而重新写了这个fragment解决了问题
 *
 */
public class TabLayoutFragment extends Fragment {


    TabLayout mbTablayout;
    ViewPager mbViewpager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_layout, container, false);


        mbTablayout = (TabLayout) view.findViewById(R.id.mb_tablayout);
        mbViewpager = (ViewPager) view.findViewById(R.id.mb_viewpager);

        mbViewpager.setAdapter(new MbFragmentAdapter(getFragmentManager(),getActivity()));

        mbTablayout.setupWithViewPager(mbViewpager);

        return view;
    }


    private class MbFragmentAdapter extends FragmentPagerAdapter {
        private String[] titles = new String[]{"Tab11", "Tab22"};
        private Context mContext;
        public MbFragmentAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
