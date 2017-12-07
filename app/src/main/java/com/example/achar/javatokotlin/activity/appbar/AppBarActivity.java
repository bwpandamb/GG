package com.example.achar.javatokotlin.activity.appbar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.utilities.DisplayUtil;

public class AppBarActivity extends AppCompatActivity {
    private SwipeRefreshLayout mRefreshSrl;
    private RecyclerView mContentRv;
    private Toolbar mToolbarTb;
    private CollapsingToolbarLayout ctlTitle;
    private LinearLayout mbLl;
    private ImageView ivMb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);

        mToolbarTb = (Toolbar) findViewById(R.id.tb_toolbar);
        if (mToolbarTb != null) {
            setSupportActionBar(mToolbarTb);  //如果没有这句，标题的位置在收起来的情况下，很奇怪！！

//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mContentRv = (RecyclerView) findViewById(R.id.rv_content);
        mContentRv.setLayoutManager(new LinearLayoutManager(this));
        mContentRv.setAdapter(new ContentAdapter());

        mRefreshSrl = (SwipeRefreshLayout) findViewById(R.id.srl_refresh);
        mRefreshSrl.setColorSchemeResources(R.color.red, R.color.blue);

        ctlTitle = (CollapsingToolbarLayout) findViewById(R.id.col_toolbar);
        ctlTitle.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        mbLl = (LinearLayout) findViewById(R.id.mb_ll);
        ivMb = (ImageView) findViewById(R.id.iv_mb);

        ivMb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(ivMb, "点击后退（自己定义）", Snackbar.LENGTH_SHORT).show();
            }
        });

        makeTitleInCentre();

    }

    private void makeTitleInCentre() {
        //先拿到屏幕的宽高
        WindowManager wm = (WindowManager) AppBarActivity.this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //在拿到字体的宽
        float size = DisplayUtil.getTextWidth(AppBarActivity.this, "这是标题", 18);

        //动态设置左边这个控件父布局的宽，这样title就可以"恰好"出现在中间
        Toolbar.LayoutParams params = (Toolbar.LayoutParams) mbLl.getLayoutParams();
        params.width = (int) ((width - size) / 2.08); //肯定有什么计算的偏差（字体宽度算的不准？），除以二还是有一点点的偏差
        mbLl.setLayoutParams(params);
    }

    private class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {

        @Override
        public ContentAdapter.ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ContentHolder(LayoutInflater.from(AppBarActivity.this).inflate(R.layout
                    .item_simple_list_1, parent, false));
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ContentHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 50;
        }

        class ContentHolder extends RecyclerView.ViewHolder {

            public ContentHolder(View itemView) {
                super(itemView);

            }
        }

    }
}
