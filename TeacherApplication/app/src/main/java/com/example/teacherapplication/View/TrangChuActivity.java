package com.example.teacherapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Database.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity {
    private int lopDaChon = lopMacDinh;
    private String monHocDachon = monHocMacDinh;
    private static final  int lopMacDinh = 1;
    private static final String monHocMacDinh = "Toán";
    private ArrayList<String> arrLop = new ArrayList<>();
    private Spinner spinner;
    private ListView lview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
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

    public void addExam() {
        // TODO implement here
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
        System.out.println(btn.getText().toString());
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
        //create adapter DeThi
        DeThiAdapter adapter = new DeThiAdapter(this,0);
        adapter.setArray( Database.getDeThi(subject, lop));
        lview = findViewById(R.id.trangchu_list_dethi);
        lview.setAdapter(adapter);
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


}