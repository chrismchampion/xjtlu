package cn.edu.xjtlu.cse311courseworkballs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch);

        MultiTouchView multiTouchView = findViewById(R.id.multiTouchView);
        multiTouchView.ballThread.start();
    }

    public void addBall(View view) {
        MultiTouchView multiTouchView = findViewById(R.id.multiTouchView);
        if (multiTouchView.numBalls < 3) {
            multiTouchView.numBalls++;
        } else {
            Button addButton = findViewById(R.id.buttonAddBall);
            addButton.setText(R.string.no_balls);
        }
    }

}
