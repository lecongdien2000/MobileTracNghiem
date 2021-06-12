package com.example.teacherapplication.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.Mon;
import com.example.teacherapplication.Model.TracNghiem;

import java.util.ArrayList;
import java.util.List;
import com.example.teacherapplication.*;

public class RDDSCauhoiActivity extends Activity {
    DeThi dethi;
    List<TracNghiem> tracNghiem = new ArrayList<>();
    ListView dscauhoiLV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_dscauhoi);
        initView();
        switchGUI((DeThi)ActivitiesTransfer.receiveSerializableMessage(getIntent(),RDThongtinActivity.DETHI_MESSAGECODE));
    }

    private void initView() {
        dscauhoiLV = findViewById(R.id.rade_dscauhoi_list);
    }


    /**
     * @param dethi
     */
    public void switchGUI(DeThi dethi) {
        this.dethi = dethi;
        tracNghiem = dethi.getDSTracNghiem();
        loadDSTracNghiem(tracNghiem);
    }

    /**
     * @param dsTracNghiem
     */
    public void loadDSTracNghiem(List<TracNghiem> dsTracNghiem) {
        List<String> dscauhoiStr = new ArrayList<>();
        for(TracNghiem tracnghiem: dsTracNghiem){
            dscauhoiStr.add(tracnghiem.stt + "." + tracnghiem.cauHoi);
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
        // TODO implement here
    }

    /**
     *
     */
    public void finish() {
        // TODO implement here
    }

}
