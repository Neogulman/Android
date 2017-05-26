package com.example.user.neogulman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
import android.view.View.OnClickListener;
public class PopupActivity extends Activity  implements OnClickListener {
    String myJSON;

    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_RESULTS="result";
    JSONArray peoples = null;
    TextView bname;
    TextView bprice;
    Button on;
    Button off;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);
        getData("http://52.79.178.97/showbasket.php");
        NetworkUtil.setNetworkPolicy();

        on = (Button) findViewById(R.id.on);
        //bt2= (Button)findViewById(R.id.btn2);
        on.setOnClickListener(this);

        off = (Button) findViewById(R.id.off);
        //bt2= (Button)findViewById(R.id.btn2);
        off.setOnClickListener(this);

    }

    public void onClick(View v) {
        bname =(TextView)findViewById(R.id.bname);
        switch (v.getId()) {
            case R.id.off: finish(); break;
            default :
                try {
                    PHPRequest request = new PHPRequest("http://52.79.178.97/inputbasket.php");
                    request.PhPtest(bname.getText().toString());
                    Toast.makeText(getApplication(),"장바구니에 추가되었습니다",Toast.LENGTH_SHORT).show();
                    finish();
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                break;
        }

    }
    protected void showList(){
        bname = (TextView)findViewById(R.id.bname);
        bprice = (TextView)findViewById(R.id.bprice);
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for(int i=0;i<peoples.length();i++){
                JSONObject c = peoples.getJSONObject(i);
                String name = c.getString(TAG_NAME);
                String price = c.getString(TAG_PRICE);
                bname.setText(name);
                bprice.setText(price);
            }

        }catch (JSONException e) {
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
}
