package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import com.example.teacherapplication.*;

public class RDDangthanhcongActivity extends Activity implements View.OnClickListener{
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rade_dangthanhcong);
        initView();
    }
    private void initView() {
        Button button = findViewById(R.id.rade_dangthanhcong_button);
        button.setOnClickListener(this);
    }

    /**
     *
     */
    /**
     *
     */
    public void swtichGUI() {
        // TODO implement here
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TrangChuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
