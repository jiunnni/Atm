package com.jiun.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        Spinner spCity = (Spinner) findViewById(R.id.sp_city);
        Spinner spArea = (Spinner) findViewById(R.id.sp_area);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,new String []{"基隆市","新北市","台北市"});
spCity.setAdapter(adapter);
        spCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });





    }
}
