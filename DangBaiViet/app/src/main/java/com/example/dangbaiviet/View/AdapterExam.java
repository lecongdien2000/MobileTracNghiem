package com.example.dangbaiviet.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dangbaiviet.Model.DeThi;
import com.example.dangbaiviet.R;

import java.util.List;

public class AdapterExam extends BaseAdapter {
    private Activity activity;
    private int layout;
    private List<DeThi> deThiList;

    public AdapterExam(Activity activity, int layout, List<DeThi> deThiList) {
        this.activity = activity;
        this.layout = layout;
        this.deThiList = deThiList;
    }

    @Override
    public int getCount() {
        return deThiList.size();
    }

    @Override
    public Object getItem(int position) {
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
            textViewName = convertView.findViewById(R.id.tendethi);
            textViewMoTa = convertView.findViewById(R.id.tvmota);
            textViewLop = convertView.findViewById(R.id.tvlophoc);
            buttonDang = convertView.findViewById(R.id.btndang);
            buttonHuy = convertView.findViewById(R.id.btnhuy);
            convertView.setTag(R.id.tendethi, textViewName);
            convertView.setTag(R.id.tvmota, textViewMoTa);
            convertView.setTag(R.id.tvlophoc, textViewLop);
            convertView.setTag(R.id.btndang, buttonDang);
            convertView.setTag(R.id.btnhuy, buttonHuy);

        }else {
            textViewName = (TextView)convertView.getTag(R.id.tendethi);
            textViewMoTa = (TextView)convertView.getTag(R.id.tvmota);
            textViewLop = (TextView)convertView.getTag(R.id.tvlophoc);
            buttonDang = (Button) convertView.getTag(R.id.btndang);
            buttonHuy = (Button) convertView.getTag(R.id.btnhuy);

        }
        DeThi deThi = deThiList.get(position);

        textViewName.setText(deThi.getTieuDe());
        textViewMoTa.setText(deThi.getNoiDung());
        textViewLop.setText(String.valueOf(deThi.getLop()));


        buttonDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(this, "Đăng thành công", Toast.LENGTH_SHORT).show();
                updateStatus(position);
                Toast.makeText(activity.getApplicationContext(), "Đã duyệt ", Toast.LENGTH_SHORT).show();
                deleteItem(position);
            }
        });

        buttonHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
        return convertView;
    }

    //update trang thai dang duyet hay chua
    private void updateStatus(int index){
        deThiList.get(index);
        deThiList.get(index).isAccepted = true;
        notifyDataSetChanged();
    }

    private void deleteItem(int index){
        deThiList.remove(index);
        notifyDataSetChanged();
    }

    ///xoa item trong listview
    private void removeItem(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Bạn có chắc chắn huỷ không?");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deThiList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
//        AlertDialog alertDialog = builder.create();
       builder.show();

    }
}
