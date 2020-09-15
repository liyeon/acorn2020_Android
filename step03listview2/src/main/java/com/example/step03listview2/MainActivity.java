package com.example.step03listview2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//ctrl+h 계층 구조가 보인다. Activity는Context 타입이기도 하다
//그래서 context가 필요하다면 this를 전달하면 된다.
public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener,
                   AdapterView.OnItemLongClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView는 this.를 붙인것과 똑같다.
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        this.setContentView(R.layout.activity_main);

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
        listView.setOnItemLongClickListener(this);
        //this는 longClickListener type이기도 한다.
    }

    //alt + enter override
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //position은 클릭한 셀의 인덱스 이다.
        //Toast.makeText(this, "인덱스 : "+position, Toast.LENGTH_SHORT).show();

        //android 에서는 context가 필요할 때가 많다.
        //ctrl+q 도움말 / mac 에서느 Control+J
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setMessage("선택한 셀 인덱스 : "+position);
//        builder.setNeutralButton("확인", null);
//
//        AlertDialog dialog=builder.create();
//        dialog.show();
        //위에꺼 한번에하는법 //빌더타입을 리턴해주는 메소드
        //아래는 다 alertDialog.Builder type
        //전체적인 거는 AlertDialog type
        new AlertDialog.Builder(this)
                .setMessage("선택한 셀 인덱스 : "+position)
                .setNeutralButton("확인", null)
                .create()
                .show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        new AlertDialog.Builder(this)
                .setMessage("오랫동안 클릭하셨습니다!!!")
                .setNeutralButton("확인", null)
                .create()
                .show();
        return false;
    }
}
