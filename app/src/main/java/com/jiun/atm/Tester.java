package com.jiun.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        public class Tester {
            public static void main(String[] args) {
                Date now = new Date();
                System.out.println(now);
                System.out.println(now.getTime());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(sdf.format(now));
                //反過來，有字串，得Date物件?
                String s = "1998-04-01";
                try {
                    Date birthday = sdf.parse(s);
                    System.out.println(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

    }
}
