package com.aa.itrack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> fromToList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fromToList = new ArrayList<String>();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText toLocation = (EditText) findViewById(R.id.toLocation);
        fromLocationChangeEvent(toLocation);
        String toLocText = toLocation.getText().toString();

        EditText fromLocation = (EditText) findViewById(R.id.fromLocation);
        //Set focus in from location text field
        fromLocation.requestFocus();
        fromLocationChangeEvent(fromLocation);
        String fromLocText = fromLocation.getText().toString();
    }

    //TODO: We will have to change this to a simple on change event and then set focus in the next input field.
    //TODO: This is only here to test the UI. Gary Tipton
    private void fromLocationChangeEvent(final EditText fromLocation) {
        fromLocation.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String newValue = fromLocation.getText().toString();
                    if (null != newValue && newValue.length() > 0) {
                        fromToList.add(newValue);
                        TextView fromToLocation = (TextView) findViewById(R.id.fromToLocation);
                        fromToLocation.setText(concatListItems(fromToList));
                        //Toast.makeText(getApplicationContext(), "unfocus", 2000).show();
                    }
                }
            }

            private String concatListItems(List<String> list) {
                String concatString = "";
                for (String item: list) {
                    if (null != item) {
                        concatString += item + "\n";
                    }
                }
                return concatString;
            }
        });
    }

}
