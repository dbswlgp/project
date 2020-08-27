package com.example.tongtong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    Button button1, button2, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.editText);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });


    }

    public void btn1Method(View view) {

        AlertDialog.Builder dl = new AlertDialog.Builder(MainActivity.this);
        dl.setIcon(R.drawable.warning_icon);
        //dl.setTitle("제목");

        double d = Double.parseDouble(edit1.getText().toString());
        if (d < 0.03) {
            dl.setIcon(R.drawable.ok_icon);
            dl.setTitle("운전 가능");
            dl.setMessage("안전운전 하세요~");
        }
        else if (d >= 0.03 & d < 0.08 ) {
            //dl.setIcon(R.drawable.warning_icon);
            dl.setTitle("귀하는 현재 운전이 불가합니다");
            dl.setMessage("< 0.03% - 0.08% 미만 >\n" +
                    "단순음주 : 벌점 100점\n" +
                    "대물사고 : 벌점 100점\n" +
                    "대인사고 : 면허취소 (결격기간 2년)");
        }
        else if (d >= 0.08 & d < 0.2){
            //dl.setIcon(R.drawable.warning_icon);
            dl.setTitle("귀하는 현재 운전이 불가합니다");
            dl.setMessage("< 0.08% - 0.2% 미만 >\n" +
                    "단순음주 : 면허취소 (결격기간 1년)\n" +
                    "대물사고, 대인사고 : 면허취소 (결격기간 2년)\n" +
                    "1년 ~ 2년 이하 징역 또는 500만원 ~ 1,000 만원 이하의 벌금이 부과될 수 있습니다");
        }
        else{
            //dl.setIcon(R.drawable.warning_icon);
            dl.setTitle("귀하는 현재 운전이 불가합니다");
            dl.setMessage("< 0.2% 이상 >\n" +
                    "단순음주 : 면허취소 (결격기간 1년\n" +
                    "대물사고, 대인사고 : 면허취소 (결격기간 2년)\n" +
                    "2년 ~ 5년 이하 징역 또는 1,000만원 ~ 2,000만원 이하 벌금이 부과될 수 있습니다");
        }

            dl.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dl.show();

        }
}