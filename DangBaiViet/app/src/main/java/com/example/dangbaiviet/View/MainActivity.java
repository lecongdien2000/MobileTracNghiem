package com.example.dangbaiviet.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.dangbaiviet.Model.DeThi;
import com.example.dangbaiviet.Model.Lop;
import com.example.dangbaiviet.R;
import com.example.dangbaiviet.View.AdapterExam;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DeThi> listDeThi ;
    private ListView listView;
//    private ArrayAdapter<DeThi> adapter;
    private AdapterExam adapterExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listDeThi = new ArrayList<>();
        listDeThi.add(new DeThi("D01", "Đạo hàm1", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
        listDeThi.add(new DeThi("D02", "Đạo hàm2", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
        listDeThi.add(new DeThi("D03", "Đạo hàm3", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
        listDeThi.add(new DeThi("D04", "Đạo hàm4", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
        listDeThi.add(new DeThi("D05", "Đạo hàm5", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
//
//        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listDeThi);

        adapterExam = new AdapterExam(this, R.layout.list_de, listDeThi);
        listView = findViewById(R.id.list_dethi);
        listView.setAdapter(adapterExam);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String deThi = String.valueOf(listDeThi.get(position));
//                int index = position;
//            }
//        });

    }
}