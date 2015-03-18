package com.arotechno.sft.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.arotechno.sft.R;
import com.arotechno.sft.admin.AdminMain;

public class Login extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

		Button loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Login.this, AdminMain.class);
				startActivity(intent);
			}
		});
	}

}
