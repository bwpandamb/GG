package com.example.achar.javatokotlin.activity.progress_line;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.view.MyProgressLine;

public class ProgressLineActivity extends AppCompatActivity {

    private Button btn;
    private MyProgressLine myp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_line);

        btn = (Button) findViewById(R.id.btn);
        myp = (MyProgressLine) findViewById(R.id.myp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myp.setFenshu(500);

            }
        });


    }
}
