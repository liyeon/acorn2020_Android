package com.example.step03listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView에 출력할 샘플  데이터(모델)
        // 출력할 데이터를 모델이라고 한다.
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= 100; i++){
            names.add("김구라"+i);
        }
        //ListView의 참조값 얻어오기 ListView는 어떠한 목록이 반복되는 것.
        ListView listView=findViewById(R.id.listView);
        //listView에 연결할 아답타 객체
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,//android에서 미리 만들어 두고 제공해주는 리소스들은 android.으로 시작한다.
                //리스트뷰는 셀 하나하나를 출력하는데 이 하나하나는 view라고 한다.
                //view는 adapter한테서 주입받는다.
                //adapter는 데이터, 모델을 이용해서 뷰를 만든다.

                names);
        //아답타를 ListView에 연결하기
        listView.setAdapter(adapter);
        //모델 = 데이터 -> 아답타 -> 리스트 바로 연결 하지 않고 아답타를 거쳐서 연결 된다.
        //어디를 클릭했는지는 ListView가 해결한다.
        //listView에 클릭 이벤트가 일어났을 때 감시할 인터페이스
        //listView에 아이템 클릭 리스너 등록하기
        listView.setOnItemClickListener(this);
    }

    //alt + enter override
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //position은 클릭한 셀의 인덱스 이다.
        Toast.makeText(this, "인덱스 : "+position, Toast.LENGTH_SHORT).show();
    }
}