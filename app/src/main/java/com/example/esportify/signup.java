package com.example.esportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    EditText firsName, phoneNumber, emailID, secondName, passwordSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firsName = findViewById(R.id.etfirstname);
        phoneNumber = findViewById(R.id.phoenNUmber);
        emailID = findViewById(R.id.emailID);
        secondName = findViewById(R.id.secondName);
        passwordSignUp = findViewById(R.id.passwordSignUp);
    }

    public void registerButton(View view) {

        String username, phone, email, name, password;

        username = firsName.getText().toString();
        phone = phoneNumber.getText().toString();
        email = emailID.getText().toString();
        name = secondName.getText().toString();
        password = passwordSignUp.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://manipulative-recrui.000webhostapp.com/ESportify/userRegister.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("urlafvbalfbvef",url);

                        if (!response.equals("Not")) {

                            Toast.makeText(signup.this, "You have Registered Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(signup.this, home.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(signup.this, "Please Login with different Username,email,Password!!", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("User_name", username);
                map.put("Email", email);
                map.put("Contact", phone);
                map.put("Password", password);
                map.put("User_role", "user");
                map.put("Name", name);

                return map;
            }
        };
        queue.add(stringRequest);


    }
}