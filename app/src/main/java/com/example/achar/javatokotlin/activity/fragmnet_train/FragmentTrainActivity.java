package com.example.achar.javatokotlin.activity.fragmnet_train;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.fragment.BlankFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentTrainActivity extends AppCompatActivity {

    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;
    private CardView itemOneCardView;
    private CardView itemTwoCardView;
    private TextView tvTitleOne;
    private TextView tvTitleTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_samp_fragment);
        ButterKnife.bind(this);

        View itemOne = findViewById(R.id.item_1);
        View itemTwo = findViewById(R.id.item_2);

        itemOneCardView = (CardView) itemOne.findViewById(R.id.cardview);
        itemTwoCardView = (CardView) itemTwo.findViewById(R.id.cardview);

        tvTitleOne = (TextView) itemOne.findViewById(R.id.textView);
        tvTitleTwo = (TextView) itemTwo.findViewById(R.id.textView);

        tvTitleOne.setText("add show hide");
        tvTitleTwo.setText("replace");


        itemOneCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentTrainActivity.this, FragmentAddShowHideActivity.class));
            }
        });


        itemTwoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentTrainActivity.this, FramgentReplaceActivity.class));
            }
        });


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_content, new BlankFragment())
                .commit();


    }

}
