package com.example.piratilgame;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.example.piratilgame.Class.noTitle;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {

    EditText phone;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noTitle noTitle=new noTitle(this);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.PhoneNumber);
        requestQueue = Volley.newRequestQueue(this);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void login(View view) {

        final String TextPhoneNumber = phone.getText().toString().trim();
        if (TextPhoneNumber.length() != 11) {
            Snackbar.make(view, "شماره تلفن اشتباه است", Snackbar.LENGTH_LONG).show();
        } else {
            final ProgressDialog progressDialog = new ProgressDialog(Login.this);
            progressDialog.setMessage("منتظر بمانید");
            progressDialog.setCancelable(false);
            progressDialog.show();

            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    "http://piratil.com/game/method/method.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                            Intent intent = new Intent(Login.this, Registration.class);
                            intent.putExtra("mobile", TextPhoneNumber);
                            startActivity(intent);
                            finish();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Login.this, "ارسال ناموفق", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    Log.w("Error", String.valueOf(error));
//                    Toast.makeText(Login.this, String.valueOf(error), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> stringStringHashMap = new HashMap<>();
                    stringStringHashMap.put("mobile", TextPhoneNumber);
                    stringStringHashMap.put("appVersion", "1");
                    stringStringHashMap.put("device", "android");
                    stringStringHashMap.put("method", "submitUser");
                    return stringStringHashMap;
                }
            };
            requestQueue.add(stringRequest);

        }
    }
}
