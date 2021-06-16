package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.TracNghiem;

import java.util.ArrayList;
import java.util.List;
import com.example.teacherapplication.*;

public class RDDSCauhoiActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    DeThi dethi;
    List<TracNghiem> tracNghiems = new ArrayList<>();
    ListView dscauhoiLV;
    Button addBtn, finishBtn;
    ImageButton backBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_dscauhoi);
        initView();
        switchGUI((DeThi)ActivitiesTransfer.receiveSerializableMessage(getIntent(),ActivitiesTransfer.DETHI_MESSAGECODE));
    }

    private void initView() {
        dscauhoiLV = findViewById(R.id.rade_dscauhoi_list);
        addBtn = findViewById(R.id.rade_dscauhoi_addCauHoiBtn);
        finishBtn = findViewById(R.id.rade_dscauhoi_finishBtn);
        backBtn = findViewById(R.id.rade_dscauhoi_backBtn);
        dscauhoiLV.setOnItemClickListener(this);
        addBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    /**
     * @param dethi
     */
    public void switchGUI(DeThi dethi) {
        this.dethi = dethi;
        tracNghiems = dethi.getDSTracNghiem();
        loadDSTracNghiem(tracNghiems);
    }

    /**
     * @param dsTracNghiem
     */
    public void loadDSTracNghiem(List<TracNghiem> dsTracNghiem) {
        List<String> dscauhoiStr = new ArrayList<>();
        int stt = 0;
        for(TracNghiem tracnghiem: dsTracNghiem){
            dscauhoiStr.add(++stt + "." + tracnghiem.cauHoi);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                dscauhoiStr);
        dscauhoiLV.setAdapter(arrayAdapter);
    }

    /**
     *
     */
    public void addCauHoi() {
        Bundle bundle = new Bundle();
        bundle.putInt(ActivitiesTransfer.ACTION, R.id.rade_dscauhoi_addCauHoiBtn);
        bundle.putSerializable(ActivitiesTransfer.DETHI_MESSAGECODE, dethi);
        ActivitiesTransfer.sendMessage(this, RDThemcauhoiActivity.class, bundle);
    }

    /**
     *
     */
    public void finishAction() {
        Database.insertDeThi(dethi);
        ActivitiesTransfer.sendMessage(this, RDDangthanhcongActivity.class, new Bundle());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rade_dscauhoi_addCauHoiBtn: addCauHoi(); break;
            case R.id.rade_dscauhoi_finishBtn: finishAction(); break;
            case R.id.rade_dscauhoi_backBtn: clickBack(); break;
        }
    }

    private void clickBack() {
        finish();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.rade_dscauhoi_list: clickItem(position, tracNghiems.get(position)); break;
        }
    }

    private void clickItem(int pos, TracNghiem tracnghiem) {
        Bundle bundle = new Bundle();
        bundle.putInt(ActivitiesTransfer.ACTION, R.id.rade_dscauhoi_list);
        bundle.putSerializable(ActivitiesTransfer.DETHI_MESSAGECODE, dethi);
        bundle.putSerializable(ActivitiesTransfer.TRACNGHIEM_MESSAGECODE, tracnghiem);
        bundle.putInt(ActivitiesTransfer.INDEX_MESSAGECODE, pos);
        ActivitiesTransfer.sendMessage(this, RDThemcauhoiActivity.class, bundle);

    }
}
