package com.example.piratilgame.classes;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by piratil on 5/22/2019.
 */

public class noTitle {
    public noTitle(Activity context) {
        context.requestWindowFeature(Window.FEATURE_NO_TITLE);
        context.getWindow()
                .setFlags(WindowManager
                                .LayoutParams
                                .FLAG_FULLSCREEN,
                        WindowManager
                                .LayoutParams.FLAG_FULLSCREEN);
    }
}
