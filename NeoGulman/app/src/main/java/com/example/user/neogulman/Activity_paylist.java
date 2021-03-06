package com.example.user.neogulman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import android.view.View.OnClickListener;

public class Activity_paylist extends AppCompatActivity implements OnClickListener{

    String myJSON;

    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_RESULTS="result";
    JSONArray peoples = null;
    ArrayList<String> listarr = new ArrayList<String>();
    ListView list;
    String result;
    Button back;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_paylist);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF40A940));
        setTitle("장바구니");
        list = (ListView) findViewById(R.id.list_paylist);
        getData("http://52.78.55.44/showpaylist.php");
        NetworkUtil.setNetworkPolicy();


        back = (Button) findViewById(R.id.back);
        //bt2= (Button)findViewById(R.id.btn2);
        back.setOnClickListener(this);

        pay = (Button) findViewById(R.id.pay);
        //bt2= (Button)findViewById(R.id.btn2);
        pay.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pay :
                Intent intent2= new Intent(this, KakaoActivity.class);
                startActivity(intent2);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for(int i=0;i<peoples.length();i++){
                JSONObject c = peoples.getJSONObject(i);
                String name = c.getString(TAG_NAME);
                String price = c.getString(TAG_PRICE);
                String res = "품명 :   " + name + "                      " + "가격 : " + price;
                listarr.add(res);
                result = name;
            }

            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarr);

            list.setAdapter(Adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder alert_confirm = new AlertDialog.Builder(Activity_paylist.this);
                    alert_confirm.setMessage("장바구니에서 삭제하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        PHPRequest request = new PHPRequest("http://52.78.55.44/outputpaylist.php");
                                        request.PhPtest(result);
                                        Toast.makeText(getApplication(),"장바구니에서 삭제되었습니다.",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Activity_paylist.this, Activity_paylist.class);
                                        startActivity(intent);
                                    }catch (MalformedURLException e){
                                        e.printStackTrace();
                                    }
                                }
                            }).setNegativeButton("취소",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 'No'
                                    return;
                                }
                            });
                    AlertDialog alert = alert_confirm.create();
                    alert.show();
                }
            });
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void getData(String url){
        class GetDataJSON extends AsyncTask<String, Void, String>{

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
}
