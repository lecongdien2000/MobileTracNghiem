package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        int id = ActivitiesTransfer.receiveIntMessage(it, "ID DE");
        currentDeThi = Database.getAPartExamInfor(id);
    }

    public void doExam(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("ID DE", currentDeThi.getId());
        ActivitiesTransfer.sendMessage(LDThongtinActivity.this, LDLambaiActivity.class, bundle);
    }
}
