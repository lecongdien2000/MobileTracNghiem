package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.TracNghiem;

import java.util.ArrayList;
import java.util.List;
import com.example.teacherapplication.*;

public class RDDSCauhoiActivity extends Activity implements View.OnClickListener {
    DeThi dethi;
    List<TracNghiem> tracNghiems = new ArrayList<>();
    ListView dscauhoiLV;
    Button addBtn, finishBtn;
    final static String DETHI_MESSAGECODE = "dethi";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_dscauhoi);
        initView();
        switchGUI((DeThi)ActivitiesTransfer.receiveSerializableMessage(getIntent(),RDThongtinActivity.DETHI_MESSAGECODE));
    }

    private void initView() {
        dscauhoiLV = findViewById(R.id.rade_dscauhoi_list);
        addBtn = findViewById(R.id.rade_dscauhoi_addCauHoiBtn);
        finishBtn = findViewById(R.id.rade_dscauhoi_finishBtn);
        addBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        if (resultCode == RESULT_OK) {
//            dethi = (DeThi) intent.getSerializableExtra(RDThongtinActivity.DETHI_MESSAGECODE);
//            switchGUI(dethi);
//            super.onActivityResult(requestCode, resultCode, intent);
//        }
//    }

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
        bundle.putSerializable(DETHI_MESSAGECODE, dethi);
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
        }
    }
}
