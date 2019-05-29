package com.example.piratilgame;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class font extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("IRANSans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
