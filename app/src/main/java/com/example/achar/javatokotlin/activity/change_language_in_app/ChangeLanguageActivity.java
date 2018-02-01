package com.example.achar.javatokotlin.activity.change_language_in_app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.achar.javatokotlin.R;
import com.franmontiel.localechanger.LocaleChanger;
import com.franmontiel.localechanger.utils.ActivityRecreationHelper;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeLanguageActivity extends AppCompatActivity {

    @BindView(R.id.btn_cn)
    Button btnCn;
    @BindView(R.id.btn_en)
    Button btnEn;
    @BindView(R.id.btn_ru)
    Button btnRu;
    @BindView(R.id.btn_in)
    Button btnIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);
        ButterKnife.bind(this);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = LocaleChanger.configureBaseContext(newBase);
        super.attachBaseContext(newBase);
    }

    @OnClick({R.id.btn_cn, R.id.btn_en, R.id.btn_ru, R.id.btn_in})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cn:
                LocaleChanger.setLocale(new Locale("zh","CN"));
                ActivityRecreationHelper.recreate(this, true);
                break;
            case R.id.btn_en:
                LocaleChanger.setLocale(new Locale("en","US"));
                ActivityRecreationHelper.recreate(this, true);
                break;
            case R.id.btn_ru:
                LocaleChanger.setLocale(new Locale("ru","RU"));
                ActivityRecreationHelper.recreate(this, true);
                break;
            case R.id.btn_in:
                LocaleChanger.setLocale(new Locale("in","IN"));
                ActivityRecreationHelper.recreate(this, true);
                break;
        }
    }
}
