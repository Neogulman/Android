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
import android.os.SystemClock;
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
    private static final String name="name";
    private static final String tag_x = "locationX";
    private static final String tag_y = "locationY";
    JSONArray peoples = null;

    static int[][] f= new int[6][8];
    static int[][] s= new int[6][8];
    static int[][] res= new int[6][8];
    static int a;
    static int b;
    static int cnt=0,temp=999;


    int[][] map= new int[6][8];//맵
    int[] locationX=new int[100];//물건 위치
    int[] locationY=new int[100];
    int[] blockX=new int[100];//벽 위치
    int[] blockY=new int[100];

    int i,j,k,pn,bn,count=0; //pn은 물건 개수, bn은 벽 개수
    int[] dist= new int[100]; //물건 거리
    int ccnt=0;
    Button a00, a10, a20, a30, a40, a50;
    Button a01, a11, a21, a31, a41, a51;
    Button a02, a12, a22, a32, a42, a52;
    Button a03, a13, a23, a33, a43, a53;
    Button a04, a14, a24, a34 ,a44, a54;
    Button a05, a15, a25, a35 ,a45, a55;
    Button a06, a16, a26, a36, a46, a56;
    Button a07, a17, a27, a37, a47, a57;
    Button show;
    Button pop;
    Button namebtn;
    Button namebtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_path);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF40A940));
        setTitle("경로");
        getData("http://52.78.55.44/getaxis.php");


        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);

        pop = (Button) findViewById(R.id.button1);
        pop.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public static int[][] find(int i,int j,int k, int l,int[][] map){
        f[i][j]=1;
        //System.out.println(i+", "+j);
        if(i==k&&j==l){
            cnt=0;
            for(a=0;a<8;a++)
                for(b=0;b<6;b++)
                    if(f[b][a]==1)
                        cnt++;

//         for(a=0;a<8;a++){
//            for(b=0;b<6;b++){
//               System.out.print(f[b][a]+" ");
//            }
//            System.out.println();
//         }
            if(temp>cnt){
                temp=cnt;
                for(a=0;a<8;a++){
                    for(b=0;b<6;b++){
                        //System.out.print(f[b][a]+" ");
                        s[b][a]=f[b][a];
                    }
                    //System.out.println();
                }
            }

            System.out.println("Find End");
            //return s;
        }
        if(i+1<6&&map[i+1][j]!=2&&f[i+1][j]==0)
            find(i+1,j,k,l,map);
        if(j+1<8&&map[i][j+1]!=2&&f[i][j+1]==0)
            find(i,j+1,k,l,map);
        if(i-1>=0&&map[i-1][j]!=2&&f[i-1][j]==0)
            find(i-1,j,k,l,map);
        if(j-1>=0&&map[i][j-1]!=2&&f[i][j-1]==0)
            find(i,j-1,k,l,map);

        f[i][j]=0;
        return s;
    }


    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.show:

                         bn=24;
                locationX[0]=1;
                locationY[0]=0;

                locationX[pn-1]=6;
                locationY[pn-1]=5;
                map[0][0]=2;
                map[1][0]=2;
                map[2][0]=2;
                map[3][0]=2;
                map[4][0]=2;
                map[5][0]=2;
                map[1][2]=2;
                map[2][2]=2;
                map[4][2]=2;
                map[5][2]=2;
                map[1][4]=2;
                map[2][4]=2;
                map[4][4]=2;
                map[5][4]=2;
                map[1][5]=2;
                map[2][5]=2;
                map[4][5]=2;
                map[5][5]=2;
                map[0][7]=2;
                map[1][7]=2;
                map[2][7]=2;
                map[3][7]=2;
                map[4][7]=2;
                map[5][7]=2;


                for(i=0;i<pn;i++)
                    map[locationY[i]][locationX[i]]=0; //물건 설치

                for(i=0;i<pn;i++)
                    dist[i]=locationX[i]*locationX[i]+locationY[i]*locationY[i];

                res=new int[6][8];
                for(i=count;i<pn-1;i++){
                    s=new int[6][8];
                    temp=999;
                    find(locationY[i],locationX[i],locationY[i+1],locationX[i+1],map);
                    for(i=0;i<8;i++) {
                        for(j=0;j<6;j++) {
                            if (res[j][i] == 1) {
                                String temp = "a" + j + i;
                                int temp2 = getResources().getIdentifier(temp, "id", getPackageName());
                                namebtn2 = (Button) findViewById(temp2);
                                if(ccnt%2==0) {
                                    namebtn2.setBackgroundColor(0xFF339F9F);
                                }
                                else if(ccnt%2==1){
                                    namebtn2.setBackgroundColor(0xFFFFFFF);
                                }
                            }
                        }
                        }

                    for(j=0;j<8;j++){
                        for(k=0;k<6;k++){
                            System.out.print(s[k][j]+" ");
                            if(s[k][j]==1)
                                res[k][j]=s[k][j];
                        }
                        System.out.println();
                    }
                }

                for(i=0;i<8;i++){

                    for(j=0;j<6;j++) {
                        if (res[j][i] == 1) {
                            String temp = "a" + j + i;
                            int temp2 = getResources().getIdentifier(temp, "id", getPackageName());
                            namebtn2 = (Button) findViewById(temp2);
                          //  namebtn2.setBackgroundColor(0xFF3399FF);
                            if(ccnt==0) {
                                namebtn2.setBackgroundColor(0xFFCCFFFF);
                            }
                            else if(ccnt==1){
                                namebtn2.setBackgroundColor(0xFF99FFFF);
                            }
                            else if(ccnt==2){
                                namebtn2.setBackgroundColor(0xFF77FFFF);
                            }
                            else if(ccnt==3){
                                namebtn2.setBackgroundColor(0xFF33FFFF);
                            }
                            else if(ccnt==4){
                                namebtn2.setBackgroundColor(0xFF33FFCC);
                            }
                            else if(ccnt==5){
                                namebtn2.setBackgroundColor(0xFF00FFCC);
                                 ccnt=0;
                            }

                        }

                    }
                }
                count++;
                ccnt++;
                break;
            default:
                Intent intent= new Intent(this, PopupActivity.class);
                startActivity(intent);
                break;
        }
    }


    protected void showList() {
            int num;
                try {
                    JSONObject jsonObj = new JSONObject(myJSON);
                    peoples = jsonObj.getJSONArray(result);
                    for (num = 0; num < peoples.length(); num++) {

                        JSONObject c = peoples.getJSONObject(num);
                        String nametemp = c.getString(name);
                        String first = c.getString(tag_x);
                        String second = c.getString(tag_y);
                        int x = Integer.parseInt(first);
                        int y = Integer.parseInt(second);

                        String temp3 = "a"+x+y;
                        int temp2 = getResources().getIdentifier(temp3,"id",getPackageName());
                        namebtn = (Button)findViewById(temp2);
                        namebtn.setText(nametemp);
                        namebtn.setBackgroundColor(0xFFFF7493);
                        locationX[num+1]=y;
                        locationY[num+1]=x;
                    }
                    pn=num+2;
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

