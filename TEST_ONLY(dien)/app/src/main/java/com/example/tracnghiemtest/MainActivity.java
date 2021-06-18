package com.example.tracnghiemtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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
            MyAsyncTask async = new MyAsyncTask();
            async.execute(mainActivity);
        });
    }
}
class MyAsyncTask extends AsyncTask<MainActivity, Lop, Void>{
    MainActivity activity;

    @Override
    protected Void doInBackground(MainActivity... values) {
        activity = values[0];
        int solop = activity.solop;
        Lop lop = Database.getLop(solop);
        this.publishProgress(lop);
        return null;
    }

    @Override
    protected void onProgressUpdate(Lop... values) {
        super.onProgressUpdate(values);
        activity.text.setText(values[0].toString());
    }
}