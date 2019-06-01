package com.example.piratilgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.piratilgame.Class.noTitle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Complete_Profile extends Activity {

    private RadioGroup radiogroup1;
    private RadioGroup radiogroup2;
    private boolean isChecking = true;
    private int mCheckedId = R.id.radioFemale;
    EditText inputText;
    Button RegBTN;
    RequestQueue requestQueue;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noTitle noTitle = new noTitle(this);
        setContentView(R.layout.activity_complete__profile);

        radiogroup1 = (RadioGroup) findViewById(R.id.radioSex1);
        radiogroup2 = (RadioGroup) findViewById(R.id.radioSex2);
        inputText = findViewById(R.id.NameFamily);
        RegBTN = findViewById(R.id.Register);
        SharedPreferences sharedPreferences = getSharedPreferences("token", MODE_PRIVATE);
        sharedPreferences.edit().putString("token", getIntent().getStringExtra("token")).apply();
        final String String_from_SP = sharedPreferences.getString("token", getIntent().getStringExtra("token"));

        RegBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String NameFamily = inputText.getText().toString();
                StringRequest stringRequest = new StringRequest(
                        Request.Method.POST,
                        "http://piratil.com/game/method/method.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    Intent intent = new Intent(Complete_Profile.this, ComingSoon.class);
                                    intent.putExtra("token", jsonObject.getString("token"));
                                    startActivity(intent);
                                    finish();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                ) {
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> stringStringHashMap = new HashMap<>();
                        stringStringHashMap.put("NameFamily", NameFamily);
                        stringStringHashMap.put("token", String_from_SP);
                        stringStringHashMap.put("appVersion", "1");
                        stringStringHashMap.put("device", "android");
                        stringStringHashMap.put("method", "completeProfile");
                        return stringStringHashMap;
                    }
                };
                requestQueue.add(stringRequest);

            }
        });


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




