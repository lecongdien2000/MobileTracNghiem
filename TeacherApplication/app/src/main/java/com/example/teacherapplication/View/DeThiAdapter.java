package com.example.teacherapplication.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.R;

import java.util.*;

/**
 *
 */
public class DeThiAdapter extends BaseAdapter {

    private Context context;
    private List<DeThi> arrayList;
    private int layout;

    public DeThiAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }



    @Override

    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.list_dethi_layout, null);

        DeThi deThi = arrayList.get(position);
//        TextView tendethi = convertView.findViewById(R.id.tendethi);
//        TextView mota = convertView.findViewById(R.id.tvmota);
//        TextView lophoc = convertView.findViewById(R.id.tvlophoc);
        TextView tendethi = convertView.findViewById(R.id.list_dethi_tendethi);
        TextView lophoc = convertView.findViewById(R.id.list_dethi_tvlophoc);
        TextView mota = convertView.findViewById(R.id.list_dethi_tvmota);

        tendethi.setText(deThi.getTieuDe());
        mota.setText(deThi.getNoiDung());
        lophoc.setText(deThi.getLop());

        return convertView;
    }

    /**
     * @param deThi
     */
    public void setArray(ArrayList<DeThi> deThi) {
        this.arrayList = deThi;
    }
}