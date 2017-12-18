package com.jiun.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edtel;
    private EditText edNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edNickname = (EditText)findViewById(R.id.nickname);
        edtel = (EditText)findViewById(R.id.tel);
        String nickname=getSharedPreferences("info",MODE_PRIVATE).getString("Name","");
        String tel=getSharedPreferences("info",MODE_PRIVATE).getString("Number","");
        edNickname.setText(nickname);
        edtel.setText(tel);
    }

    public void back(View view){

        String nickname =edNickname.getText().toString();
        String tel =edtel.getText().toString();
        getIntent().putExtra("EXTRA_USERNICKNAME",nickname);
        getIntent().putExtra("EXTRA_USERTEL",tel);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
