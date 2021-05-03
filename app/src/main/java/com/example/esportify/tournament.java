package com.example.esportify;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class tournament extends AppCompatActivity {
Button p , b ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                        startActivity(new Intent(getApplicationContext()
                                ,user.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.image);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            int res_image = extras.getInt("imgsrc");
            imageView.setImageResource(res_image);
        }
        p = (Button) findViewById(R.id.participate);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast= Toast.makeText(getApplicationContext(),"Participated successfully",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        b = (Button) findViewById(R.id.bookmark);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast= Toast.makeText(getApplicationContext(),"Added bookmark",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}