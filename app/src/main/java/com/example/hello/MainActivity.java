package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {//자바 클래스를 상속 받아서 만들었다.

    //MainActvity가 활성화 될 때 최초 한번 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R.layout.activity_main =
        //res/Layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
    }

    //버튼을 눌렀을 때 호출 되는 메소드 정의하기
    public void btnClicked(View v){
        Toast.makeText(this, "버튼을 눌렀네요?", Toast.LENGTH_SHORT).show();
    }
}//====MainActivity