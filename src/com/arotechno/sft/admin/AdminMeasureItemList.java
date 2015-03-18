package com.arotechno.sft.admin;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.arotechno.sft.R;

public class AdminMeasureItemList extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_measure_item_list);

		final String[] item = { "배근력", "악력", "각근력", "상완근력", 
				"2분걷기", "좌전굴", "의자에 앉아 앞으로 굽히기", "견관절", 
				"타임드 업 앤 고", "누웠다 일어서기", "전신반응(빛)", "전신반응(소리)", 
				"눈감고 외발서기", "눈뜨고 외발서기" };

		final String[] age = { "65 ~ 69세", "70 ~ 74세", "75 ~ 79세", "80 ~ 100세" };

		// list item 생성.
		ArrayList<MeasurementItem> measurementItems = new ArrayList<MeasurementItem>();
		for (int i = 0; i < item.length; i++) {
			MeasurementItem measurementItem = null;
			for (int j = 0; j < age.length; j++) {
				measurementItem = new MeasurementItem(item[i], age[j]);
				measurementItem.index = i;
				measurementItems.add(measurementItem);
			}
		}

		// ListView
		ListView listView = (ListView) findViewById(R.id.listview);
		MeasuremnetAdapter adapter = new MeasuremnetAdapter(this, R.layout.list_item_admin_measure_item_list, measurementItems);
		listView.setAdapter(adapter);
		listView.setDivider(null);
		
		Button writeButton = (Button) findViewById(R.id.admin_item_list_write);
		writeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminMeasureItemList.this, AdminMeasureItemSettings.class);
				startActivity(intent);
			}
		});
	}

	private class MeasuremnetAdapter extends ArrayAdapter<MeasurementItem> {

		Context context;
		int resourceId;
		ArrayList<MeasurementItem> measurementItems;

		public MeasuremnetAdapter(Context context, int resourceId, ArrayList<MeasurementItem> items) {
			super(context, resourceId, items);
			
			this.context = context;
			this.resourceId = resourceId;
			this.measurementItems = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			
			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(resourceId, parent, false);
			}
			
			MeasurementItem measurementItem = measurementItems.get(position);
			if (measurementItem != null) {
				LinearLayout background = (LinearLayout) view.findViewById(R.id.item_list_background);
				if(measurementItem.index % 2 == 0)
					background.setBackgroundColor(Color.parseColor("#ffeeeeee"));
				else 
					background.setBackgroundColor(Color.parseColor("#ffe0e0e0"));
				
				TextView measurementType = (TextView) view.findViewById(R.id.measurement_type);
				TextView age = (TextView) view.findViewById(R.id.age);
				if (measurementType != null) {
					measurementType.setText(measurementItem.item);
				}
				if (age != null) {
					age.setText(measurementItem.age);
				}
			}
			
			return view;
		}
	}

	public class MeasurementItem {
		int index;
		String item;
		String age;

		public MeasurementItem(String item, String age) {
			this.item = item;
			this.age = age;
		}
	}
}
