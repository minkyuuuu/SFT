package com.arotechno.sft.admin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.arotechno.sft.R;

public class AdminMeasureItemSettingsWrite extends Activity {
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
