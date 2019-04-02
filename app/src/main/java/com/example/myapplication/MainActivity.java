package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SpinnerDataSource dataSource = new SpinnerDataSource();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = getAdapter(dataSource);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerItem = dataSource.getDataSource().get(position);
                Log.d("Spinner item", spinnerItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayAdapter<String> getAdapter(SpinnerDataSource dataSource) {
        List<String> androidVersions = dataSource.getDataSource();
        return new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                androidVersions
        );
    }
}
