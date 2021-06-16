package com.example.teacherapplication.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.Nullable;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.Lop;
import com.example.teacherapplication.Model.Mon;

import java.util.ArrayList;
import java.util.List;

public class RDThongtinActivity extends Activity implements View.OnClickListener {
    final static String EMPTY_ALERT_TITLE = "Lỗi nhập liệu";
    final static String EMPTY_ALERT_CONTENT = "Bạn chưa điền đầy đủ thông tin!";
    List<Lop> dslop;
    List<Mon> dsmon;
    Spinner monSpn, lopSpn;
    Button backBtn, nextBtn;
    EditText tieudeEdt, motaEdt;
    DeThi dethi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_thongtin);
        initView();
        switchGUI();
    }

    private void initView() {
        monSpn = findViewById(R.id.rade_thongtin_spinnerMon);
        lopSpn = findViewById(R.id.rade_thongtin_spinnerLop);
        backBtn = findViewById(R.id.rade_thongtin_backBtn);
        nextBtn = findViewById(R.id.rade_thongtin_nextBtn);
        tieudeEdt = findViewById(R.id.rade_thongtin_tieudeEdt);
        motaEdt = findViewById(R.id.rade_thongtin_motaEdt);
        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    /**
     *
     */
    public void switchGUI() {
        dslop = Database.getDSLop();
        dsmon = Database.getDSMon();
        loadView();
    }

    private void loadView() {
        loadMonView();
        loadLopView();
    }

    private void loadLopView() {
        List<String> lopLabels = new ArrayList<>();
        for(Lop lop: dslop){
            lopLabels.add(lop.label);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                lopLabels);
        lopSpn.setAdapter(arrayAdapter);
    }

    private void loadMonView() {
        List<String> monLabels = new ArrayList<>();
        for(Mon mon: dsmon){
            monLabels.add(mon.ten);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                monLabels);
        monSpn.setAdapter(arrayAdapter);
    }


    /**
     *
     */
    public void clickNext() {
        getValue();
        if(checkEmpty(dethi)) return;
        Bundle bundle = new Bundle();
        bundle.putSerializable(ActivitiesTransfer.DETHI_MESSAGECODE, dethi);
        ActivitiesTransfer.sendMessage(this, RDDSCauhoiActivity.class, bundle);
    }
    private void clickBack() {
        finish();
    }
    /**
     *
     */
    public void getValue() {
        String tieude = tieudeEdt.getText().toString();
        String mota = motaEdt.getText().toString();
        Lop lop = getLop((String) lopSpn.getSelectedItem());
        Mon mon = getMon((String) monSpn.getSelectedItem());
        dethi = new DeThi(tieude, mota, lop, mon);
    }
    private boolean checkEmpty(DeThi dethi){
        String tieude = dethi.getTieuDe();
        String noidung = dethi.getNoiDung();
        if(tieude == null || noidung == null) return true;
        return checkEmpty(tieude) || checkEmpty(noidung);
    }

    private boolean checkEmpty(String data) {
        if(data.isEmpty()){
            displayAlert();
            return true;
        }
        return false;
    }
    private void displayAlert() {

        new AlertDialog.Builder(RDThongtinActivity.this)
                .setTitle(EMPTY_ALERT_TITLE)
                .setMessage(EMPTY_ALERT_CONTENT)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rade_thongtin_backBtn:clickBack();
                break;
            case R.id.rade_thongtin_nextBtn:clickNext();
                break;
        }
    }

    private Lop getLop(String label){
        for(Lop lop: dslop){
            if(lop.label.equals(label)) return lop;
        }
        return null;
    }
    private Mon getMon(String label){
        for(Mon mon: dsmon){
            if(mon.ten.equals(label)) return mon;
        }
        return null;
    }


}
