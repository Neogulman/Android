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
public class Activity_path extends AppCompatActivity implements OnClickListener {

    Button a11, a12, a13, a14, a15, a16;
    Button a21, a22, a23, a24, a25, a26;
    Button a31, a32, a33, a34, a35, a36;
    Button a41, a42, a43, a44, a45, a46;
    Button a51, a52, a53, a54 ,a55, a56;
    Button a61, a62, a63, a64 ,a65, a66;
    Button a71, a72, a73, a74, a75, a76;
    Button a81, a82, a83, a84, a85, a86;
    Button show;
    int[][]arr = new int[8][6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_path);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF40A940));
        setTitle("경로");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = 0;
            }
        }
        show = (Button) findViewById(R.id.show);
        //bt2= (Button)findViewById(R.id.btn2);
        show.setOnClickListener(this);

    }

    public void onClick(View v) {
        arr[1][0] =1;
        arr[1][1] =1;
        arr[1][2] =1;
        arr[1][3] =1;
        arr[2][3] =1;
        arr[3][3] =1;
        arr[4][3] =1;
        arr[5][3] =1;
        arr[6][3] =1;
        arr[6][4] =1;
        arr[6][5] =1;
        a11 = (Button) findViewById(R.id.a11); a12 = (Button) findViewById(R.id.a12); a13 = (Button) findViewById(R.id.a13); a14 = (Button) findViewById(R.id.a14); a15 = (Button) findViewById(R.id.a15); a16 = (Button) findViewById(R.id.a16);
        a21 = (Button) findViewById(R.id.a21); a22 = (Button) findViewById(R.id.a22); a23 = (Button) findViewById(R.id.a23); a24 = (Button) findViewById(R.id.a24); a25 = (Button) findViewById(R.id.a25); a26 = (Button) findViewById(R.id.a26);
        a31 = (Button) findViewById(R.id.a31); a32 = (Button) findViewById(R.id.a32); a33 = (Button) findViewById(R.id.a33); a34 = (Button) findViewById(R.id.a34); a35 = (Button) findViewById(R.id.a35); a36 = (Button) findViewById(R.id.a36);
        a41 = (Button) findViewById(R.id.a41); a42 = (Button) findViewById(R.id.a42); a43 = (Button) findViewById(R.id.a43); a44 = (Button) findViewById(R.id.a44); a45 = (Button) findViewById(R.id.a45); a46 = (Button) findViewById(R.id.a46);
        a51 = (Button) findViewById(R.id.a51); a52 = (Button) findViewById(R.id.a52); a53 = (Button) findViewById(R.id.a53); a54 = (Button) findViewById(R.id.a54); a55 = (Button) findViewById(R.id.a55); a56 = (Button) findViewById(R.id.a56);
        a61 = (Button) findViewById(R.id.a61); a62 = (Button) findViewById(R.id.a62); a63 = (Button) findViewById(R.id.a63); a64 = (Button) findViewById(R.id.a64); a65 = (Button) findViewById(R.id.a65); a66 = (Button) findViewById(R.id.a66);
        a71 = (Button) findViewById(R.id.a71); a72 = (Button) findViewById(R.id.a72); a73 = (Button) findViewById(R.id.a73); a74 = (Button) findViewById(R.id.a74); a75 = (Button) findViewById(R.id.a75); a76 = (Button) findViewById(R.id.a76);
        a81 = (Button) findViewById(R.id.a81); a82 = (Button) findViewById(R.id.a82); a83 = (Button) findViewById(R.id.a83); a84 = (Button) findViewById(R.id.a84); a85 = (Button) findViewById(R.id.a85); a86 = (Button) findViewById(R.id.a86);

        if (v.getId() == R.id.show) {
            if (arr[0][0] == 1) { a11.setBackgroundColor(0xFF40A940);}
            if (arr[0][1] == 1) { a12.setBackgroundColor(0xFF40A940);}
            if (arr[0][2] == 1) { a13.setBackgroundColor(0xFF40A940);}
            if (arr[0][3] == 1) { a14.setBackgroundColor(0xFF40A940);}
            if (arr[0][4] == 1) { a15.setBackgroundColor(0xFF40A940);}
            if (arr[0][5] == 1) { a16.setBackgroundColor(0xFF40A940);}
            if (arr[1][0] == 1) { a21.setBackgroundColor(0xFF40A940);}
            if (arr[1][1] == 1) { a22.setBackgroundColor(0xFF40A940);}
            if (arr[1][2] == 1) { a23.setBackgroundColor(0xFF40A940);}
            if (arr[1][3] == 1) { a24.setBackgroundColor(0xFF40A940);}
            if (arr[1][4] == 1) { a25.setBackgroundColor(0xFF40A940);}
            if (arr[1][5] == 1) { a26.setBackgroundColor(0xFF40A940);}
            if (arr[2][0] == 1) { a31.setBackgroundColor(0xFF40A940);}
            if (arr[2][1] == 1) { a32.setBackgroundColor(0xFF40A940);}
            if (arr[2][2] == 1) { a33.setBackgroundColor(0xFF40A940);}
            if (arr[2][3] == 1) { a34.setBackgroundColor(0xFF40A940);}
            if (arr[2][4] == 1) { a35.setBackgroundColor(0xFF40A940);}
            if (arr[2][5] == 1) { a36.setBackgroundColor(0xFF40A940);}
            if (arr[3][0] == 1) { a41.setBackgroundColor(0xFF40A940);}
            if (arr[3][1] == 1) { a42.setBackgroundColor(0xFF40A940);}
            if (arr[3][2] == 1) { a43.setBackgroundColor(0xFF40A940);}
            if (arr[3][3] == 1) { a44.setBackgroundColor(0xFF40A940);}
            if (arr[3][4] == 1) { a45.setBackgroundColor(0xFF40A940);}
            if (arr[3][5] == 1) { a46.setBackgroundColor(0xFF40A940);}
            if (arr[4][0] == 1) { a51.setBackgroundColor(0xFF40A940);}
            if (arr[4][1] == 1) { a52.setBackgroundColor(0xFF40A940);}
            if (arr[4][2] == 1) { a53.setBackgroundColor(0xFF40A940);}
            if (arr[4][3] == 1) { a54.setBackgroundColor(0xFF40A940);}
            if (arr[4][4] == 1) { a55.setBackgroundColor(0xFF40A940);}
            if (arr[4][5] == 1) { a56.setBackgroundColor(0xFF40A940);}
            if (arr[5][0] == 1) { a61.setBackgroundColor(0xFF40A940);}
            if (arr[5][1] == 1) { a62.setBackgroundColor(0xFF40A940);}
            if (arr[5][2] == 1) { a63.setBackgroundColor(0xFF40A940);}
            if (arr[5][3] == 1) { a64.setBackgroundColor(0xFF40A940);}
            if (arr[5][4] == 1) { a65.setBackgroundColor(0xFF40A940);}
            if (arr[5][5] == 1) { a66.setBackgroundColor(0xFF40A940);}
            if (arr[6][0] == 1) { a71.setBackgroundColor(0xFF40A940);}
            if (arr[6][1] == 1) { a72.setBackgroundColor(0xFF40A940);}
            if (arr[6][2] == 1) { a73.setBackgroundColor(0xFF40A940);}
            if (arr[6][3] == 1) { a74.setBackgroundColor(0xFF40A940);}
            if (arr[6][4] == 1) { a75.setBackgroundColor(0xFF40A940);}
            if (arr[6][5] == 1) { a76.setBackgroundColor(0xFF40A940);}
            if (arr[7][0] == 1) { a81.setBackgroundColor(0xFF40A940);}
            if (arr[7][1] == 1) { a82.setBackgroundColor(0xFF40A940);}
            if (arr[7][2] == 1) { a83.setBackgroundColor(0xFF40A940);}
            if (arr[7][3] == 1) { a84.setBackgroundColor(0xFF40A940);}
            if (arr[7][4] == 1) { a85.setBackgroundColor(0xFF40A940);}
            if (arr[7][5] == 1) { a86.setBackgroundColor(0xFF40A940);}
        }
    }
}