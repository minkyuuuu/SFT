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
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.arotechno.sft.R;

public class AdminList2 extends Activity {
	ArrayList<Item> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.admin_list_2);

		// Todo : create database
		final String[][] user = { { "seum8311", "박봉덕", "66" }, { "cloud2323", "김지미", "68" }, { "flower123", "홍길동", "76" }, { "box12", "이만길", "71" }, { "sky0210", "김하늘", "74" } };

		final String[] bigCategory = { "근력", "심폐지구력", "유연성", "민첩성", "체지방", "평형성", "평균", "신체나이" };

		final String[][] bigData = { { "C(3)", "D(2)", "C(3)", "B(4)", "B(4)", "D(2)", "C(3)", "63" }, { "C(3)", "D(2)", "C(3)", "B(4)", "B(4)", "D(2)", "C(3)", "65" },
				{ "C(3)", "D(2)", "C(3)", "B(4)", "B(4)", "D(2)", "C(3)", "73" }, { "C(3)", "D(2)", "C(3)", "B(4)", "B(4)", "D(2)", "C(3)", "68" },
				{ "C(3)", "D(2)", "C(3)", "B(4)", "B(4)", "D(2)", "C(3)", "71" } };

		// list item 생성.
		items = new ArrayList<Item>();
		for (int i = 0; i < user.length; i++) {
			Item item = new Item(i, user[i][0], user[i][1], user[i][2], bigData[i]);
			items.add(item);
		}

		// ListView
		ListView listView = (ListView) findViewById(R.id.listview);
		ListType2Adapter adapter = new ListType2Adapter(this, R.layout.list_item_admin_list_type_2, items);
		listView.setAdapter(adapter);

		// 작성하기.
		Button writeButton = (Button) findViewById(R.id.admin_item_list_type_2_write_do);
		writeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AdminList2.this, AdminCreateUserData.class);
				startActivity(intent);
			}
		});

	}

	/**
	 * @brief details
	 */
	void clickMeasure(String category, Item item) {
		Toast.makeText(AdminList2.this, category, Toast.LENGTH_SHORT).show();

		// move to show and update
		Intent intent = new Intent(AdminList2.this, AdminDetails1.class);
		intent.putExtra("kind", category);
		intent.putExtra("id", item.userId);
		intent.putExtra("name", item.userName);
		intent.putExtra("age", item.userAge);
		startActivity(intent);
	}

	private class ListType2Adapter extends ArrayAdapter<Item> implements View.OnClickListener {

		Context context;
		int resourceId;
		ArrayList<Item> Items;
		final String[] bigCategory = { "근력", "심폐지구력", "유연성", "민첩성", "체지방", "평형성", "평균", "신체나이" };

		public ListType2Adapter(Context context, int resourceId, ArrayList<Item> items) {
			super(context, resourceId, items);

			this.context = context;
			this.resourceId = resourceId;
			this.Items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;

			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(resourceId, parent, false);
			}

			Item item = Items.get(position);

			if (item != null) {
				TextView id = (TextView) view.findViewById(R.id.admin_list_2_id);
				id.setText(item.userId);

				TextView name_age = (TextView) view.findViewById(R.id.admin_list_2_name_age);
				if (name_age != null) {
					if (item.userName.equals("박봉덕"))
						name_age.setText(item.userName + " 할아버지      " + item.userAge + "세");
					if (item.userName.equals("김지미"))
						name_age.setText(item.userName + " 할머니      " + item.userAge + "세");
					if (item.userName.equals("홍길동"))
						name_age.setText(item.userName + " 할아버지      " + item.userAge + "세");
					if (item.userName.equals("이만길"))
						name_age.setText(item.userName + " 할아버지      " + item.userAge + "세");
					if (item.userName.equals("김하늘"))
						name_age.setText(item.userName + " 할머니      " + item.userAge + "세");
				}

				TextView date = (TextView) view.findViewById(R.id.admin_list_2_date);
				if (date != null) {
					date.setText("검사일시 : 2015-03-13 14:14");
				}

				// contents
				((TextView) view.findViewById(R.id.admin_list_2_measure_1)).setOnClickListener(this);
				((TextView) view.findViewById(R.id.admin_list_2_measure_1)).setText(bigCategory[0] + " : " + item.data[0]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_1)).setTag(R.string.tag_key_category, bigCategory[0]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_1)).setTag(R.string.tag_key_item, item);

				((TextView) view.findViewById(R.id.admin_list_2_measure_2)).setOnClickListener(this);
				((TextView) view.findViewById(R.id.admin_list_2_measure_2)).setText(bigCategory[1] + " : " + item.data[1]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_2)).setTag(R.string.tag_key_category, bigCategory[1]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_2)).setTag(R.string.tag_key_item, item);

				((TextView) view.findViewById(R.id.admin_list_2_measure_3)).setOnClickListener(this);
				((TextView) view.findViewById(R.id.admin_list_2_measure_3)).setText(bigCategory[2] + " : " + item.data[2]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_3)).setTag(R.string.tag_key_category, bigCategory[2]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_3)).setTag(R.string.tag_key_item, item);

				((TextView) view.findViewById(R.id.admin_list_2_measure_4)).setOnClickListener(this);
				((TextView) view.findViewById(R.id.admin_list_2_measure_4)).setText(bigCategory[3] + " : " + item.data[3]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_4)).setTag(R.string.tag_key_category, bigCategory[3]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_4)).setTag(R.string.tag_key_item, item);

				((TextView) view.findViewById(R.id.admin_list_2_measure_5)).setOnClickListener(this);
				((TextView) view.findViewById(R.id.admin_list_2_measure_5)).setText(bigCategory[4] + " : " + item.data[4]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_5)).setTag(R.string.tag_key_category, bigCategory[4]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_5)).setTag(R.string.tag_key_item, item);

				((TextView) view.findViewById(R.id.admin_list_2_measure_6)).setOnClickListener(this);
				((TextView) view.findViewById(R.id.admin_list_2_measure_6)).setText(bigCategory[5] + " : " + item.data[5]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_6)).setTag(R.string.tag_key_category, bigCategory[5]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_6)).setTag(R.string.tag_key_item, item);

				((TextView) view.findViewById(R.id.admin_list_2_measure_average)).setText(bigCategory[6] + " : " + item.data[6]);
				((TextView) view.findViewById(R.id.admin_list_2_measure_body_age)).setText(bigCategory[7] + " : " + item.data[7]);

			}

			return view;
		}

		@Override
		public void onClick(View v) {
			((AdminList2) context).clickMeasure(v.getTag(R.string.tag_key_category).toString(), (Item) v.getTag(R.string.tag_key_item));
		}
	}

	public class Item {
		int index;
		String userId;
		String userName;
		String userAge;

		String[] data;

		public Item(int index, String userId, String userName, String userAge, String[] data) {
			this.index = index;
			this.userId = userId;
			this.userName = userName;
			this.userAge = userAge;

			this.data = data;
		}
	}
}
