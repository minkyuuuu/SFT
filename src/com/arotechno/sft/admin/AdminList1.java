package com.arotechno.sft.admin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.arotechno.sft.R;

public class AdminList1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_list_1);
		
	}
}
