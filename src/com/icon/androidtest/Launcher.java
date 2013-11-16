package com.icon.androidtest;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class Launcher extends Activity {

	
	String str = "R.drawable.ic_launcher1";
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		printSignatureKeyForFacebook();
		btn = (Button)findViewById(R.id.button1);
		
	
	btn.setOnTouchListener(new OnTouchListener() {
			
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:
				
					Toast.makeText(Launcher.this, "Down", Toast.LENGTH_SHORT).show();
					break;
				case MotionEvent.ACTION_UP:
					
					Toast.makeText(Launcher.this, "UP", Toast.LENGTH_SHORT).show();
					break;
			
				case MotionEvent.ACTION_MOVE:
					Toast.makeText(Launcher.this, "Move", Toast.LENGTH_SHORT).show();
					break;
				}
				return true;
			}
		});
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(Launcher.this, "Clicked", Toast.LENGTH_SHORT).show();
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launcher, menu);
		return true;
	}
	
	private void printSignatureKeyForFacebook() {
        try {
        PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
    } catch (NameNotFoundException e) {

    } catch (NoSuchAlgorithmException e) {

    }
}

}
