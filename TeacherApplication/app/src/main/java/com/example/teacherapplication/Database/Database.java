package com.example.teacherapplication.Database;

import android.os.AsyncTask;
import android.util.Log;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.example.teacherapplication.Model.*;

import org.ksoap2.serialization.SoapObject;

/**
 * 
 */
public class Database {
    //Linh
    public static DeThi getFullExamInfor(String id) {
    //TODO
        return null;

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

    /**
     * @return
     */
    public static List<Lop> getDSLop() {
        try {
            AsyncTask<Void, Void, List<Lop>> async = new AsyncTask<Void, Void, List<Lop>>() {
                @Override
                protected List<Lop> doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_3);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("Lop", new Lop().getClass());

                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    List<Lop> lops = new ArrayList<>();
                    for(int i = 0; i < response.getPropertyCount(); i++){
                        SoapObject responseElement = (SoapObject)response.getProperty(i);

                        Lop lop = new Lop();
                        lop.setProperty(0, responseElement.getProperty(0));
                        lop.setProperty(1, responseElement.getProperty(1));

                        lops.add(lop);
                    }
                 return lops;
                }
            };
            async.execute();
            return async.get();
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    //Hong
    public static List<Mon> getDSMon() {
        //TODO
        return null;
    }

    //Hong
    public static void insertDeThi(DeThi dethi) {
        // TODO
    }

    //Hong
    public static ArrayList<DeThi> getDeThi(String subject, int lop) {
        //TODO
        return null;
    }

    //Linh
    public static DeThi getExamInfor() {
        // TODO
        return null;
    }

    //Linh
    public static DeThi getExamInfor(String idDe) {
        // TODO
        return null;
    }

    //Linh
    public static void processExam(boolean isAccepted, String id) {
        // TODO
    }




    //Sample code
    public static Lop getLop(int solop)  {
        try {
            AsyncTask<Void, Void, Lop> async = new AsyncTask<Void, Void, Lop>() {
                @Override
                protected Lop doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_4);

                    //Set parameters of web service method
                    webServiceConnection.setProperty("solop", solop);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("Lop", new Lop().getClass());

                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    Lop lop = new Lop();
                    lop.setProperty(0, response.getProperty(0));
                    lop.setProperty(1, response.getProperty(1));

                    return lop;
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