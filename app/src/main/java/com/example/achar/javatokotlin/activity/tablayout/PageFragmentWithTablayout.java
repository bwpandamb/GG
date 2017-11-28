package com.example.achar.javatokotlin.activity.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.adapter.BasePagerAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;


/**
 * 这是一个简单的包含tablayout的fragment
 * 我想使用这个fragment要显示tab在上面的这种形式
 */
public class PageFragmentWithTablayout extends Fragment {
    public static final String ARGS_PAGE = "args_page";
//    private int mPage;
    private TabLayout tblView;
    private ViewPager vpView;
    private List<Fragment> fragmentList;

    public static PageFragmentWithTablayout newInstance(int page) {
        Bundle args = new Bundle();

        args.putInt(ARGS_PAGE, page);
        PageFragmentWithTablayout fragment = new PageFragmentWithTablayout();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARGS_PAGE);
        fragmentList = new ArrayList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_with_tablayout, container, false);
        tblView = (TabLayout) view.findViewById(R.id.tbl_fg);
        vpView = (ViewPager) view.findViewById(R.id.vp_fg);



        for (int i = 0; i < 4; i++) {
            fragmentList.add(PageFragment.newInstance(i));
        }
        BasePagerAdapter basePagerAdapter = new BasePagerAdapter(getFragmentManager(), fragmentList, new
                String[]{"标签1", "标签2"});

//        vpView.setAdapter(new MyFragmentAdapter(getFragmentManager(),getActivity()));
        vpView.setAdapter(basePagerAdapter);
        tblView.setupWithViewPager(vpView);


        new QBadgeView(getContext())
                .setBadgeNumber(91)
                .setGravityOffset(2, 2, true)
                .bindTarget(getTabView(tblView, 0))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState) {
                        }
//                            Toast.makeText(BadgeViewActivity.this, R.string.tips_badge_removed, Toast.LENGTH_SHORT)
// .show();
                    }
                });

        setIndicator(getActivity(),tblView,60,60);
        LinearLayout linearLayout = (LinearLayout) tblView.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));
        return view;
    }

    //这个方法是用来控制Tablayout下面那个线长短的（居然也需要使用反射）
    public static void setIndicator(Context context, TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int left = (int) (context.getResources().getDisplayMetrics().density * leftDip);
        int right = (int) (context.getResources().getDisplayMetrics().density * rightDip);

        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    class MyFragmentAdapter extends FragmentPagerAdapter {
        private Context mContext;
        private String[] titles = new String[]{"Tab11", "Tab22","Tab33", "Tab44"};

        public MyFragmentAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}