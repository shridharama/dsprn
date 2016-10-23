package com.example.shylock.shylock;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.os.Handler;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import helpers.GetHelper;

public class DrawHeatMapActivity extends Activity {

    Handler uiThread = new Handler();
    DrawView dv;

    private Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            try {
                String response = new GetHelper().execute("").get();
                //Toast.makeText(DrawHeatMapActivity.this,response,Toast.LENGTH_LONG).show();
                JSONObject responseJson = new JSONObject(response);
                JSONArray heatMap = responseJson.getJSONArray("heat_map");
                String beacon_id = "";
                for (int i = 0; i < 1; ++i) {
                    JSONObject rec = heatMap.getJSONObject(i);
                    beacon_id = rec.getString("beacon_id");
                    // ...
                }
                //Toast.makeText(DrawHeatMapActivity.this,beacon_id,Toast.LENGTH_LONG).show();
                if (beacon_id.equals("7639")){
                    x = 50;
                    y = 200;
                } else if(beacon_id.equals("41771")){
                    x = 150;
                    y = 200;
                } else {
                    x = 100;
                    y = 50;
                }



                dv.x = x;
                dv.y = y;
                dv.invalidate();
                uiThread.postDelayed(runnable, 5000);
            }
            catch(Exception e){}

        }
    }; //10 secs delay
    int x = 1;
    int y = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_draw_heat_map);
        //RelativeLayout rv = (RelativeLayout) findViewById(R.id.activity_draw_heat_map);
        dv = new DrawView(this);
        //rv.addView(dv);
        setContentView(dv);


        uiThread.post(runnable);

    }
}


