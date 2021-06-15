package com.example.teacherapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.Lop;
import com.example.teacherapplication.Model.Mon;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    private int lopDaChon;
    private String monHocDachon;
    private int lopMacDinh;
    private String monHocMacDinh;
//
    ListView lv;
    List<DeThi> dethi;
    AdapterExam adapter;

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
//
        dethi= Database.deThiExample();
        adapter = new AdapterExam(this, 0, dethi);
        lv = findViewById(R.id.trangchu_list_dethi);
        lv.setAdapter(adapter);
        handleLvAction();
    }

    private void handleLvAction() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bd = new Bundle();
                DeThi deClicked = (DeThi) lv.getItemAtPosition(i);
                bd.putString("ID DE", deClicked.id);
                ActivitiesTransfer.sendMessage(TrangChuActivity.this, LDThongtinActivity.class, bd);
            }
        });
    }
//
    public void addExam() {
        // TODO implement here
    }

    /**
     * @param arrLop
     */
    public void initSpinner(ArrayList<String> arrLop) {
        // TODO implement here
    }

    /**
     *
     */
    public void setOnListennerForButton() {
        // TODO implement here
    }

    /**
     *
     */
    public void setOnListennerForSpinner() {
        // TODO implement here
    }

    /**
     *
     */
    public void updateUI() {
        // TODO implement here
    }

    /**
     * @param lop
     */
    public void setAttLopDaChon(int lop) {
        // TODO implement here
    }

    /**
     * @param mon
     */
    public void setAttMonHocDachon(String mon) {
        // TODO implement here
    }

    /**
     *
     */
    public void doExam() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getId() {
        // TODO implement here
        return "";
    }
}