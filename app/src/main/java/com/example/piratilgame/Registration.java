package com.example.piratilgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText code;
    Button Register;
    Intent intentCode;
    String Rec_code;
    RequestQueue requestQueue;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        requestQueue = Volley.newRequestQueue(this);

        code = findViewById(R.id.Edt_Code);
        Register = findViewById(R.id.btn_Register);
        intentCode = getIntent();
        final String TextMobile = intentCode.getStringExtra("mobile");
//        Toast.makeText(this, TextMobile, Toast.LENGTH_SHORT).show();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rec_code = code.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(
                        Request.Method.POST,
                        "http://piratil.com/game/method/method.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    Intent intent = new Intent(Registration.this, Complete_Profile.class);
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
                        //TODO::
                    }
                }) {
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> stringStringHashMap = new HashMap<>();
                        stringStringHashMap.put("mobile", TextMobile);
                        stringStringHashMap.put("code", Rec_code);
                        stringStringHashMap.put("appVersion", "1");
                        stringStringHashMap.put("device", "android");
                        stringStringHashMap.put("method", "checkCode");
                        return stringStringHashMap;
                    }
                };
                requestQueue.add(stringRequest);

            }
        });
    }
}