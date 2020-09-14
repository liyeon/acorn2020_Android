package com.example.step01hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //버튼을 누른 횟수를 저장할 필드
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        //하나하나의 객체가 다 만들어져야한다.  constraint, button, textView
        setContentView(R.layout.activity_main);
        //R이라는 Class가 존재하는 것이다. activity_main은 static field
        //res는 resources 의 약자 앱을 개발 할 때 필요한 소스들은 다 res에 집어넣는다.
        //문자열, id View 조차도 다 리소스로 관리가 된다.
        //res에 있는 모든것들은 R class 안에 다 자동으로 등록이 된다.
        //class R (){}
        //사용하는 자원들을 16진수 정수값으로 일련번호를 부여해놓고 가져다 쓰는 것이다.
        //모든 레이아웃은 activity_main에 들어감
        Context c=this;
    }

    public void add(View v){
        //카운트를 1 증가 시킨다.
        count++;

        if(count==10){
            //ImageActivity로 이동하겠다는 의도(indent) 객체 생성하고
            //this는  MainActivity 를 가리킨다.
            Intent i=new Intent(this, ImageActivity.class); //this와 class type
            //startActivity() 메소드를 호출하면서 전달하기
            startActivity(i);
        }

        //카운트값을 TextView에 출력하기
        //document.querySelector("#one").innerText="";

        //id가 textView 인 TextView 의 참조값얻어오기
        //findViewById 참조값을 얻어오는 메소드
        //참조값을 찾을 때 쓰는 메소드
        TextView a=findViewById(R.id.textView);

        //텍스트를 변경 할 때 쓰는 메소드 정수를 문자열로 변경을 해서 전달한다.
        //count값을 문자열로 바꿔서 TextView에 출력한다.
        a.setText(Integer.toString(count));
    }
}