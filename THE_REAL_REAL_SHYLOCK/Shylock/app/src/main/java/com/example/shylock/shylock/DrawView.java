package com.example.shylock.shylock;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.graphics.Paint;
/**
 * Created by achint on 10/23/16.
 */

public class DrawView extends View {

    Paint mPiePaint;
    int x = 100;
    int y = 300;
    private void init(){

        mPiePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint.setStyle(Paint.Style.FILL);
        mPiePaint.setTextSize(5);
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setBackgroundResource(R.drawable.map);
        canvas.drawCircle(x, y, 30, mPiePaint);
    }
}
