package com.example.user.neogulman;


import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Activity_List extends AppCompatActivity {

    String myJSON;

    private static final String result="result";
    private static final String tag_name = "name";
    private static final String tag_volume = "volume";
    private static final String tag_price ="price";
    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF40A940));
        setTitle("물품목록");
        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String,String>>();
        getData("http://13.124.98.240/showall.php");
    }


    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(result);

            for(int i=0;i<peoples.length();i++){
                JSONObject c = peoples.getJSONObject(i);
                String name = c.getString(tag_name);
                String volume = c.getString(tag_volume);
                String price = c.getString(tag_price);

                HashMap<String,String> persons = new HashMap<String,String>();

                persons.put(tag_name,name);
                persons.put(tag_volume,volume);
                persons.put(tag_price,price);

                personList.add(persons);
            }

            ListAdapter adapter = new SimpleAdapter(
                    Activity_List.this, personList, R.layout.listview_list,
                    new String[]{tag_name,tag_volume,tag_price},
                    new int[]{R.id.name, R.id.volume, R.id.price}
            );

            list.setAdapter(adapter);


        } catch (JSONException e) {
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