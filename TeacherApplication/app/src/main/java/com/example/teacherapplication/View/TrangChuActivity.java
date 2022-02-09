package com.example.teacherapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.Lop;
import com.example.teacherapplication.Model.Mon;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
        Button btnToan = findViewById(R.id.trangchu_btnMonHocToan);
        btnToan.setBackgroundColor(Color.rgb(3, 169, 244));
    }

    /**
     *
     */
    public void setOnListennerForButton(View view) {
        Button btn = (Button)view;
        setColorAllButton();
        setAttMonHocDachon(btn.getText().toString());
        btn.setBackgroundColor(Color.rgb(3, 169, 244));
        updateUI(monHocDachon,lopDaChon);
    }

    private void setColorAllButton(){
        Button btnToan = findViewById(R.id.trangchu_btnMonHocToan);
        btnToan.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnLy = findViewById(R.id.trangchu_btnMonHocLy);
        btnLy.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnHoa = findViewById(R.id.trangchu_btnMonHocHoa);
        btnHoa.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnSinh = findViewById(R.id.trangchu_btnMonHocSinh);
        btnSinh.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnSu = findViewById(R.id.trangchu_btnMonHocSu);
        btnSu.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnDia = findViewById(R.id.trangchu_btnMonHocDia);
        btnDia.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnGDCD = findViewById(R.id.trangchu_btnMonHocGDCD);
        btnGDCD.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnCN = findViewById(R.id.trangchu_btnMonHocCN);
        btnCN.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnTin = findViewById(R.id.trangchu_btnMonHocTin);
        btnTin.setBackgroundColor(Color.rgb(103, 239, 226));
        Button btnAnh = findViewById(R.id.trangchu_btnMonHocAnh);
        btnAnh.setBackgroundColor(Color.rgb(103, 239, 226));

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