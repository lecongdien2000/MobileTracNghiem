package com.example.tracnghiemtest.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tracnghiemtest.Database.Database;
import com.example.tracnghiemtest.Model.DeThi;
import com.example.tracnghiemtest.R;

import java.util.ArrayList;

public class DeDaDuyetActivity extends AppCompatActivity {

    private ArrayList<DeThi> listDeThi ;
    private ListView listView;
    private DDAdapterExam adapterExam;
    private ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_da_duyet);

        imBack = findViewById(R.id.btnBackDD);
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listDeThi = Database.getDSDeThi(true);
        adapterExam = new DDAdapterExam(this, 0, listDeThi);
        listView = findViewById(R.id.list_dethiDD);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bd = new Bundle();
                bd.putString("ID DE", listDeThi.get(i).id);
                ActivitiesTransfer.sendMessage(DeDaDuyetActivity.this, LDThongtinActivity.class, bd);
            }
        });
        listView.setAdapter(adapterExam);



    }

}