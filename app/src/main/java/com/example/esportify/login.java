package com.example.esportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class login extends AppCompatActivity {

    Button b;

    EditText username, password;

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etusername);
        password = findViewById(R.id.etpassword);


    }

    public void loginButton(View view) {

        String name, pass;
        name = username.getText().toString();
        pass = password.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://manipulative-recrui.000webhostapp.com/ESportify/userLogin.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("loginresponse", response);

                        Log.d("avjalfvblaifpau", url);
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObject1 = jsonObject.getJSONObject("0");

                            String loginString = jsonObject.getString("is_login");

                            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putString("User_id", jsonObject1.getString("User_id"));
                            editor.putString("User_name", jsonObject1.getString("User_name"));
                            editor.putString("Email", jsonObject1.getString("Email"));
                            editor.putString("Contact", jsonObject1.getString("Contact"));
                            editor.putString("Password", jsonObject1.getString("Password"));
                            editor.putString("User_role", jsonObject1.getString("User_role"));
                            editor.putString("Name", jsonObject1.getString("Name"));
                            editor.apply();

                            if (loginString.equals("yes")) {
                                Intent intent = new Intent(login.this, home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(login.this, "Not Registered!", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

//
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("User_name", name);
                map.put("Password", pass);
                return map;
            }
        };

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}




