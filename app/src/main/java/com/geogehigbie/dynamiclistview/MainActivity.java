package com.geogehigbie.dynamiclistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] inputArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addOnClickListeners();

    }


    public void addOnClickListeners(){

        Button parseButton = (Button) findViewById(R.id.parse_button);
        final Button viewButton = (Button) findViewById(R.id.view_button);



        parseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAndParseText();
                viewButton.setVisibility(View.VISIBLE);

            }
        });



        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startListActivity();

            }
        });

    }

    public void getAndParseText(){

        EditText input = (EditText) findViewById(R.id.edit_text);
        String inputString = input.getText().toString();
        inputArray = inputString.split(",");
        int lengthOfInput = inputArray.length;
        String lengthString = Integer.toString(lengthOfInput);
        String textInputString = lengthString + " item(s) parsed!";

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(textInputString);
    }
    //using two activities in place of fragments
    public void startListActivity(){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("inputArray", inputArray);
        startActivity(intent);

    }


}
