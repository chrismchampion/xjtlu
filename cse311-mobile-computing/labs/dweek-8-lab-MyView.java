package cn.edu.xjtlu.drawtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;

class MyView extends View {
    private float[] mPts;
    private static final float DRAW_SIZE = 300;
    private static final int LINE_NUM = 32;
    public MyView(Context context) {
        super(context);
        buildPoints();
    }

    private void buildPoints() {
        final int ptCount = (LINE_NUM + 1) * 2;
        mPts = new float[ptCount * 2];
        float value = 0;
        final float delta = DRAW_SIZE / LINE_NUM;
        for (int i = 0; i <= LINE_NUM; i++) {
            mPts[i*4 + 0] = DRAW_SIZE - value;
            mPts[i*4 + 1] = 0;
            mPts[i*4 + 2] = 0;
            mPts[i*4 + 3] = value;
            value += delta;
        }
    }

    static int c = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(10, 10);
        //canvas.drawColor(Color.WHITE); // fill the background
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(c); // 0 means single pixel wide
        canvas.drawLines(mPts, p);
        p.setColor(Color.BLUE);
        p.setStrokeWidth(3);
        canvas.drawPoints(mPts, p);


        Resources res = getResources();
        BitmapDrawable bd = (BitmapDrawable) res.getDrawable(R.drawable.icon);
        bd.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.setBackground(bd);
    }
}
