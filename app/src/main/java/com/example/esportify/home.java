package com.example.esportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class home extends AppCompatActivity {
    ImageButton b ,b1 ,b2;
    FloatingActionButton c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        b = (ImageButton) findViewById(R.id.valo);
        b1 = (ImageButton) findViewById(R.id.pubg);
        b2 = (ImageButton) findViewById(R.id.brawlstars);
        c = (FloatingActionButton) findViewById(R.id.cre);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.leaderboard:
                        startActivity(new Intent(getApplicationContext()
                                ,leaderboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),user.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(), create.class);
                startActivity(c);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), tournament.class);
                i.putExtra("imgsrc",R.mipmap.valorant);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext(), tournament.class);
                p.putExtra("imgsrc",R.mipmap.pubg);
                startActivity(p);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(getApplicationContext(), tournament.class);
                q.putExtra("imgsrc",R.mipmap.brawlstars);
                startActivity(q);
                finish();
            }
        });
    }


}