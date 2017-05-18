package com.example.user.neogulman;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.net.MalformedURLException;
import android.view.View.OnClickListener;
//implements OnClickListener
public class Activity_path extends AppCompatActivity {

    Button bt1,bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_path);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF40A940));
        setTitle("경로");
       // bt1= (Button)findViewById(R.id.btn);
        //bt2= (Button)findViewById(R.id.btn2);
        //bt1.setOnClickListener(this);

    }

  /*  public void onClick(View v) {
    if(v.getId()==R.id.btn){
        bt1= (Button)findViewById(R.id.btn);
       bt1.setBackgroundColor(0xFF40A940);
    }
    }*/
}