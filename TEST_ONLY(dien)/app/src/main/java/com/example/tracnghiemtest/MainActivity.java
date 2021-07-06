package com.example.tracnghiemtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Lop lop;
    Button button;
    TextView text;
    int solop = 2;
    MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            try {
                text.setText(Database.getFullExamInfor("de01").toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}