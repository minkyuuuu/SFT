package com.arotechno.sft.admin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

import com.arotechno.sft.R;

public class AdminCreateUserData extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.admin_create_user_data);

		// 목록.
		RelativeLayout categoryButton = (RelativeLayout) findViewById(R.id.admin_measure_item_settings_category);
		categoryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		// 작성완료.
		RelativeLayout writeDoneButton = (RelativeLayout) findViewById(R.id.admin_measure_item_settings_write_done);
		writeDoneButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}
}
