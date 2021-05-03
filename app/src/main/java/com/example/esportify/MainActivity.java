package com.example.esportify;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
        EditText usr;
        EditText pwd;
        Button login;
        Button signup;
        private TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                login.setEnabled(true);
                if (usr.getText().toString().equals("") && pwd.getText().toString().equals("")) {
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
                }
            }
        };

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            usr = (EditText) findViewById(R.id.etusername);
            pwd = (EditText) findViewById(R.id.etpassword);
            login = (Button) findViewById(R.id.btnlogin);
            signup = (Button) findViewById(R.id.btnsignup);

            usr.addTextChangedListener(tw);
            pwd.addTextChangedListener(tw);

            if (usr.getText().toString().equals("") && pwd.getText().toString().equals("")) {
                login.setEnabled(false);
            } else {
                login.setEnabled(true);
            }

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //validate(usr==getText().toString(), pwd==getText().toString());
                    validate(usr.getText().toString(), pwd.getText().toString());
                    Intent si = new Intent(getApplicationContext(), home.class);
                    startActivity(si);
                }
            });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent si = new Intent(getApplicationContext(), signup.class);
                    startActivity(si);
                }
            });


        }
        void validate (String usname, String uspassword){
            if ((usname.equals("admin")) && (uspassword.equals("abc"))) {
                Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_LONG).show();
                Intent li = new Intent(getApplicationContext(), login.class);

                li.putExtra("user", usr.getText().toString());
                startActivity(li);
            } else {
                Toast.makeText(MainActivity.this, "incorrect username or password", Toast.LENGTH_LONG).show();
            }

        }
    }

