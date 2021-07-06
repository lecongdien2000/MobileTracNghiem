package com.example.tracnghiemtest;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Database {
    ///Linh
    public static DeThi getFullExamInfor(String id) {
        try {
            AsyncTask<Void, Void, DeThi> async = new AsyncTask<Void, Void, DeThi>() {
                @Override
                protected DeThi doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_1);

                    //Set parameters of web service method
                    webServiceConnection.setProperty("id", id);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("DeThi", new DeThi().getClass());
                    webServiceConnection.setMapping("lop", new Lop().getClass());
                    webServiceConnection.setMapping("monHoc", new Mon().getClass());
                    webServiceConnection.setMapping("MotLuaChon", new MotLuaChon().getClass());
                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    DeThi deThi = new DeThi();
                    deThi.setProperty(0, response.getProperty("id"));
                    deThi.setProperty(1, response.getProperty("tieuDe"));
                    deThi.setProperty(2, response.getProperty("noiDung"));
                    List<TracNghiem> dsTracNghiem = new ArrayList<>();
                    SoapObject listMlcRS = (SoapObject) response.getProperty(3);
                    for(int i=0; i< listMlcRS.getPropertyCount() ; i++){
                        MotLuaChon mlc = new MotLuaChon();
                        SoapObject mlcRS = (SoapObject) listMlcRS.getProperty(i);
                        mlc.setProperty(0, mlcRS.getProperty(0));
                        mlc.setProperty(1, mlcRS.getProperty(1));
                        mlc.setProperty(2, mlcRS.getProperty(2));

                        dsTracNghiem.add(mlc);
                    }
                    deThi.dsTracNghiem = dsTracNghiem;
                    deThi.setProperty(4, response.getProperty("lop"));
                    deThi.setProperty(5, response.getProperty(("monHoc")));
                    deThi.setProperty(6, response.getProperty("isAccepted"));
                    return deThi;
                }
            };
            async.execute();
            return async.get();
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
