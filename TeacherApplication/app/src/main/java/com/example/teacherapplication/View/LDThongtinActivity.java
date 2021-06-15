package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;

public class LDThongtinActivity extends Activity {
    Button doExamBtn;
    DeThi currentDeThi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamde_thongtin);
        doExamBtn = findViewById(R.id.doExamBtn);
        Intent it = getIntent();
        String id = ActivitiesTransfer.receiveStringMessage(it, "ID DE");
        currentDeThi = Database.getAPartExamInfor(id);
        init();
    }

    public void init(){
        TextView tieude = findViewById(R.id.lamde_thongtin_tieudeTV);
        TextView mon = findViewById(R.id.lamde_thongtin_monTV);
        TextView lop = findViewById(R.id.lamde_thongtin_lopTV);
        TextView mota = findViewById(R.id.lamde_thongtin_motaTV);
        tieude.setText(currentDeThi.tieuDe);
        mon.setText(currentDeThi.monHoc.ten);
        lop.setText("" + currentDeThi.lop.lop);
        mota.setText(currentDeThi.noiDung);
    }
    public void doExam(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("ID DE", currentDeThi.id);
        ActivitiesTransfer.sendMessage(LDThongtinActivity.this, LDLambaiActivity.class, bundle);
    }
}
