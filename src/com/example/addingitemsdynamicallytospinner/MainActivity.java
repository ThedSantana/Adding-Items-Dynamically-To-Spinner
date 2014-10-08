package com.example.addingitemsdynamicallytospinner;
import java.util.ArrayList;

import com.example.addingitemsdynamicallytolistview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity 
{

	EditText et;
	Button b;
	Spinner sp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et=(EditText)findViewById(R.id.editText1);
		b=(Button)findViewById(R.id.button1);
		sp=(Spinner)findViewById(R.id.spinner1);
		
		/** Items entered by the user is stored in this ArrayList variable */
		final ArrayList<String> al= new ArrayList<String>();
		/** Defining the ArrayAdapter to set items to Spinner */
		final ArrayAdapter<String>aa=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,al);
		/** Setting the adapter to the Spinner */
		sp.setAdapter(aa);
				
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,	int arg2, long arg3)
				
			{
				// TODO Auto-generated method stub
				String item=al.get(arg2);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) 
			{
				// TODO Auto-generated method stub
				
			}
		});
				
		b.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				// take text from et and add to arraylist
				String item=et.getText().toString();
				al.add(item);
				// notify to adapter
				aa.notifyDataSetChanged();
				// clr edit text
				et.setText("");
			}
		});
	}

	

}
