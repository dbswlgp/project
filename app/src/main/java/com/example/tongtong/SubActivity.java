package com.example.tongtong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    ListView list1;
    Button button3;
    Button button5;
    Button button7;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        button3 = (Button)findViewById(R.id.button3);

        list1 = (ListView)findViewById(R.id.list1);

        // 데이터를 저장하게 되는 리스트
        final ArrayList<String> list = new ArrayList<>();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.checkBox, data);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
        list1.setAdapter(adapter);

        list.add("두통");
        list.add("메스꺼움 & 구토");
        list.add("설사");
        list.add("현기증");
        list.add("복통");
        list.add("속 쓰림");
        list.add("블랙아웃(기억 잃음)");

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<String> selectedItems = new ArrayList<>();

                String[] checked_string = new String[10];

                Intent intent2 = new Intent(SubActivity.this,SubActivity2.class);

                SparseBooleanArray checkedItemPositions = list1.getCheckedItemPositions();

                int j = 0;

                for (int i = 0; i < checkedItemPositions.size(); i++) {
                    int pos = checkedItemPositions.keyAt(i);

                    if (checkedItemPositions.valueAt(i)) {

                        checked_string[j] = list1.getItemAtPosition(pos).toString();
                        j++;

                    }
                }

                intent2.putExtra("string",checked_string);

                startActivity(intent2);

                finish();
            }
        });

        button5 = (Button)findViewById(R.id.button5);
        edit = (EditText)findViewById(R.id.editText);

        button5.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {


                list.add(edit.getText().toString());
                edit.setText("");

                adapter.notifyDataSetChanged();
            }
        });

        button7 = (Button)findViewById(R.id.button7);

        button7.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                int count, checked;
                count = adapter.getCount();

                SparseBooleanArray checkedItemPositions = list1.getCheckedItemPositions();

                if(checkedItemPositions.size() > 0) {
                    for (int i = checkedItemPositions.size()-1; i >= 0; i--) {

                        int pos = checkedItemPositions.keyAt(i);

                        if (checkedItemPositions.valueAt(i)) {

                            list.remove(pos);

                        }
                    }
                    list1.clearChoices();

                    adapter.notifyDataSetChanged();
                }
            }
        });



    }
}

