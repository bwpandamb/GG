package com.example.achar.javatokotlin.activity.appbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achar.javatokotlin.R;

public class AppBarActivity2 extends AppCompatActivity {


    private RecyclerView mContentRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar2);


        mContentRv = (RecyclerView) findViewById(R.id.rv_content);
        mContentRv.setLayoutManager(new LinearLayoutManager(this));
        mContentRv.setAdapter(new ContentAdapter());
    }



    private class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder> {

        @Override
        public ContentAdapter.ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ContentHolder(LayoutInflater.from(AppBarActivity2.this).inflate(R.layout
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
