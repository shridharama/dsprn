package com.example.shylock.shylock;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import helpers.BarChartItem;
import helpers.ChartItem;
import helpers.LineChartItem;
import helpers.PieChartItem;

public class DataActivity extends AppCompatActivity {
    final int NUM_POINTS = 9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_listview_chart);

        ListView lv = (ListView) findViewById(R.id.listView1);

        ArrayList<ChartItem> list = new ArrayList<ChartItem>();

        // 30 items
        for (int i = 0; i < 3; i++) {

            if(i % 3 == 0) {
                list.add(new LineChartItem(generateDataLine(i + 1), getApplicationContext()));
            } else if(i % 3 == 1) {
                list.add(new BarChartItem(generateDataBar(i + 1), getApplicationContext()));
            } else if(i % 3 == 2) {
                list.add(new PieChartItem(generateDataPie(i + 1), getApplicationContext()));
            }
        }

        ChartDataAdapter cda = new ChartDataAdapter(getApplicationContext(), list);
        lv.setAdapter(cda);
    }

    /** adapter that supports 3 different item types */
    private class ChartDataAdapter extends ArrayAdapter<ChartItem> {

        public ChartDataAdapter(Context context, List<ChartItem> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getItem(position).getView(position, convertView, getContext());
        }

        @Override
        public int getItemViewType(int position) {
            // return the views type
            return getItem(position).getItemType();
        }

        @Override
        public int getViewTypeCount() {
            return 3; // we have 3 different item-types
        }
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private LineData generateDataLine(int cnt) {

        final int[] COLORSS = {
                Color.rgb(255, 208, 140),
                Color.rgb(140, 234, 255),
                Color.rgb(255, 140, 157)
        };

        float LINE_WIDTH= 3.5f;
        float CIRCLE_RADIUS = 6.5f;

        int[] D1_DATA = {150,140,120,141,112,151,110,200,210};

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < NUM_POINTS; i++) {
            e1.add(new Entry(i+9, D1_DATA[i]));
        }

        LineDataSet d1 = new LineDataSet(e1, Constants.CAMPAIGN_1);
        d1.setLineWidth(LINE_WIDTH);
        d1.setCircleRadius(CIRCLE_RADIUS);
        d1.setHighLightColor(COLORSS[0]);
        d1.setColor(COLORSS[0]);
        d1.setCircleColor(COLORSS[0]);
        d1.setDrawValues(false);

        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < NUM_POINTS; i++) {
            e2.add(new Entry(i+9, e1.get(i).getY() - 30));
        }

        LineDataSet d2 = new LineDataSet(e2, Constants.CAMPAIGN_2);
        d2.setLineWidth(LINE_WIDTH);
        d2.setCircleRadius(CIRCLE_RADIUS);
        d2.setHighLightColor(COLORSS[1]);
        d2.setColor(COLORSS[1]);
        d2.setCircleColor(COLORSS[1]);
        d2.setDrawValues(false);

        ArrayList<Entry> e3 = new ArrayList<Entry>();
        for (int i = 0; i < NUM_POINTS; i++) {
            e3.add(new Entry(i+9, e1.get(i).getY() + 30));
        }

        LineDataSet d3 = new LineDataSet(e3, Constants.CAMPAIGN_3);
        d3.setLineWidth(LINE_WIDTH);
        d3.setCircleRadius(CIRCLE_RADIUS);
        d3.setHighLightColor(COLORSS[2]);
        d3.setColor(COLORSS[2]);
        d3.setCircleColor(COLORSS[2]);
        d3.setDrawValues(false);


        ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
        sets.add(d1);
        sets.add(d2);
        sets.add(d3);

        LineData cd = new LineData(sets);
        return cd;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private BarData generateDataBar(int cnt) {
        final int[] COLORSS = {
                Color.rgb(255, 208, 140),Color.rgb(255, 208, 140),
                Color.rgb(140, 234, 255),Color.rgb(140, 234, 255),
                Color.rgb(255, 140, 157),Color.rgb(255, 140, 157)
        };
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 6; i++) {
            entries.add(new BarEntry(i, (int) (Math.random() * 70) + 30));
        }

        BarDataSet d = new BarDataSet(entries, "New DataSet " + cnt);
        d.setColors(COLORSS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(d);
        cd.setBarWidth(0.9f);
        return cd;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private PieData generateDataPie(int cnt) {
        int[] D1_DATA = {50,40,10};
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        final int[] COLORSS = {
                Color.rgb(255, 208, 140),
                Color.rgb(140, 234, 255),
                Color.rgb(255, 140, 157)
        };

        entries.add(new PieEntry(D1_DATA[0], Constants.CAMPAIGN_1));
        entries.add(new PieEntry(D1_DATA[1], Constants.CAMPAIGN_2));
        entries.add(new PieEntry(D1_DATA[2], Constants.CAMPAIGN_3));


        PieDataSet d = new PieDataSet(entries, "");

        // space between slices
        d.setSliceSpace(2f);
        d.setColors(COLORSS);

        PieData cd = new PieData(d);
        return cd;
    }

}