package com.ScarFromTheLionKing.superserialz;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		Button edit_itemButton = (Button)findViewById(R.id.addItemButton);
		Button add_itemButton = (Button)findViewById(R.id.editItemButton);
		Button delete_itemButton = (Button)findViewById(R.id.deleteItemButton);
        TextView textView = (TextView)findViewById(R.id.usernameTextView);

		final String[] loginInformation = new String[3];
		loginInformation[0] = getIntent().getExtras().getString("username");
        loginInformation[1] = getIntent().getExtras().getString("password");
        loginInformation[2] = "24";	//Dynamically add value to delete later

    	textView.setText(loginInformation[0]);	//Show results on screen

		delete_itemButton.setOnClickListener(
		        new View.OnClickListener()
		        {
		            @SuppressWarnings("deprecation")
					public void onClick(View view)
		            {
		               Toast.makeText(getApplicationContext(), "Clicked Delete Item", Toast.LENGTH_SHORT).show();
		                AsyncDeleteItem loginTask = new AsyncDeleteItem();
						loginTask.execute(loginInformation);	//ID of number to delete, will add later
		            }
		        });

		
		
		add_itemButton.setOnClickListener(
		        new View.OnClickListener()
		        {
		            @SuppressWarnings("deprecation")
					public void onClick(View view)
		            {
		               Toast.makeText(getApplicationContext(), "Clicked Add Item", Toast.LENGTH_SHORT).show();
		            }
		        });
		
		
		
		edit_itemButton.setOnClickListener(
		        new View.OnClickListener()
		        {
		            @SuppressWarnings("deprecation")
					public void onClick(View view)
		            {
		               Toast.makeText(getApplicationContext(), "Clicked Edit Item", Toast.LENGTH_SHORT).show();
		            }
		        });

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	
	//Function that takes in a string argument(json file) and returns an array of strings 
	public String[] jsonStringParser(String jsonString)
	{
		ArrayList<String> stringArrayList = new ArrayList<String>();//Save the substrings to this item, it is like a string array 
		
		String subString = "";
			
			/*Iterate through the string*/
			stringArrayList.add(subString); //The method used to add items to the add items to the ArrayList
		
		
		String [] returnArray = stringArrayList.toArray(new String[stringArrayList.size()]);	//Converts the ArrayList to a string array to be returned
		return returnArray;
		
	}
	
	
	
	
}
