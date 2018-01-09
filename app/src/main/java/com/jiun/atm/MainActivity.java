package com.jiun.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_LOGIN=102;
    private static final int REQUEST_USERINFO = 105;;
boolean logon = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_LOGIN:

                

                    if (resultCode == RESULT_OK) {
                        String userid = data.getStringExtra("LOGIN_USERID");
                        Toast.makeText(this,"Login userid:"+userid,Toast.LENGTH_LONG).show();
                        getSharedPreferences("test",MODE_PRIVATE).edit().putString("USER",userid).apply();
                        String passwd = data.getStringExtra("LOGIN_PASSWD");
                        Log.d("PESULT", userid + "/" + passwd);
                    } else {
                        finish();
                    }
                    break;
            case REQUEST_USERINFO:
                if(resultCode==RESULT_OK){
                    String nickname=data.getStringExtra("EXTRA_USERNICKNAME");
                    String tel=data.getStringExtra("EXTRA_USERTEL");
                    Toast.makeText(this,"NICKNAME"+nickname,Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"PHONE"+tel,Toast.LENGTH_LONG).show();
                 getSharedPreferences("info",MODE_PRIVATE)
                         .edit().putString("Name",nickname).putString("Number",tel).apply();
                }
                break;
                }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            //startActivity(intent);
            startActivityForResult(intent, REQUEST_LOGIN);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent j = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(j, REQUEST_USERINFO);

            }
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //.setAction("Action", null).show();


        });
        ListView listView=(ListView)findViewById(R.id.list);
        final String[] data = {"AAA", "BBB", "CCC"};
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, data);
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
}
