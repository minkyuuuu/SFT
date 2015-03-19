package com.arotechno.sft.admin;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.arotechno.sft.R;
import com.arotechno.sft.admin.AdminList2.Item;

public class AdminList1 extends Activity {
	ArrayList<ListType1Item> listType1Items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_list_1);
		
		// Todo : create database
		final String[][] data = { {"seum8311", "박봉덕", "66"},
				{"cloud2323", "김지미", "68"},
				{"flower123", "홍길동", "76"},
				{"box12", "이만길", "71"},
				{"sky0210", "김하늘", "74"}};
				
		// list item 생성.
		listType1Items = new ArrayList<ListType1Item>();
		for (int i = 0; i < data.length; i++) {
			listType1Items.add(new ListType1Item(i, data[i][0], data[i][1], data[i][2]));
		}
		
		// ListView
		ListView listView = (ListView) findViewById(R.id.listview);
		ListType1Adapter adapter = new ListType1Adapter(this, R.layout.list_item_admin_list_type_1, listType1Items);
		listView.setAdapter(adapter);
		
		// 작성하기.
		Button writeButton = (Button) findViewById(R.id.admin_item_list_type_1_write_do);
		writeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminList1.this, AdminCreateUserData.class);
				startActivity(intent);
			}
		});
		
	}

	/**
	 * @brief details
	 */
	void clickId(int position) {
		ListType1Item listType1Item = listType1Items.get(position);
        String temp = listType1Item.name + " " + listType1Item.age + "세";
        Toast.makeText(AdminList1.this, temp, Toast.LENGTH_SHORT).show();
        
        // move to show and update
		Intent intent = new Intent(AdminList1.this, AdminDetails1.class);
		intent.putExtra("kind", "all");
		intent.putExtra("id", listType1Item.id);
		intent.putExtra("name", listType1Item.name);
		intent.putExtra("age", listType1Item.age);
		startActivity(intent);
	}
	
	private class ListType1Adapter extends ArrayAdapter<ListType1Item> implements View.OnClickListener{

		Context context;
		int resourceId;
		ArrayList<ListType1Item> listType1Items;

		public ListType1Adapter(Context context, int resourceId, ArrayList<ListType1Item> items) {
			super(context, resourceId, items);
			
			this.context = context;
			this.resourceId = resourceId;
			this.listType1Items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			
			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(resourceId, parent, false);
			}
			
			ListType1Item listType1Item = listType1Items.get(position);
			
			if (listType1Item != null) {
				LinearLayout background = (LinearLayout) view.findViewById(R.id.item_list_background);
				if(listType1Item.index % 2 == 0)
					background.setBackgroundColor(Color.parseColor("#ffeeeeee"));
				else 
					background.setBackgroundColor(Color.parseColor("#ffe0e0e0"));
				
				TextView index = (TextView) view.findViewById(R.id.index);
				index.setText(String.valueOf(position + 1));
				
				TextView id = (TextView) view.findViewById(R.id.id);
				id.setText(listType1Item.id);
				id.setOnClickListener(this);
				id.setTag(String.valueOf(position));
				
				TextView name = (TextView) view.findViewById(R.id.name);
				if (name != null) {
					name.setText(listType1Item.name);
				}
				
				TextView age = (TextView) view.findViewById(R.id.age);
				if (age != null) {
					age.setText(listType1Item.age + "세");
				}
				
			}
			
			return view;
		}

		@Override
		public void onClick(View v) {
			((AdminList1)context).clickId( Integer.parseInt(v.getTag().toString()) );
		}
	}

	public class ListType1Item{
		int index;
		String id;
		String name;
		String age;

		public ListType1Item(int index, String id, String name, String age) {
			this.index = index;
			this.id = id;
			this.name = name;
			this.age = age;
		}
	}
}
