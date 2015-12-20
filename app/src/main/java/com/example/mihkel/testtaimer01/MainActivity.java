package com.example.mihkel.testtaimer01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    AppMain appMain;

    //http://stackoverflow.com/questions/4540754/dynamically-add-elements-to-a-listview-android

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems = new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    Integer counter = 0;

    //----------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appMain = new AppMain(this);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.timesListView);
        listView.setAdapter(this.adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------

    public void registerStartButtonClick(View view) {
        Common.print("regisartButtonCck");
        appMain.startStopwatch();
    }

    public void registerStopButtonClick(View view) {
        Common.print("registerStopButlick");
        String stopwatchTime = appMain.getStopwatchTime();
        Common.print(stopwatchTime);
        this.addTimeToList();

    }

//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------

    private void addTimeToList() {
        String stopwatchTime = appMain.getStopwatchTime();
        this.addItems(stopwatchTime);
    }

    public void addItems(String itemToAdd) {
        Common.print("addItems");
        this.counter++;
        this.listItems.add(this.counter.toString() + " - " + itemToAdd);
        adapter.notifyDataSetChanged();
    }
}
