package com.example.teacherapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.teacherapplication.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity implements View.OnClickListener {
    private int lopDaChon;
    private String monHocDachon;
    private int lopMacDinh;
    private String monHocMacDinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        initView();
    }

    private void initView() {
        Button addBtn = findViewById(R.id.trangchu_addBtn);
        addBtn.setOnClickListener(this);
    }

    public void addExam() {
        ActivitiesTransfer.sendMessage(this, RDThongtinActivity.class, new Bundle());
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trangchu_addBtn: addExam();
        }
    }
}