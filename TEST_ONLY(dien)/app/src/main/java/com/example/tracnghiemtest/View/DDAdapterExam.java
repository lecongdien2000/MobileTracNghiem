package com.example.tracnghiemtest.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.tracnghiemtest.Model.DeThi;
import com.example.tracnghiemtest.R;

import java.util.List;

public class DDAdapterExam extends ArrayAdapter<DeThi> {
    private DeDaDuyetActivity activity;
    private int layout = R.layout.list_de_da_duyet;
    private List<DeThi> deThiList;
    private Context context;


    public DDAdapterExam(@NonNull Activity activity, int resource, List<DeThi> listDe){
        super(activity, resource);
        this.activity = (DeDaDuyetActivity) activity;
        deThiList = listDe;

    }


    @Override
    public int getCount() {
        return deThiList.size();
    }

    @Override
    public DeThi getItem(int position) {
        return deThiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textViewName;
        TextView textViewMoTa;
        TextView textViewLop;
        Button buttonDang;
        Button buttonHuy;

        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(layout, null);
            textViewName = convertView.findViewById(R.id.tendethiDD);
            textViewMoTa = convertView.findViewById(R.id.tvmotaDD);
            textViewLop = convertView.findViewById(R.id.tvlophocDD);
            convertView.setTag(R.id.tendethiDD, textViewName);
            convertView.setTag(R.id.tvmotaDD, textViewMoTa);
            convertView.setTag(R.id.tvlophocDD, textViewLop);

        }else {
            textViewName = (TextView)convertView.getTag(R.id.tendethiDD);
            textViewMoTa = (TextView)convertView.getTag(R.id.tvmotaDD);
            textViewLop = (TextView)convertView.getTag(R.id.tvlophocDD);

        }
        DeThi deThi = deThiList.get(position);

        textViewName.setText(deThi.getTieuDe());
        textViewMoTa.setText(deThi.getNoiDung());
        textViewLop.setText(String.valueOf(deThi.getLop()));




        return convertView;
    }


    private void deleteItem(int index){
        deThiList.remove(index);
        notifyDataSetChanged();
    }



    public void setLayout(int layout){
        this.layout = layout;
    }
   
}
