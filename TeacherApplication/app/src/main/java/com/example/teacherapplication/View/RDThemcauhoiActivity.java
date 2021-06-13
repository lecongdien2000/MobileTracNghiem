package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import com.example.teacherapplication.Model.CauTraLoi;
import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Model.MotLuaChon;
import com.example.teacherapplication.Model.TracNghiem;

import java.util.List;

public class RDThemcauhoiActivity extends Activity implements View.OnClickListener {
    DeThi dethi;
    TracNghiem tracNghiem;
    TracNghiemAdapter tracNghiemAdapter;
    ListView cautraloiLV;
    EditText cauhoiEdt;
    Button addBtn, completeBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_themcauhoi);
        initView();
        switchGUI((DeThi) ActivitiesTransfer.receiveSerializableMessage(getIntent(), RDDSCauhoiActivity.DETHI_MESSAGECODE));
    }

    private void initView() {
        cautraloiLV = findViewById(R.id.rade_themcauhoi_listdapan);
        cauhoiEdt = findViewById(R.id.rade_themcauhoi_cauhoiEdt);
        addBtn = findViewById(R.id.rade_themcauhoi_addBtn);
        completeBtn = findViewById(R.id.rade_themcauhoi_completeBtn);
        addBtn.setOnClickListener(this);
        completeBtn.setOnClickListener(this);
    }

    /**
     * @param dethi
     */
    public void switchGUI(DeThi dethi) {
        this.dethi = dethi;
        tracNghiem = new MotLuaChon(dethi.getDSTracNghiem().size() + "");
        tracNghiem.createBlankCauTraLois(2);
        updateList();
    }

    private void updateList() {
        tracNghiemAdapter = new TracNghiemAdapter(this, ((MotLuaChon)tracNghiem).getDsTraLoi());
        cautraloiLV.setAdapter(tracNghiemAdapter);
    }

    /**
     *
     */
    public void addCauTraLoi() {
        getValue();
        tracNghiem.createBlankCauTraLois(1);
        updateList();
    }

    /**
     *
     */
    public void finishAction() {
        getValue();
        dethi.addTracNghiem(tracNghiem);
        Bundle bundle = new Bundle();
        bundle.putSerializable(RDThongtinActivity.DETHI_MESSAGECODE, dethi);
        ActivitiesTransfer.sendMessage(this, RDDSCauhoiActivity.class, bundle);
        finish();
    }

    /**
     *
     */
    public void getValue() {
        tracNghiem.setCauhoi(cauhoiEdt.getText().toString());
        for(int i = 0; i < ((MotLuaChon)tracNghiem).getDsTraLoi().size(); i++){
            String traloi = getEditTextByPosition(i, cautraloiLV).getText().toString();
            boolean isTrue = getRadioByPosition(i, cautraloiLV).isChecked();
            tracNghiem.setCauTraLoi(i, traloi, isTrue);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rade_themcauhoi_addBtn:addCauTraLoi(); break;
            case R.id.rade_themcauhoi_completeBtn:
                finishAction();break;

        }
    }
    private View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }
    private RadioButton getRadioByPosition(int pos, ListView listView){
        return getViewByPosition(pos, listView).findViewById(R.id.row_rade_themcauhoi_radio);
    }
    private EditText getEditTextByPosition(int pos, ListView listView){
        return getViewByPosition(pos, listView).findViewById(R.id.row_rade_themcauhoi_edittext);
    }
    public class TracNghiemAdapter extends BaseAdapter {
        List<CauTraLoi> cauTraLois;
        Context context;


        public TracNghiemAdapter(Context context, List<CauTraLoi> cauTraLois){
            this.cauTraLois = cauTraLois;
            this.context = context;
        }

        public void addCauTraLoi(CauTraLoi cauTraLoi){
            cauTraLois.add(cauTraLoi);
        }


        @Override
        public int getCount() {
            return cauTraLois.size();
        }

        @Override
        public Object getItem(int position) {
            return cauTraLois.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Basic setup
            View view;
            if(convertView == null){
                view = View.inflate(context, R.layout.row_rade_themcauhoi, null);
            } else view = convertView;
            //Init view
            EditText editTxt = view.findViewById(R.id.row_rade_themcauhoi_edittext);
            RadioButton radioButton = view.findViewById(R.id.row_rade_themcauhoi_radio);
            //Set value
            CauTraLoi cauTraLoi = (CauTraLoi)getItem(position);
            editTxt.setText(cauTraLoi.noiDung);
            if(cauTraLoi.isDapAn){
                radioButton.setChecked(true);
            }else radioButton.setChecked(false);
            return view;
        }


    }
}
