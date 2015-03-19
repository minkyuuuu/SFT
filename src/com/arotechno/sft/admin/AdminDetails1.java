package com.arotechno.sft.admin;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.arotechno.sft.R;

public class AdminDetails1 extends Activity {
	ArrayList<Details1Item> details1Items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.admin_details_1);
		
		// intent data
		Intent intent = getIntent();
		String kind = intent.getStringExtra("kind");
		String id = intent.getStringExtra("id");
		String name = intent.getStringExtra("name");
		String age = intent.getStringExtra("age");
		
		// user info.
		((TextView) findViewById(R.id.admin_details_id)).setText(id);
		
		if(name.equals("박봉덕")) ((TextView) findViewById(R.id.admin_details_name_age)).setText(name + " 할아버지      " + age + "세");
		if(name.equals("김지미")) ((TextView) findViewById(R.id.admin_details_name_age)).setText(name + " 할머니      " + age + "세");
		if(name.equals("홍길동")) ((TextView) findViewById(R.id.admin_details_name_age)).setText(name + " 할아버지      " + age + "세");
		if(name.equals("이만길")) ((TextView) findViewById(R.id.admin_details_name_age)).setText(name + " 할아버지      " + age + "세");
		if(name.equals("김하늘")) ((TextView) findViewById(R.id.admin_details_name_age)).setText(name + " 할머니      " + age + "세");
		
		// data for ListView
		// Todo : database
		final String[] item = { "배근력", "악력", "각근력", "상완근력", 		// 0 ~ 3
								"2분걷기", 								// 4 ~ 4
								"좌전굴", "의자에 앉아 앞으로 굽히기", "견관절", 	// 5 ~ 7
								"타임드 업 앤 고", "누웠다 일어서기", 			// 8 ~ 9
								"전신반응(빛)", "전신반응(소리)", 				// 10 ~ 11
								"눈감고 외발서기", "눈뜨고 외발서기" };			// 12 ~ 13
		
		final String[] rating = { "B", "C", "E", "C",
				"D", "D", "C", "C",
				"A", "C", "A", "D",
				"C", "E" };
		
		final String[] score = { "50.0", "17.0", "8.0", "23.0",
				"88.0", "6.5", "16.0", "8.0",
				"3.5", "3.0", "0.2", "0.5",
				"4.0", "2.0" };
		
		final String[] bodyAge = { "B", "C", "E", "C",
				"B", "C", "E", "C",
				"B", "C", "E", "C",
				"B", "C" };
		
		// list item 생성.
		int start = 0, end = 0;
		if (kind.equals("all")) {
			start = 0;
			end = item.length;
		}
		
		if (kind.equals("근력")) {
			start = 0;
			end = 4;
		}
		
		if (kind.equals("심폐지구력")) {
			start = 4;
			end = 5;
		}
		
		if (kind.equals("유연성")) {
			start = 5;
			end = 8;
		}
		
		if (kind.equals("민첩성")) {
			start = 8;
			end = 10;
		}
		
		if (kind.equals("체지방")) {
			start = 10;
			end = 12;
		}
		
		if (kind.equals("평형성")) {
			start = 12;
			end = 14;
		}
		
		details1Items = new ArrayList<Details1Item>();
		for (int i = start; i < end; i++) {
			Details1Item details1Item = new Details1Item(item[i], rating[i], score[i]);
			details1Items.add(details1Item);
		}
		
		// ListView
		ListView listView = (ListView) findViewById(R.id.listview);
		DetailsAdapter adapter = new DetailsAdapter(this, R.layout.list_item_admin_details_1, details1Items);
		listView.setAdapter(adapter);
		//listView.setDivider(null);
		
		// 목록.
		Button category = (Button) findViewById(R.id.admin_item_list_type_category);
		category.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
	
	private class DetailsAdapter extends ArrayAdapter<Details1Item> {

		Context context;
		int resourceId;
		ArrayList<Details1Item> detailsItems;

		public DetailsAdapter(Context context, int resourceId, ArrayList<Details1Item> items) {
			super(context, resourceId, items);
			
			this.context = context;
			this.resourceId = resourceId;
			this.detailsItems = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			
			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(resourceId, parent, false);
			}
			
			Details1Item details1Item = (Details1Item) detailsItems.get(position);
			if (details1Item != null) {
				TextView measureType = (TextView) view.findViewById(R.id.admin_details_1_measure_type);
				measureType.setText(details1Item.item);
				
				TextView rating = (TextView) view.findViewById(R.id.admin_details_1_rating_value);
				rating.setText(details1Item.rating);
				
				TextView score = (TextView) view.findViewById(R.id.admin_details_1_score_value);
				score.setText(details1Item.score);
			}
			
			return view;
		}

	}
	
	public class Details1Item{
		String item;
		String rating;
		String score;

		public Details1Item(String item, String rating, String score) {
			this.item = item;
			this.rating = rating;
			this.score = score;
		}
	}
	
}
