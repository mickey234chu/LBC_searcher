package com.example.lbc_searcher;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient().newBuilder().build();
    private ListView lvShow;
    //建立人罪人分類陣列
    private String[] search_name=new String[]{"牛排","麵條","飯","自助餐","咖啡","甜品","都可以"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvShow = findViewById(R.id.listview);
    }
    @Override
    protected  void onResume()
    {
        super.onResume();
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,search_name);//展示地點,格式,字串
        lvShow.setAdapter(adapter);
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //取得有關分類JSON格式的資料
                //都可以->只要分類是餐廳都拿回來
                Request request;
                //根據點選罪人抓取對應人格資料
                request = new Request.Builder()
                        .url("")
                        .build();
                //發送API要求
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    //回傳處理
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        // 連線成功，自response取得連線結果
                        String result = response.body().string();
                        JSONObject Jobject = null;
                        //String to json
                        /*try {



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/


                    }

                    @Override
                    public void onFailure(Call call, IOException e) {
                        // 連線失敗

                    }
                });

                /*Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("targeting",fruit_name[position]);
                startActivity(intent);*/
            }
        });
    }
}