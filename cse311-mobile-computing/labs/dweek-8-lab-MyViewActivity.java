package cn.edu.xjtlu.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyView(this));

    }
}
