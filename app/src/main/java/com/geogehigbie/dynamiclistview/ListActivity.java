package com.geogehigbie.dynamiclistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by georgehigbie on 1/19/17.
 */

public class ListActivity extends AppCompatActivity {

    private String[] inputArray;
    private Intent intent;
    private Bundle bundle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        createListView();
    }



    public void createListView(){
        intent = getIntent();
        bundle = intent.getExtras();

        if(bundle != null){
            inputArray = bundle.getStringArray("inputArray");
        }


        ListView listView = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, inputArray);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //I just added this part to make the list a little more active
                        String item = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(ListActivity.this, item, Toast.LENGTH_SHORT ).show();
                    }
                }

        );
    }

}
