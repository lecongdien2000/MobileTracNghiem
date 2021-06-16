package com.example.teacherapplication.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.teacherapplication.Model.CauTraLoi;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.MotLuaChon;
import com.example.teacherapplication.R;

import java.util.*;

/**
 * 
 */
public class AdapterExam extends ArrayAdapter<DeThi> {

    /**
     * Default constructor
     */
//    public AdapterExam() {
//    }

    public AdapterExam(@NonNull Context context, int resource, @NonNull List<DeThi> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_dethi_layout, parent, false);
        }
        DeThi de = (DeThi) getItem(position);
        TextView tvTen = convertView.findViewById(R.id.list_dethi_tendethi);
        TextView tvLop = convertView.findViewById(R.id.list_dethi_tvlophoc);
        TextView tvMota = convertView.findViewById(R.id.list_dethi_tvmota);
        tvTen.setText(de.tieuDe);
        tvLop.setText("Lop: " + de.lop.lop);
        tvMota.setText(de.noiDung);

        return  convertView;
    }

    /**
     * @param cauHoi
     */
    public void changeData(List<DeThi> cauHoi) {
        // TODO implement here
    }

    /**
     * @param cauHoi
     */
    public void setArray(DeThi[] cauHoi) {
        // TODO implement here
    }

    /**
     * 
     */
    public void setArray() {
        // TODO implement here
    }

}