package com.example.piratilgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.piratilgame.Class.noTitle;

public class Map extends AppCompatActivity {
     ImageView search;
     EditText searchName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noTitle noTitle=new noTitle(this);
        setContentView(R.layout.activity_map);

        searchName=findViewById(R.id.LocationSearch);
        search=findViewById(R.id.searchCafe);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mCafe=searchName.getText().toString().trim();
                if (mCafe.length()==0){
                    Toast.makeText(Map.this, "لطفاً ابتدا نام فروشگاه مورد نظر را وارد کنید سپس جستجو کنید", Toast.LENGTH_LONG).show();
                }else {
                    // TODO:: Looking for cafe in server and send to RecyclerView.
                }
            }
        });



    }
}
