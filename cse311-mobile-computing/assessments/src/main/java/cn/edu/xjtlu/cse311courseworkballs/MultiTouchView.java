package cn.edu.xjtlu.cse311courseworkballs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchView extends View {

    private SparseArray<PointF> mActivePointers = new SparseArray<>();
    private Paint circlePaint = new Paint();

    int numBalls = 1;

    // arrays initialized with test values
    private int[] xPosBalls = {0, 200, 500};
    private int[] yPosBalls = {200, 200, 200};

    private int[] xVelBalls = {3, 4, 5};
    private int[] yVelBalls = {10, 5, 6};

    private final int CIR_RADIUS = 60;

    BallThread ballThread = new BallThread();

    class BallThread extends Thread {

        @Override
        public void run() {

            while (!this.isInterrupted()) {
                try {
                    MultiTouchView.this.postInvalidate();
                    Thread.sleep(16); // around 60fps

                } catch (InterruptedException e) {
                    return; // stop if this thread is interrupted
                }
            }
        }
    }

    // MultiTouchView constructor with attrs for inflation from XML
    public MultiTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw all pointers
        // numBalls limited in Activity addBall()
        for (int i = 0; i < numBalls; i++) {

            circlePaint.setColor(Color.BLUE);
            for (int j = 0; j < mActivePointers.size(); j++) {

                PointF point = mActivePointers.valueAt(j);
                if (point != null) {

                    if ((xPosBalls[i] - CIR_RADIUS < point.x) && (point.x < xPosBalls[i] + CIR_RADIUS) &&
                            (yPosBalls[i] - CIR_RADIUS < point.y) && (point.y < yPosBalls[i] + CIR_RADIUS)) {
                        circlePaint.setColor(Color.RED);
                        circlePaint.setStyle(Paint.Style.FILL);
                    }
                }
            }
            canvas.drawCircle(xPosBalls[i], yPosBalls[i], CIR_RADIUS, circlePaint);
        }

        updatePhysics();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {

                int pointerIndex = event.getActionIndex(); // get pointer index from the event object
                int pointerId = event.getPointerId(pointerIndex); // get pointer ID

                PointF f = new PointF();
                f.x = event.getX(pointerIndex);
                f.y = event.getY(pointerIndex);
                mActivePointers.put(pointerId, f);
                break;
            }
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < event.getPointerCount(); i++) {
                    PointF point = mActivePointers.get(event.getPointerId(i));
                    if (point != null) {
                        point.x = event.getX(i);
                        point.y = event.getY(i);
                    }
                }
                break;
        }
        invalidate();
        return true;
    }


    public void updatePhysics() {

        for (int i=0; i<3; i++) {

            yPosBalls[i] += yVelBalls[i];

            // y direction
            if (yPosBalls[i] - CIR_RADIUS < 0 || yPosBalls[i] + CIR_RADIUS > getHeight()) {
                // ball hit top or bottom of the canvas
                if (yPosBalls[i] - CIR_RADIUS < 0) {
                    // ball hit the top
                    yPosBalls[i] = CIR_RADIUS;
                } else {
                    // ball hit the bottom
                    yPosBalls[i] = getHeight() - CIR_RADIUS;
                }

                // reverse the y-direction of the ball
                yVelBalls[i] *= -1;
            }

            xPosBalls[i] += xVelBalls[i];

            // x direction
            if (xPosBalls[i] - CIR_RADIUS < 0 || xPosBalls[i] + CIR_RADIUS > getWidth()) {
                // ball hit the sides of the canvas
                if (xPosBalls[i] - CIR_RADIUS < 0) {
                    // ball hit the left of the canvas
                    // reset x position to that of the ball's radius
                    xPosBalls[i] = CIR_RADIUS;
                } else {
                    // the ball has hit the right of the canvas
                    // reset x position to that of the width of the surface frame's minus the ball's
                    // radius.
                    xPosBalls[i] = getWidth() - CIR_RADIUS;
                }
                // reverse the x-direction of the ball
                xVelBalls[i] *= -1;
            }
        }
    }

}
