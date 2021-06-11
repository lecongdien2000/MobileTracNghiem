package com.example.teacherapplication.View;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.teacherapplication.Model.DeThi;
import com.example.teacherapplication.Model.TracNghiem;

import java.util.List;
import com.example.teacherapplication.*;

public class RDDSCauhoiActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_dscauhoi);
    }


    /**
     * @param dethi
     */
    public void switchGUI(DeThi dethi) {
        // TODO implement here
    }

    /**
     * @param dsTracNghiem
     */
    public void loadDSTracNghiem(List<TracNghiem> dsTracNghiem) {
        // TODO implement here
    }

    /**
     *
     */
    public void addCauHoi() {
        // TODO implement here
    }

    /**
     *
     */
    public void finish() {
        // TODO implement here
    }

}
