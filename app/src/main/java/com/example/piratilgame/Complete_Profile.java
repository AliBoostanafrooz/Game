package com.example.piratilgame;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Complete_Profile extends Activity {

    private RadioGroup radiogroup1;
    private RadioGroup radiogroup2;
    private boolean isChecking = true;
    private int mCheckedId = R.id.radioFemale;
    EditText inputText;
    Button RegBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete__profile);

        radiogroup1 = (RadioGroup) findViewById(R.id.radioSex1);
        radiogroup2 = (RadioGroup) findViewById(R.id.radioSex2);
        inputText = findViewById(R.id.NameFamily);
        SharedPreferences sharedPreferences = getSharedPreferences("token", MODE_PRIVATE);
        sharedPreferences.edit().putString("token", getIntent().getStringExtra("token")).apply();


        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    radiogroup2.clearCheck();
                    mCheckedId = checkedId;
                    Snackbar.make(radiogroup1, "خوش آمدید خانم " + inputText.getText().toString(), Snackbar.LENGTH_LONG).show();

                }
                isChecking = true;

            }
        });
        radiogroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    radiogroup1.clearCheck();
                    mCheckedId = checkedId;
                    Snackbar.make(radiogroup2, "خوش آمدید آقای " + inputText.getText().toString(), Snackbar.LENGTH_LONG).show();
                }
                isChecking = true;
            }
        });

        RegBTN = findViewById(R.id.Register);

        RegBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


}




