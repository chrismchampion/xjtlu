package cn.edu.xjtlu.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class ServiceTest extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_test);
		Button playBtn = findViewById(R.id.playBtn);
		playBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(ServiceTest.this, MyService.class);
				bindService(intent, mConnection, BIND_AUTO_CREATE);
			}
		});
	}

	MyService myService;
	boolean myServiceConnected;
	ServiceConnection mConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
			MyService.MyBinder myBinder = (MyService.MyBinder) iBinder;
			myService = myBinder.getService();
			myServiceConnected = true;
			myService.play();
		}

		@Override
		public void onServiceDisconnected(ComponentName componentName) {
			myService = null;
			myServiceConnected = false;
		}
	};

	@Override
	protected void onStop() {
		super.onStop();
		if (myServiceConnected) {
			unbindService(mConnection);
			myServiceConnected = false;
		}
	}
}
