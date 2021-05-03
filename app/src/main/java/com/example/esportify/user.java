package com.example.esportify;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class user extends AppCompatActivity {Button  a,d,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.leaderboard:
                        startActivity(new Intent(getApplicationContext()
                                , leaderboard.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.user:
                        return true;
                }

                return false;
            }
        });
        a = (Button) findViewById(R.id.book);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), bookmark.class);
                startActivity(i);
                finish();
            }
        });
        d = (Button) findViewById(R.id.hist);

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), history.class);
                startActivity(c);
                finish();
            }
        });
        f = (Button) findViewById(R.id.logout);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(getApplicationContext(), login.class);
                startActivity(x);
                finish();
            }
        });
    }

}