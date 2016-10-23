package com.example.shylock.shylock;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import helpers.Content;
import helpers.ListAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ArrayList<Content> items = new ArrayList<>();
        items.add(new Content("Halloween Marketing", "Septemeber 2016 - October 2016"));
        items.add(new Content("Black Friday Setup", "October 2016 - November 2016"));
        items.add(new Content("Thanksgiving Marketing", "October 2016 - November 2016"));
        items.add(new Content("Christmas Specials!", "November 2016 - December 2016"));
        items.add(new Content("Halloween Marketing", "Septemeber 2016 - October 2016"));
        items.add(new Content("Black Friday Setup", "October 2016 - November 2016"));
        items.add(new Content("Thanksgiving Marketing", "October 2016 - November 2016"));
        items.add(new Content("Christmas Specials!", "November 2016 - December 2016"));

        ListAdapter adapter = new ListAdapter(this, items);
        ListView lv = (ListView) findViewById(R.id.store_location);
        lv.setBackgroundResource(R.drawable.s1);
        lv.getBackground().setAlpha(40);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long arg3) {

        Intent i;

        switch(pos) {
            case 0:
                i = new Intent(this, DataActivity.class);
                startActivity(i);
                break;

            case 1:
                i = new Intent(this, DrawHeatMapActivity.class);
                Content c = (Content) av.getItemAtPosition(pos);
                String name = c.name.toString();
                i.putExtra("Name", name);
                startActivity(i);
                break;
        }

        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
