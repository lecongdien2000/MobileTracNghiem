package com.example.teacherapplication.View;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.Nullable;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.Lop;
import com.example.teacherapplication.Model.Mon;

import java.util.ArrayList;
import java.util.List;

public class RDThongtinActivity extends Activity {
    List<Lop> dslop;
    List<Mon> dsmon;
    Spinner monSpn, lopSpn;
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
        // TODO implement here
    }

    /**
     *
     */
    public void getValue() {
        // TODO implement here
    }

}
