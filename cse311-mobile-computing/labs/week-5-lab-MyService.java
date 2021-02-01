package cn.edu.xjtlu.testapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.widget.Toast;

import java.io.FileDescriptor;

public class MyService extends Service {
	class MyBinder extends Binder {
		public MyService getService() {
			return MyService.this;
		}
	}
	private IBinder binder = new MyBinder();
	MediaPlayer player;
	@Override
	public IBinder onBind(Intent intent) {
		player = MediaPlayer.create(this, R.raw.sample_song);
		return binder;
	}

	public void play() {
		if (!isPlaying())
			player.start();
	}

	public boolean isPlaying() {
		if (player != null) {
			return player.isPlaying();
		} else {
			return false;
		}
	}
}
