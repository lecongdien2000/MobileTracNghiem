package com.example.teacherapplication.View;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import com.example.teacherapplication.*;
import com.example.teacherapplication.Model.CauTraLoi;
import com.example.teacherapplication.Model.DeThi;

import java.util.List;

public class LDLambaiActivity extends Activity {
    /**
     *
     */
    public DeThi de;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamde_lambai);
    }



//    /**
//     * @return
//     */
//    public void getIntent() {
//        // TODO implement here
//        return null;
//    }

    /**
     *
     */
    public void submit() {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<CauTraLoi> getAnswer() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int mark() {
        // TODO implement here
        return 0;
    }

}
