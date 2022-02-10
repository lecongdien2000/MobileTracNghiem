package com.example.tracnghiemtest.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.tracnghiemtest.*;
import com.example.tracnghiemtest.Database.Database;
import com.example.tracnghiemtest.Model.DeThi;
import com.example.tracnghiemtest.Model.MotLuaChon;
import com.example.tracnghiemtest.Model.TracNghiem;

import java.util.List;

public class LDLambaiActivity extends Activity {
//
    public LDCustomAdapter adapter;
    public ListView listView;
    /**
     *
     */
    public Button nopbaiBtn;
    public DeThi de;
//
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamde_lambai);
        nopbaiBtn = findViewById(R.id.lamde_lambai_sentBtn);
        Intent it = getIntent();
        String id = ActivitiesTransfer.receiveStringMessage(it, "ID DE");
        de = Database.getFullExamInfor(id);
        adapter = new LDCustomAdapter(this, 0, de.dsTracNghiem);
        listView = findViewById(R.id.lamde_lambai_questionLV);
        listView.setAdapter(adapter);
    }



    /**
     * @return
     */
    public int mark(List<Integer> answer) {
        // TODO implement here
        int numOfTrueAnswer= 0;
        List<TracNghiem> tn =  de.dsTracNghiem;
        for (int i =0; i< tn.size(); i++){
//            if(tn.get(i).dapAn == answer.get(i))
            MotLuaChon cauHoi = (MotLuaChon) tn.get(i);
            for(int j = 0; j<cauHoi.dsTraLoi.size() ; j++){
                if(cauHoi.dsTraLoi.get(j).isDapAn) {
                    if (answer.get(i) == j)
                        numOfTrueAnswer += 1;
                }
            }
        }

        return numOfTrueAnswer;
    }

    public void submit(View view) {
        List<Integer> answers = adapter.getChoose();
        int score = mark(answers);
        Bundle bd = new Bundle();
        bd.putInt("SCORE", score);
        bd.putString("TIEU DE", de.tieuDe);
        ActivitiesTransfer.sendMessage(this, LDKetquaActivity.class, bd);
    }
}
