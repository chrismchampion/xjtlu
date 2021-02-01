package cn.edu.xjtlu.graphicstest2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    private SurfaceView mySurfaceView;
    private SurfaceHolder surfaceHolder;
    private DrawingThread t = new DrawingThread();
    private DrawingThread2 t2 = new DrawingThread2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySurfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = mySurfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                t.start();
//                t2.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                t.doDrawing = false;
            }
        });
    }

    class DrawingThread extends Thread {
        public boolean doDrawing = true;
        final int CIRCLE_TICK_REVERT = 15;
        @Override
        public void run() {
            for(int tick = 0; doDrawing; tick = (tick + 1) % CIRCLE_TICK_REVERT) {
                Canvas canvas;
                if ((canvas = surfaceHolder.lockCanvas()) == null) {
                    // can happen when the app is paused.
                    continue;
                }
                canvas.drawColor(Color.WHITE);
                final int midX = canvas.getWidth()/2;
                final int midY = canvas.getHeight()/2;
                final int RADIUS = midX/5;

                Paint p = new Paint();
                p.setStrokeWidth(0);
                p.setStyle(Paint.Style.STROKE);
                p.setColor(Color.RED);
                canvas.drawRect(new Rect(midX - RADIUS, midY - RADIUS, midX + RADIUS, midY + RADIUS), p);
                p.setColor(Color.BLUE);
                int circleR = RADIUS * (10 + CIRCLE_TICK_REVERT - tick) / 15;
                canvas.drawCircle(midX, midY, circleR, p);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    // This is added to test the effect of surface locking
    // After calling surfaceHolder.lockCanvas()
    class DrawingThread2 extends Thread {
        public boolean doDrawing = true;
        final int CIRCLE_TICK_REVERT = 15;
        @Override
        public void run() {
            for(int tick = 0; doDrawing; tick = (tick + 1) % CIRCLE_TICK_REVERT) {
                Canvas canvas;
                if ((canvas = surfaceHolder.lockCanvas()) == null) {
                    // can happen when the app is paused.
                    System.out.println("oh no");
                    continue;
                }
                canvas.drawColor(Color.BLACK);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
