package com.example.piratilgame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.piratilgame.Class.noTitle;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Search extends AppCompatActivity {

    ArrayList<cafeSearch_Model>  searchModels;
    RecyclerView recycler;
    cafeSearch_Adapter adapter;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         noTitle noTitle=new noTitle(this);
        setContentView(R.layout.activity_search);

        recycler=findViewById(R.id.cafeRecycler);
        searchModels=new ArrayList<>();
        adapter=new cafeSearch_Adapter(Search.this,searchModels);
        recycler.setLayoutManager(new LinearLayoutManager(Search.this));
        recycler.setAdapter(adapter);




    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
