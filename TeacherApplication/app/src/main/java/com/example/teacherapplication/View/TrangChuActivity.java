package com.example.teacherapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.Lop;
import com.example.teacherapplication.Model.Mon;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lv;
    ArrayList<DeThi> dethi;
    AdapterExam adapter;
    private int lopDaChon = lopMacDinh;
    private String monHocDachon = monHocMacDinh;
    private static final  int lopMacDinh = 1;
    private static final String monHocMacDinh = "Toán";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        initView();
        handleLvAction();
        ArrayList<String> arrLop = new ArrayList<>();
        arrLop.add("Lớp 1");
        arrLop.add("Lớp 2");
        arrLop.add("Lớp 3");
        arrLop.add("Lớp 4");
        arrLop.add("Lớp 5");
        arrLop.add("Lớp 6");
        arrLop.add("Lớp 7");
        arrLop.add("Lớp 8");
        arrLop.add("Lớp 9");
        arrLop.add("Lớp 10");
        arrLop.add("Lớp 11");
        arrLop.add("Lớp 12");
        initSpinner(arrLop);
        setOnListennerForSpinner();
    }

    // H
    private void initView() {
        Button addBtn = findViewById(R.id.trangchu_addBtn);
        addBtn.setOnClickListener(this);
        lv = findViewById(R.id.trangchu_list_dethi);
    }

    // H
    private void handleLvAction() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bd = new Bundle();
                bd.putString("ID DE", dethi.get(i).id);
                ActivitiesTransfer.sendMessage(TrangChuActivity.this, LDThongtinActivity.class, bd);
            }
        });
    }
//
    public void addExam() {
        ActivitiesTransfer.sendMessage(this, RDThongtinActivity.class, new Bundle());
    }

    /**
     * @param arrLop
     */
    public void initSpinner(ArrayList<String> arrLop) {
        spinner = findViewById(R.id.trangchu_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrLop);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        updateUI(monHocMacDinh, lopMacDinh);
    }

    /**
     *
     */
    public void setOnListennerForButton(View view) {
        Button btn = (Button)view;
        setAttMonHocDachon(btn.getText().toString());
        updateUI(monHocDachon,lopDaChon);
    }

    /**
     *
     */
    public void setOnListennerForSpinner() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setAttLopDaChon(spinner.getSelectedItem().toString());//tra ve "Lớp 1"
                updateUI(monHocDachon, lopDaChon);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     *
     */
    public void updateUI(String subject, int lop) {
        dethi = Database.getDeThi(subject, lop);
        AdapterExam adapter = new AdapterExam(this, 0);
        adapter.setArray( dethi);
        lv.setAdapter(adapter);
    }

    /**
     * @param lop
     */
    public void setAttLopDaChon(String lop) {
            this.lopDaChon = Integer.parseInt(lop.substring(4).trim());
    }

    /**
     * @param mon
     */
    public void setAttMonHocDachon(String mon) {
                this.monHocDachon = mon;
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