package com.example.tracnghiemtest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.tracnghiemtest.*;

public class LDKetquaActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamde_ketqua);
        Intent it = getIntent();

        TextView tieuDeTv = findViewById(R.id.lamde_ketqua_tvlophoc);
        tieuDeTv.setText(ActivitiesTransfer.receiveStringMessage(it,"TIEU DE"));
        TextView tv = findViewById(R.id.lamde_ketqua_tvketqua);
        tv.setText("Ban sa lam dung " + ActivitiesTransfer.receiveIntMessage(it, "SCORE") + " cau");
    }

    public void backToMain(View view) {
        Intent intent = new Intent(this, TrangChuActivity.class);
        startActivity(intent);
    }
}
