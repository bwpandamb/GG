package com.example.achar.javatokotlin.activity.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.fragment.BlankFragment;

/**
 * 这是一个简单的包含tablayout的fragment的复制版本
 * 我想使用这个fragment要显示tab在上面的这种形式
 *
 *
 * 我发现一个问题，当我使用同一个layout文件，会出现tablayout的一些bug问题
 * 即使使用不用的Layout文件，如果内部的控件名字一样一样会出现上面的问题
 * 这就是我建立这个fragment希望测试得到的东西
 *
 */

public class PageFragmentWithTablayout2 extends Fragment {
    public static final String ARGS_PAGE = "args_page";
//    private int mPage;
    private TabLayout tblView;
    private ViewPager vpView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_with_tablayout2, container, false);
        tblView = (TabLayout) view.findViewById(R.id.tbl_fg2);
        vpView = (ViewPager) view.findViewById(R.id.vp_fg2);

        vpView.setAdapter(new MyFragmentAdapter22(getFragmentManager(),getActivity()));

        tblView.setupWithViewPager(vpView);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    class MyFragmentAdapter22 extends FragmentPagerAdapter {
        private Context mContext;
        private String[] titles = new String[]{"Tab11", "Tab22"};

        public MyFragmentAdapter22(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            return new BlankFragment();
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
}