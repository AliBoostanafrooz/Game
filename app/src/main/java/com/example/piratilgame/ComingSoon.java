package com.example.piratilgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.piratilgame.Class.noTitle;

public class ComingSoon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noTitle noTitle=new noTitle(this);
        setContentView(R.layout.activity_coming_soon);
    }

}
