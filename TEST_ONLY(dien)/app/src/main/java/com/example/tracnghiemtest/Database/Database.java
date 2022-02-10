package com.example.tracnghiemtest.Database;

import android.os.AsyncTask;

import com.example.tracnghiemtest.Model.DeThi;
import com.example.tracnghiemtest.Model.Lop;
import com.example.tracnghiemtest.Model.Mon;
import com.example.tracnghiemtest.Model.MotLuaChon;
import com.example.tracnghiemtest.Model.TracNghiem;

import org.ksoap2.serialization.SoapObject;

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
    public static ArrayList<DeThi> getDSDeThi(boolean isAccept) {
        try {
            AsyncTask<Void, Void, List<DeThi>> async = new AsyncTask<Void, Void, List<DeThi>>() {
                @Override
                protected List<DeThi> doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_12);

                    webServiceConnection.setProperty("isAccept", isAccept);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("DeThi", new DeThi().getClass());
                    webServiceConnection.setMapping("Lop", new Lop().getClass());

                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    // get Dethis from respone
                    List<DeThi> dethis = new ArrayList<>();
                    for(int i = 0; i < response.getPropertyCount(); i++){

                        SoapObject responseElement = (SoapObject)response.getProperty(i);

                        DeThi dethi = new DeThi();
                        dethi.setProperty(0, responseElement.getProperty(0));
                        dethi.setProperty(1, responseElement.getProperty(1));
                        dethi.setProperty(2, responseElement.getProperty(2));
                        SoapObject lopRSp = (SoapObject) responseElement.getProperty(3);
                        Lop lop = new Lop();
                        lop.setProperty(0, lopRSp.getProperty("lop"));
                        dethi.lop = lop;
                        dethi.setProperty(6, responseElement.getProperty(5));

                        dethis.add(dethi);
                    }
                    return dethis;
                }
            };
            async.execute();
            return (ArrayList<DeThi>) async.get();
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static boolean setStatus(String id){
        try {
            AsyncTask<Void, Void, Boolean> async = new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_13);

                    webServiceConnection.setProperty("id", id);

                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

//                    SoapObject responseElement = (SoapObject) response.getProperty(0);

                    // get Dethis from respone
                    //boolean result = Boolean.parseBoolean(response.getProperty("boolean").toString());
                    return true;
                }

            };
            async.execute();
            return  async.get();
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }
        return false;

    }
    //Get only id, tieuDe, noiDung, lop and mon
    public static DeThi getAPartExamInfor(String id) {
        try {
            AsyncTask<Void, Void, DeThi> async = new AsyncTask<Void, Void, DeThi>() {
                @Override
                protected DeThi doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_2);

                    //Set parameters of web service method
                    webServiceConnection.setProperty("id", id);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("DeThi", new DeThi().getClass());
                    webServiceConnection.setMapping("lop", new Lop().getClass());
                    webServiceConnection.setMapping("monHoc", new Mon().getClass());
                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    DeThi deThi = new DeThi();
                    deThi.setProperty(0, response.getProperty("id"));
                    deThi.setProperty(1, response.getProperty("tieuDe"));
                    deThi.setProperty(2, response.getProperty("noiDung"));
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
    public static Boolean deleteDeThi(String id) {
        try {
            AsyncTask<Void, Void, Boolean> async = new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_14);

                    webServiceConnection.setProperty("id", id);

                    SoapObject response = webServiceConnection.getResponse();

                    return true;
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
