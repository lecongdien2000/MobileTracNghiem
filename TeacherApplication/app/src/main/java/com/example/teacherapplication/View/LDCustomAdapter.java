package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.teacherapplication.Model.CauTraLoi;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.MotLuaChon;
import com.example.teacherapplication.Model.TracNghiem;
import com.example.teacherapplication.R;

import java.util.*;

/**
 * 
 */
public class LDCustomAdapter extends ArrayAdapter<TracNghiem> {

    /**
     * Default constructor
     */
    Activity context;
    List<TracNghiem> data;
    int[] choosed;

    public LDCustomAdapter(@NonNull Activity context, int resource, @NonNull List<TracNghiem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.data = objects;
        choosed = new int[data.size()];
        for (int i =0; i < choosed.length; i++){
            choosed[i] =-1;
        }
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        if(convertView==null){
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_cauhoi, parent, false);
//        }
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.row_cauhoi, null);

        MotLuaChon cauhoi = (MotLuaChon) getItem(position);
        TextView tv = row.findViewById(R.id.row_cauhoi_questionNameTV);
        tv.setText(cauhoi.cauHoi);
        RadioGroup group = row.findViewById(R.id.row_cauhoi_radioGroup);
            List<CauTraLoi> dsCauTL = cauhoi.dsTraLoi;
            for (int i = 0; i < dsCauTL.size(); i++) {
                RadioButton button = new RadioButton(context);
                if(choosed[position] == i){
                    button.setChecked(true);
                }
                int tmp =i;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(button.isChecked())
                            choosed[position] = tmp;
                        else choosed[position] = -1;
                    }
                });
                button.setText(dsCauTL.get(i).noiDung);
                group.addView(button);
            }

        return  row;
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
    public void setArray(List<DeThi> cauHoi) {

    }

    /**
     * 
     */
    public void setArray() {
        // TODO implement here
    }

    public List<Integer> getChoose(){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<choosed.length; i++){
            result.add(i, choosed[i]);
        }
        return result;
    }

}