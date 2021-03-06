package com.jiun.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    private static final String TAG = CityActivity.class.getSimpleName();
    private String[] cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ListView city=(ListView)findViewById(R.id.sp_city);
        cities = new String[]{"新北市", "基隆市", "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,cities);

        city.setAdapter(adapter);
        city.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
    Log.d(TAG,"onItemClick:"+position+"/"+cities[position]);
        String[]data=null;
        if (position==0){
            data=new String[]{"中正區","暖暖區","八堵區"};
        }


    }

}
