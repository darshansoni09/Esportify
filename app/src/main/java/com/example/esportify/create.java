package com.example.esportify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class create extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spingame;
    Spinner spinmode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        spingame=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> gameadapter = ArrayAdapter.createFromResource(this,R.array.games, android.R.layout.simple_spinner_item);
        gameadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spingame.setAdapter(gameadapter);
        spingame.setOnItemSelectedListener(this);

        spinmode=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> modeadapter = ArrayAdapter.createFromResource(this,R.array.modes, android.R.layout.simple_spinner_item);
        gameadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinmode.setAdapter(modeadapter);
        spinmode.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}