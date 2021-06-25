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

    public static DeThi getFullExamInfor(String id) {

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
                    webServiceConnection.setMapping("Lop", new Lop().getClass());
                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    Lop lop = new Lop();
                    lop.setProperty(0, response.getProperty(0));
                    lop.setProperty(1, response.getProperty(1));

                    return null;
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

    /**
     * @return
     */
    public static List<Mon> getDSMon() {
        List<Mon> dsmon = new ArrayList<>();
        dsmon.add(new Mon("Toán"));
        dsmon.add(new Mon("Lý"));
        dsmon.add(new Mon("Hóa"));
        dsmon.add(new Mon("Sinh"));
        dsmon.add(new Mon("Sử"));
        dsmon.add(new Mon("Địa"));
        return dsmon;
    }

    /**
     * @param dethi
     */
    public static void insertDeThi(DeThi dethi) {
        Log.d("dethi", dethi.toString());
        // TODO implement here
    }

    /**
     * @param subject 
     * @param lop 
     * @return
     */
    public static ArrayList<DeThi> getDeThi(String subject, int lop) {
        ArrayList<DeThi> arrayList = new ArrayList<DeThi>();
        arrayList.add(new DeThi("Đề thi môn " + subject,"Đề mới nhất hiện nay",lop,subject));
        arrayList.add(new DeThi("Đề thi môn " + subject,"Đề thi giữa kì năm 2018",lop,subject));
        arrayList.add(new DeThi("Đề thi môn " + subject,"Đề thi giữa kì năm 2019",lop,subject));
        arrayList.add(new DeThi("Đề thi môn " + subject,"Đề thi cuối kì năm 2018",lop,subject));
        return arrayList;
    }

    /**
     * @return
     */
    public static DeThi getExamInfor() {
        // TODO implement here
        return null;
    }

    /**
     * @param idDe 
     * @return
     */
    public static DeThi getExamInfor(String idDe) {
        // TODO implement here
        return null;
    }

    /**
     * @param isAccepted 
     * @param id
     */
    public static void processExam(boolean isAccepted, String id) {
        // TODO implement here
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