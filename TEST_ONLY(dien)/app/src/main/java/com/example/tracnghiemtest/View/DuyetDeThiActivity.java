package com.example.tracnghiemtest.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tracnghiemtest.Database.Database;
import com.example.tracnghiemtest.Model.DeThi;
import com.example.tracnghiemtest.R;

import java.util.ArrayList;

public class DuyetDeThiActivity extends AppCompatActivity {

    private ArrayList<DeThi> listDeThi ;
    private ListView listView;
    private AdapterExam adapterExam;
    private ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyet_de_thi);

//        listDeThi = new ArrayList<>();
//        listDeThi.add(new DeThi("D01", "Đạo hàm1", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
//        listDeThi.add(new DeThi("D02", "Đạo hàm2", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
//        listDeThi.add(new DeThi("D03", "Đạo hàm3", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
//        listDeThi.add(new DeThi("D04", "Đạo hàm4", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
//        listDeThi.add(new DeThi("D05", "Đạo hàm5", "Tổng hợp các đề đạo hàm cơ bản", new Lop(12)));
//       adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listDeThi);

        imBack = findViewById(R.id.btnBack);
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listDeThi = Database.getDSDeThi(false);
        adapterExam = new AdapterExam(this, 0, listDeThi);
        listView = findViewById(R.id.list_dethi);
        listView.setAdapter(adapterExam);

    }
    public void setStatus(String id) {
        Database.setStatus(id);
        listDeThi = Database.getDSDeThi(false);
        adapterExam = new AdapterExam(this, 0, listDeThi);
        listView = findViewById(R.id.list_dethi);
        listView.setAdapter(adapterExam);
        adapterExam.notifyDataSetChanged();
    }

}