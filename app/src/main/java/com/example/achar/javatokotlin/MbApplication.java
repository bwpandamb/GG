package com.example.achar.javatokotlin;

import android.app.Application;
import android.content.res.Configuration;

import com.franmontiel.localechanger.LocaleChanger;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by ext.charles.ma on 17/12/12.
 */

public class MbApplication extends Application {
    public static final List<Locale> SUPPORTED_LOCALES =
            Arrays.asList(
                    new Locale("en", "US"),
                    new Locale("in", "IN"),
                    new Locale("ru", "RU"),
                    new Locale("zh", "CN")
            );

    @Override
    public void onCreate() {
        super.onCreate();
        LocaleChanger.initialize(getApplicationContext(),SUPPORTED_LOCALES);
//        LocaleChanger.initialize(getApplicationContext(), SUPPORTED_LOCALES);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleChanger.onConfigurationChanged();
    }
}
