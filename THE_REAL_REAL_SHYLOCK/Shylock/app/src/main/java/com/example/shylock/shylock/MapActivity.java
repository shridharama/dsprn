package com.example.shylock.shylock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent i = getIntent();

        TextView tv = (TextView) findViewById(R.id.map_name);
        tv.setTextSize(40);
        tv.setText(i.getStringExtra("Name"));
    }
}
