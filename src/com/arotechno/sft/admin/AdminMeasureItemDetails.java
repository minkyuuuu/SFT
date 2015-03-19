package com.arotechno.sft.admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.arotechno.sft.R;

public class AdminMeasureItemDetails extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_measure_item_settings);
		
		// 체력측정 항목 설정 
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		final String[] data = { "필수 입력사항 입니다.", "01.배근력", "02.악력", "03.각근력", "04.상완근력", 
				"05.2분걷기", "06.좌전굴", "07.의자에 앉아 앞으로 굽히기", "08.견관절", 
				"09.타임드 업 앤 고", "10.누웠다 일어서기", "11.전신반응(빛)", "12.전신반응(소리)", 
				"13.눈감고 외발서기", "14.눈뜨고 외발서기" };
		ArrayAdapter<String> adpater = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_measure_item, data);
		spinner.setAdapter(adpater);
		adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		// intent data
		Intent intent = getIntent();
		String item = intent.getStringExtra("item");
		String fromAge = intent.getStringExtra("fromAge");
		String toAge = intent.getStringExtra("toAge");
		
		// -----------------------
		// spinner 초기값 적용하기.
		// -----------------------
		// 1) 선택된 측정항목에 대한 index 구하기.
		int index = 0;
		for(int i = 0; i < data.length; i++) {
			if( data[i].contains(item)) {
				index = i;
				break;
			}
		}
		
		// 2) spinner에 초기값 적용.
		spinner.setSelection(index);
		
		// -------------------------
		// 연령 초기값 적용하기.
		// -------------------------
		((EditText) findViewById(R.id.admin_measure_item_settings_from_age)).setText(fromAge);
		((EditText) findViewById(R.id.admin_measure_item_settings_to_age)).setText(toAge);
		
		// -------------------------
		// 측정값 적용하기.
		// -------------------------
		// Todo : 자료구조 check.
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_1)).setText("84.50");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_1)).setText("100.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_2)).setText("69.50");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_2)).setText("84.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_3)).setText("50.50");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_3)).setText("69.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_4)).setText("38.50");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_4)).setText("50.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_5)).setText("0.00");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_5)).setText("38.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_6)).setText("47.00");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_6)).setText("100.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_7)).setText("38.00");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_7)).setText("46.50");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_8)).setText("23.50");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_8)).setText("37.50");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_9)).setText("0.50");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_9)).setText("23.00");
		
		((EditText) findViewById(R.id.admin_measure_item_settings_from_level_10)).setText("0.00");
		((EditText) findViewById(R.id.admin_measure_item_settings_to_level_10)).setText("0.00");
		
		
		// -------------------------
		// button event
		// -------------------------
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
