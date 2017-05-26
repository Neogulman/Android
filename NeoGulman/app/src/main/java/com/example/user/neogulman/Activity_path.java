package com.example.user.neogulman;

import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.view.View.OnClickListener;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.view.View;

//implements OnClickListener
public class Activity_path extends AppCompatActivity implements OnClickListener {

    String myJSON;
    private static final String result="result";
    private static final String tag_x = "locationX";
    private static final String tag_y = "locationY";
    JSONArray peoples = null;

    Button a11, a12, a13, a14, a15, a16;
    Button a21, a22, a23, a24, a25, a26;
    Button a31, a32, a33, a34, a35, a36;
    Button a41, a42, a43, a44, a45, a46;
    Button a51, a52, a53, a54 ,a55, a56;
    Button a61, a62, a63, a64 ,a65, a66;
    Button a71, a72, a73, a74, a75, a76;
    Button a81, a82, a83, a84, a85, a86;
    Button show;
    Button pop;
    int[][]arr = new int[8][10];
    int i,j,k,n=0; //n 상품개수
    int[] locationX = new int[100];
    int[] locationY = new int[100];
    int[] path = new int[100];
    int[] sd = new int[100];
    int[][] dist=new int[100][100];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_path);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF40A940));
        setTitle("경로");
        getData("http://52.79.178.97/getaxis.php");

        show = (Button) findViewById(R.id.show);
        //bt2= (Button)findViewById(R.id.btn2);
        show.setOnClickListener(this);

        pop = (Button) findViewById(R.id.button1);
        //bt2= (Button)findViewById(R.id.btn2);
        pop.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.show:
                a11 = (Button) findViewById(R.id.a11);
                a12 = (Button) findViewById(R.id.a12);
                a13 = (Button) findViewById(R.id.a13);
                a14 = (Button) findViewById(R.id.a14);
                a15 = (Button) findViewById(R.id.a15);
                a16 = (Button) findViewById(R.id.a16);
                a21 = (Button) findViewById(R.id.a21);
                a22 = (Button) findViewById(R.id.a22);
                a23 = (Button) findViewById(R.id.a23);
                a24 = (Button) findViewById(R.id.a24);
                a25 = (Button) findViewById(R.id.a25);
                a26 = (Button) findViewById(R.id.a26);
                a31 = (Button) findViewById(R.id.a31);
                a32 = (Button) findViewById(R.id.a32);
                a33 = (Button) findViewById(R.id.a33);
                a34 = (Button) findViewById(R.id.a34);
                a35 = (Button) findViewById(R.id.a35);
                a36 = (Button) findViewById(R.id.a36);
                a41 = (Button) findViewById(R.id.a41);
                a42 = (Button) findViewById(R.id.a42);
                a43 = (Button) findViewById(R.id.a43);
                a44 = (Button) findViewById(R.id.a44);
                a45 = (Button) findViewById(R.id.a45);
                a46 = (Button) findViewById(R.id.a46);
                a51 = (Button) findViewById(R.id.a51);
                a52 = (Button) findViewById(R.id.a52);
                a53 = (Button) findViewById(R.id.a53);
                a54 = (Button) findViewById(R.id.a54);
                a55 = (Button) findViewById(R.id.a55);
                a56 = (Button) findViewById(R.id.a56);
                a61 = (Button) findViewById(R.id.a61);
                a62 = (Button) findViewById(R.id.a62);
                a63 = (Button) findViewById(R.id.a63);
                a64 = (Button) findViewById(R.id.a64);
                a65 = (Button) findViewById(R.id.a65);
                a66 = (Button) findViewById(R.id.a66);
                a71 = (Button) findViewById(R.id.a71);
                a72 = (Button) findViewById(R.id.a72);
                a73 = (Button) findViewById(R.id.a73);
                a74 = (Button) findViewById(R.id.a74);
                a75 = (Button) findViewById(R.id.a75);
                a76 = (Button) findViewById(R.id.a76);
                a81 = (Button) findViewById(R.id.a81);
                a82 = (Button) findViewById(R.id.a82);
                a83 = (Button) findViewById(R.id.a83);
                a84 = (Button) findViewById(R.id.a84);
                a85 = (Button) findViewById(R.id.a85);
                a86 = (Button) findViewById(R.id.a86);

                if (v.getId() == R.id.show) {
                    if (arr[1][1] == 3) {
                        a11.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[2][1] == 3) {
                        a12.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[3][1] == 3) {
                        a13.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[4][1] == 3) {
                        a14.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[5][1] == 3) {
                        a15.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[6][1] == 3) {
                        a16.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[1][2] == 1 || arr[1][2] == 4) {
                        a21.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[2][2] == 1 || arr[2][2] == 4) {
                        a22.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[3][2] == 1 || arr[3][2] == 4) {
                        a23.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[4][2] == 1 || arr[4][2] == 4) {
                        a24.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[5][2] == 1 || arr[5][2] == 4) {
                        a25.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[6][2] == 1 || arr[6][2] == 4) {
                        a26.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[1][3] == 1 || arr[1][3] == 4) {
                        a31.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[2][3] == 3) {
                        a32.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[3][3] == 3) {
                        a33.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[4][3] == 1 || arr[4][3] == 4) {
                        a34.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[5][3] == 3) {
                        a35.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[6][3] == 3) {
                        a36.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[1][4] == 1 || arr[1][4] == 4) {
                        a41.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[2][4] == 1 || arr[2][4] == 4) {
                        a42.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[3][4] == 1 || arr[3][4] == 4) {
                        a43.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[4][4] == 1 || arr[4][4] == 4) {
                        a44.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[5][4] == 1 || arr[5][4] == 4) {
                        a45.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[6][4] == 1 || arr[6][4] == 4) {
                        a46.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[1][5] == 1) {
                        a51.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[2][5] == 3) {
                        a52.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[3][5] == 3) {
                        a53.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[4][5] == 1 || arr[4][5] == 4) {
                        a54.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[5][5] == 3) {
                        a55.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[6][5] == 3) {
                        a56.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[1][6] == 1 || arr[1][6] == 4) {
                        a61.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[2][6] == 3) {
                        a62.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[3][6] == 3) {
                        a63.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[4][6] == 1 || arr[4][6] == 4) {
                        a64.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[5][6] == 3) {
                        a65.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[6][6] == 3) {
                        a66.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[1][7] == 1 || arr[1][7] == 4) {
                        a71.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[2][7] == 1 || arr[2][7] == 4) {
                        a72.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[3][7] == 1 || arr[3][7] == 4) {
                        a73.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[4][7] == 1 || arr[4][7] == 4) {
                        a74.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[5][7] == 1 || arr[5][7] == 4) {
                        a75.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[6][7] == 1 || arr[6][7] == 4) {
                        a76.setBackgroundColor(0xFF40A940);
                    }
                    if (arr[1][8] == 3) {
                        a81.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[2][8] == 3) {
                        a82.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[3][8] == 3) {
                        a83.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[4][8] == 3) {
                        a84.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[5][8] == 3) {
                        a85.setBackgroundColor(0xFFFF7493);
                    }
                    if (arr[6][8] == 3) {
                        a86.setBackgroundColor(0xFFFF7493);
                    }
                }
                break;
            default:
                startActivity(new Intent(this, PopupActivity.class));
                break;
        }
    }


    protected void showList() {

        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(result);

            for (int num = 0; num < peoples.length(); num++) {
                JSONObject c = peoples.getJSONObject(num);
                String first = c.getString(tag_x);
                String second = c.getString(tag_y);
                int x = Integer.parseInt(first);
                int y = Integer.parseInt(second);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        n=4;//wishlist size
        locationX[0]=1;
        locationY[0]=0;
        locationX[1]=0;
        locationY[1]=3;
       // locationX[2]=4;
       // locationY[2]=5;
        locationX[2]=4;
        locationY[2]=1;
        locationX[3]=6;
        locationY[3]=5;

        for(i=0;i<8;i++)
            for(j=0;j<10;j++)
                arr[i][j]=0;

        for(i=0;i<8;i++)
            arr[i][0]=2;
        for(i=0;i<8;i++)
            arr[i][9]=2;
        for(i=0;i<10;i++)
            arr[0][i]=2;
        for(i=0;i<10;i++)
            arr[7][i]=2;


        arr[1][1]=2;
        arr[2][1]=2;
        arr[3][1]=2;
        arr[4][1]=2;
        arr[5][1]=2;
        arr[6][1]=2;
        arr[2][3]=2;
        arr[3][3]=2;
        arr[5][3]=2;
        arr[6][3]=2;
        arr[2][5]=2;
        arr[3][5]=2;
        arr[5][5]=2;
        arr[6][5]=2;
        arr[2][6]=2;
        arr[3][6]=2;
        arr[5][6]=2;
        arr[6][6]=2;
        arr[1][8]=2;
        arr[2][8]=2;
        arr[3][8]=2;
        arr[4][8]=2;
        arr[5][8]=2;
        arr[6][8]=2;

        for(i =0;i<n;i++)
            arr[locationY[i]+1][locationX[i]+1]=3; //물건 살 수 있는 칸 열린 위치


        for(i=0;i<n;i++)
            for(j=i;j<n;j++)
                dist[j][i]=sub(locationX[i],locationX[j])+sub(locationY[i],locationY[j]);

        int min=9999;
        int minnum=0;
        boolean d=true;
        path[0]=0;
        path[1]=1;
        path[2]=2;
        path[3]=3;
        //path[4]=4;
        int tempnum=0;

        for(j=0;j<n;j++){
            tempnum=0;
            for(i=0;i<n;i++){
                if(locationX[j]>=locationX[i])
                    tempnum++;
            }
            path[j]=tempnum;
        }
//      for(i=0;i<n-1;i++){
//         min=9999;
//         for(j=1;j<n-1;j++){
//            d=true;
//            for(k=0;k<n-1;k++){
//               if(path[k]==j||minnum==j)
//                  d=false;
//            }
//            if(d){
//               if(min>dist[j][minnum]){
//                  min=dist[j][minnum];
//
//                  minnum=j;
//               }
//            }
//         }
//         sd[i]=min;
//         path[i+1]=minnum;
//      }

        for(i=0;i<10;i++){
            for(j=0;j<8;j++){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println("");
        }

        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(dist[j][i]+" ");
            }
            System.out.println();
        }


        for(i=0;i<n;i++)
            System.out.print(path[i]+" ");
        System.out.println();


        int gox=locationX[0]+1,goy=locationY[0]+1;
        int go=0;
        while(true){

            if(arr[goy][gox]==3)
                go+=1;
            if(go==n)
                break;
            arr[goy][gox]=1;
            if(gox<=(locationX[go]+1)&&goy<=(locationY[go]+1)){
                if(arr[goy+1][gox]==0||arr[goy+1][gox]==3)
                    goy+=1;
                else if(arr[goy][gox+1]==0||arr[goy][gox+1]==3)
                    gox+=1;
                else if(arr[goy-1][gox]==0||arr[goy-1][gox]==3)
                    goy-=1;
                else if(arr[goy][gox-1]==0||arr[goy][gox-1]==3)
                    gox-=1;
                else{
                    arr[goy][gox]=4;
                    if(arr[goy+1][gox]==1)
                        goy+=1;
                    else if(arr[goy][gox+1]==1)
                        gox+=1;
                    else if(arr[goy-1][gox]==1)
                        goy-=1;
                    else if(arr[goy][gox-1]==1)
                        gox-=1;
                }
            }
            else if(gox>(locationX[go]+1)&&goy<=(locationY[go]+1)){

                if(arr[goy+1][gox]==0||arr[goy+1][gox]==3)
                    goy+=1;
                else if(arr[goy][gox-1]==0||arr[goy][gox-1]==3)
                    gox-=1;
                else if(arr[goy][gox+1]==0||arr[goy][gox+1]==3)
                    gox+=1;
                else if(arr[goy-1][gox]==0||arr[goy-1][gox]==3)
                    goy-=1;

                else{
                    arr[goy][gox]=4;
                    if(arr[goy+1][gox]==1)
                        goy+=1;
                    else if(arr[goy][gox+1]==1)
                        gox+=1;
                    else if(arr[goy-1][gox]==1)
                        goy-=1;
                    else if(arr[goy][gox-1]==1)
                        gox-=1;
                }
            }
            else if(gox<=(locationX[go]+1)&&goy>(locationY[go]+1)){

                if(arr[goy-1][gox]==0||arr[goy-1][gox]==3)
                    goy-=1;
                else if(arr[goy][gox+1]==0||arr[goy][gox+1]==3)
                    gox+=1;
                else if(arr[goy+1][gox]==0||arr[goy+1][gox]==3)
                    goy+=1;
                else if(arr[goy][gox-1]==0||arr[goy][gox-1]==3)
                    gox-=1;
                else{
                    arr[goy][gox]=4;
                    if(arr[goy+1][gox]==1)
                        goy+=1;
                    else if(arr[goy][gox+1]==1)
                        gox+=1;
                    else if(arr[goy-1][gox]==1)
                        goy-=1;
                    else if(arr[goy][gox-1]==1)
                        gox-=1;
                }

            }
            else if(gox>(locationX[go]+1)&&goy>(locationY[go]+1)){

                if(arr[goy-1][gox]==0||arr[goy-1][gox]==3)
                    goy-=1;
                else if(arr[goy][gox-1]==0||arr[goy][gox-1]==3)
                    gox-=1;
                else if(arr[goy+1][gox]==0||arr[goy+1][gox]==3)
                    goy+=1;
                else if(arr[goy][gox+1]==0||arr[goy][gox+1]==3)
                    gox+=1;

                else{
                    arr[goy][gox]=4;
                    if(arr[goy+1][gox]==1)
                        goy+=1;
                    else if(arr[goy][gox+1]==1)
                        gox+=1;
                    else if(arr[goy-1][gox]==1)
                        goy-=1;
                    else if(arr[goy][gox-1]==1)
                        gox-=1;
                }
            }
            for(i=0;i<10;i++){
                for(j=0;j<8;j++){
                    System.out.print(arr[j][i]+" ");
                }
                System.out.println("");
            }
            System.out.println();
            System.out.println(gox+" "+goy);
            System.out.println((locationX[go]+1)+" "+(locationY[go]+1));
        }

        for(i=1;i<7;i++){
            for(j=1;j<9;j++){
                if(arr[i][j]==0){
                    if(arr[i-1][j]==1&&arr[i][j+1]==1)
                        arr[i][j]=1;
                    else if(arr[i][j+1]==1&&arr[i+1][j]==1)
                        arr[i][j]=1;
                    else if(arr[i+1][j]==1&&arr[i][j-1]==1)
                        arr[i][j]=1;
                    else if(arr[i][j-1]==1&&arr[i-1][j]==1)
                        arr[i][j]=1;
                }
            }
        }

        System.out.println("");
        for(i=0;i<10;i++){
            for(j=0;j<8;j++){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println("");
        }


        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(result);

            for (int num = 0; num < peoples.length(); num++) {
                JSONObject c = peoples.getJSONObject(num);
                String first = c.getString(tag_x);
                String second = c.getString(tag_y);
                int x = Integer.parseInt(first);
                int y = Integer.parseInt(second);
                arr[y][x] = 3;

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData(String url){
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String uri = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n");
                    }
                    return sb.toString().trim();
                }catch(Exception e){
                    return null;
                }
            }
            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }

    public static int sub(int a,int b){
        if(a>b)
            return a-b;
        else
            return b-a;
    }
}

