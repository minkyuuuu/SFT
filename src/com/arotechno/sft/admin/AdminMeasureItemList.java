package com.arotechno.sft.admin;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.arotechno.sft.R;

public class AdminMeasureItemList extends Activity {
	ArrayList<MeasurementItem> measurementItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_measure_item_list);

		final String[] item = { "배근력", "악력", "각근력", "상완근력", 
				"2분걷기", "좌전굴", "의자에 앉아 앞으로 굽히기", "견관절", 
				"타임드 업 앤 고", "누웠다 일어서기", "전신반응(빛)", "전신반응(소리)", 
				"눈감고 외발서기", "눈뜨고 외발서기" };

//		final String[] fromAge = { "65 ~ 69세", "70 ~ 74세", "75 ~ 79세", "80 ~ 100세" };
		final String[] fromAge = { "65", "70", "75", "80" };
		final String[] toAge = { "69", "74", "79", "100" };

		// list item 생성.
		measurementItems = new ArrayList<MeasurementItem>();
		for (int i = 0; i < item.length; i++) {
			MeasurementItem measurementItem = null;
			for (int j = 0; j < fromAge.length; j++) {
				measurementItem = new MeasurementItem(item[i], fromAge[j], toAge[j]);
				measurementItem.index = i;
				measurementItems.add(measurementItem);
			}
		}

		// ListView
		ListView listView = (ListView) findViewById(R.id.listview);
		MeasurementAdapter adapter = new MeasurementAdapter(this, R.layout.list_item_admin_measure_item_list, measurementItems);
		listView.setAdapter(adapter);
		listView.setDivider(null);
		
		// not Working because the first CheckBox in list-item takes click event
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MeasurementItem measurementItem = measurementItems.get(position);
                String temp = measurementItem.item + ", " + measurementItem.fromAge + " ~ " + measurementItem.toAge + "세";
                Toast.makeText(AdminMeasureItemList.this, temp, Toast.LENGTH_SHORT).show();
            }
        });
		
		// 글쓰기 버튼.
		Button writeButton = (Button) findViewById(R.id.admin_item_list_write);
		writeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminMeasureItemList.this, AdminMeasureItemSettingsWrite.class);
				startActivity(intent);
			}
		});
		
		// 삭제 버튼.
		// Todo : 기능 추가.
	}
	
	/**
	 * @brief 각 측정항목에 대한 값을 보여주고, 수정할 수 있음.
	 */
	void clickMeasureType(int position) {
        MeasurementItem measurementItem = measurementItems.get(position);
        String temp = measurementItem.item + ", " + measurementItem.fromAge + " ~ " + measurementItem.toAge + "세";
        Toast.makeText(AdminMeasureItemList.this, temp, Toast.LENGTH_SHORT).show();
        
        // move to show and update
		Intent intent = new Intent(AdminMeasureItemList.this, AdminMeasureItemDetails.class);
		intent.putExtra("item", measurementItem.item);
		intent.putExtra("fromAge", measurementItem.fromAge);
		intent.putExtra("toAge", measurementItem.toAge);
		startActivity(intent);
	}

	private class MeasurementAdapter extends ArrayAdapter<MeasurementItem> implements View.OnClickListener{

		Context context;
		int resourceId;
		ArrayList<MeasurementItem> measurementItems;

		public MeasurementAdapter(Context context, int resourceId, ArrayList<MeasurementItem> items) {
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
				measurementType.setOnClickListener(this);
				measurementType.setTag(String.valueOf(position));
				
				TextView age = (TextView) view.findViewById(R.id.age);
				if (measurementType != null) {
					measurementType.setText(measurementItem.item);
				}
				if (age != null) {
					String temp = measurementItem.fromAge + " ~ " + measurementItem.toAge + "세";
					age.setText(temp);
				}
			}
			
			return view;
		}

		@Override
		public void onClick(View v) {
			((AdminMeasureItemList)context).clickMeasureType( Integer.parseInt(v.getTag().toString()) );
		}
	}

	public class MeasurementItem{
		int index;
		String item;
		String fromAge;
		String toAge;

		public MeasurementItem(String item, String fromAge, String toAge) {
			this.item = item;
			this.fromAge = fromAge;
			this.toAge = toAge;
		}
	}
}
