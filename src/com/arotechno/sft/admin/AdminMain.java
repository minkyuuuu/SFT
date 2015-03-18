package com.arotechno.sft.admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.arotechno.sft.R;

public class AdminMain extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_main);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		
		final String[] data = {"성남 고령친화종합체험관", "광명새움병원", "더본병원"};
		ArrayAdapter<String> adpater = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, data);
		spinner.setAdapter(adpater);
		adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
//		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//		    @Override
//		    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//		    }
//
//		    @Override
//		    public void onNothingSelected(AdapterView<?> arg0) {
//		    }
//		});

		Button list1Button = (Button) findViewById(R.id.admin_list_1);
		list1Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminMain.this, AdminList1.class);
				startActivity(intent);
			}
		});
		
		Button list2Button = (Button) findViewById(R.id.admin_list_2);
		list2Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminMain.this, AdminList2.class);
				startActivity(intent);
			}
		});
		
		Button itemSettingsButton = (Button) findViewById(R.id.admin_item_list);
		itemSettingsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminMain.this, AdminMeasureItemList.class);
				startActivity(intent);
			}
		});
		
		
		
	}
	

}
