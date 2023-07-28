package com.example.lbc_searcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowIdentitylist extends AppCompatActivity {

    private ListView lvShow;
    //建立分類陣列
    public String[] search_name;
    private String jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_identitylist);
        //抓VIEW
        lvShow = findViewById(R.id.listview);

        //讀取發過來搜索結果，整理成列表
        Intent intent = getIntent();
        jsonArray = intent.getStringExtra("jsonArray");
        try {

            JSONArray array = new JSONArray(jsonArray);
            search_name = new String[array.length()];
            for (int i = 0; i < array.length(); i++) {
                JSONObject object  = array.getJSONObject(i);
                search_name[i] = object.getString("name");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}