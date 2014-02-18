package com.codepath.bootcamp.android.todoapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Selection;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {
	private EditText etEditItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);

		// initialize text view with item name
		etEditItem = (EditText) findViewById(R.id.etEditItem);
		etEditItem.setText(getIntent().getStringExtra("text"));
		// set user's cursor to the end and get focus
		Selection.setSelection(etEditItem.getText(), etEditItem.length());
		etEditItem.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

	public void onSave(View v) {
		Intent data = new Intent();
		data.putExtra("newText", etEditItem.getText().toString());
		data.putExtra("position", getIntent().getIntExtra("position", 0));
		setResult(RESULT_OK, data);
		finish();
	}
}
