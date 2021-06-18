package com.example.teacherapplication.Database;

import android.os.AsyncTask;

public class BackgroundAsyncTask extends AsyncTask<Void, Void, Void> {

    public BackgroundAsyncTask(){

    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    public static BackgroundAsyncTask create(){
        return new BackgroundAsyncTask();
    }
}
