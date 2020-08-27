package com.example.tongtong;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.CredentialProtectedWhileLockedViolation;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SubActivity2 extends AppCompatActivity {

    String shared = "file";
    String add_array;

    ListView list2;

    CustomArrayAdapter adapter;
    public static ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);


        // 현재 액티비티를 실행하기 위해 사용된 Intent 객체를 추출한다.
        Intent intent = getIntent();

        // 저장한 데이터를 가져온다.
        String array[] = intent.getStringArrayExtra("string");

        list2 = (ListView)findViewById(R.id.list2);

        items = new ArrayList<>();

        adapter = new CustomArrayAdapter(this,R.layout.row,R.id.textView2,items);


        list2.setAdapter(adapter);


        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);

        if(array == null){

            String value = "";
            int count = sharedPreferences.getInt("count",0);
            for(int i = 0; i < count ; i++) {
                value = sharedPreferences.getString("save" + i, "");
                items.add(value);
            }
        }
        else{
            int n = 0;
            add_array = "";
            while(array[n] != null ) {
                add_array += array[n];

                if(array[n+1] != null )
                    add_array = add_array + "\n";

                n++;
            }
            items.add(0,add_array);

            String value = "";
            int count = sharedPreferences.getInt("count",0);
            for(int i = 0; i < count ; i++){
                value = sharedPreferences.getString("save"+i,"");
                items.add(value);
            }

            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int count = adapter.getCount();
        String[] list_array = new String[100];
        for(int i = 0; i < count; i++){
            list_array[i] = items.get(i);
            editor.putString("save"+i,items.get(i));
        }
        editor.putInt("count",count);

        editor.commit();
    }
}
