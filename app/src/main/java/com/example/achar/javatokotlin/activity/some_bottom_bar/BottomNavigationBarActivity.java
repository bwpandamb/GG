package com.example.achar.javatokotlin.activity.some_bottom_bar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.activity.bottomNavBar.BottomNavigationViewHelper;
import com.example.achar.javatokotlin.activity.fragmnet_train.fragment.SampleFragment1;
import com.example.achar.javatokotlin.activity.fragmnet_train.fragment.SampleFragment2;
import com.example.achar.javatokotlin.activity.fragmnet_train.fragment.SampleFragment3;
import com.example.achar.javatokotlin.activity.tablayout.PageFragmentWithTablayout;
import com.example.achar.javatokotlin.activity.tablayout.PageFragmentWithTablayout2;
import com.example.achar.javatokotlin.activity.tablayout.TabLayoutFragment;


/**
 * 这个activity使用了谷歌官方的BottomNavigationView
 * 使用过程有一点点不舒服的就是，在item超过三个以后，显示的模式是shift形式的：就是只有选择到的那个会文字 图案都有
 * 其余只有图案
 * 解决方案就是BottomNavigationViewHelper这个类，使用了反射来实现
 *
 * 使用这个的缺陷在于，貌似无法定制item，只能使用官方提供的menu布局来填充
 * 如果想获取对应item的view，我现在也是做不到的，这就决定了我无法订制很多东西
 * 因此，这个控件不推荐使用
 *
 */
public class BottomNavigationBarActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigation_bar);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationview);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);

        showFragment(FRAGMENT_NEWS);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_news:
                        showFragment(0);
                        break;
                    case R.id.action_photo:
                        showFragment(1);
                        break;
                    case R.id.action_video:
                        showFragment(2);
                        break;
                    case R.id.action_media:
                        showFragment(3);
                        break;

                }
                return true;
            }
        });

    }


    private SampleFragment1 sampleFragment1;
    private SampleFragment2 sampleFragment2;
    private SampleFragment3 sampleFragment3;
    private PageFragmentWithTablayout pageFragmentWithTablayout;
    private PageFragmentWithTablayout2 pageFragmentWithTablayout2;
    private TabLayoutFragment tabLayoutFragment;

    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case FRAGMENT_NEWS:
//                toolbar.setTitle(R.string.app_name);
                /**
                 * 如果Fragment为空，就新建一个实例
                 * 如果不为空，就将它从栈中显示出来
                 */
//                if (newsTabLayout == null) {
//                    newsTabLayout = NewsTabLayout.getInstance();
//                    ft.add(R.id.container, newsTabLayout, NewsTabLayout.class.getName());
//                } else {
//                    ft.show(newsTabLayout);
//                }
//                if (sampleFragment1 == null) {
//                    sampleFragment1 = new SampleFragment1();
//                    ft.add(R.id.fl_content, sampleFragment1);
//                } else {
//                    ft.show(sampleFragment1);
//                }

                if (tabLayoutFragment == null) {
                    tabLayoutFragment = new TabLayoutFragment();
                    ft.add(R.id.fl_content, tabLayoutFragment);
                } else {
                    ft.show(tabLayoutFragment);
                }


                break;

            case FRAGMENT_PHOTO:
//                toolbar.setTitle(R.string.title_photo);
                if (sampleFragment2 == null) {
                    sampleFragment2 = new SampleFragment2();
                    ft.add(R.id.fl_content, sampleFragment2);
                } else {
                    ft.show(sampleFragment2);
                }
                break;

            case FRAGMENT_VIDEO:
//                toolbar.setTitle(getString(R.string.title_video));
                if (sampleFragment3 == null) {
                    sampleFragment3 = new SampleFragment3();
                    ft.add(R.id.fl_content, sampleFragment3);
                } else {
                    ft.show(sampleFragment3);
                }
                break;

            case FRAGMENT_MEDIA:
//                toolbar.setTitle(getString(R.string.title_media));
                if (pageFragmentWithTablayout == null) {
                    pageFragmentWithTablayout = new PageFragmentWithTablayout();
                    ft.add(R.id.fl_content, pageFragmentWithTablayout);
                } else {
                    ft.show(pageFragmentWithTablayout);
                }
        }

        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        // 如果不为空，就先隐藏起来
//        if (sampleFragment1 != null) {
//            ft.hide(sampleFragment1);
//        }

        if (tabLayoutFragment != null) {
            ft.hide(tabLayoutFragment);
        }
        if (sampleFragment2 != null) {
            ft.hide(sampleFragment2);
        }
        if (sampleFragment3 != null) {
            ft.hide(sampleFragment3);
        }
        if (pageFragmentWithTablayout != null) {
            ft.hide(pageFragmentWithTablayout);
        }

    }
}
