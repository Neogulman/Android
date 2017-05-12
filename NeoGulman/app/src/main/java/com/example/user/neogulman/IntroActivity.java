package com.example.user.neogulman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layot_intro);
        //기본 화면 출력

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(IntroActivity.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
        //2초후에 다음 화면으로 자동으로 넘어감
    }
}