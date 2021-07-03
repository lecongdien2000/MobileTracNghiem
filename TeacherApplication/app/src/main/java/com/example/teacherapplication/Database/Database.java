package com.example.teacherapplication.Database;

import android.os.AsyncTask;

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
        try {
            AsyncTask<Void, Void, List<Mon>> async = new AsyncTask<Void, Void, List<Mon>>() {
                @Override
                protected List<Mon> doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_5);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("Mon", new Mon().getClass());

                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    List<Mon> mons = new ArrayList<>();
                    for(int i = 0; i < response.getPropertyCount(); i++){
                        SoapObject responseElement = (SoapObject)response.getProperty(i);

                        Mon mon = new Mon();
                        mon.setProperty(0, responseElement.getProperty(0));
                        mons.add(mon);
                    }
                    return mons;
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
    public static void insertDeThi(DeThi dethi) {
        // TODO
        try {
            AsyncTask<Void, Void, Void> async = new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_6);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("DeThi", new DeThi().getClass());

                    //Set parameters of web service method
                    webServiceConnection.setClassProperty("dethi", dethi, new DeThi().getClass());
                    webServiceConnection.getResponse();
                    return  null;
                }
            };
            async.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hong
    public static ArrayList<DeThi> getDeThi(String subject, int lop) {
        //TODO
        try {
            AsyncTask<Void, Void, List<DeThi>> async = new AsyncTask<Void, Void, List<DeThi>>() {
                @Override
                protected List<DeThi> doInBackground(Void... values) {
                    //Create web service connection and pass a method in MethodNamesTable
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_5);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("DeThi", new DeThi().getClass());
                    webServiceConnection.setMapping("MotLuaChon", new MotLuaChon().getClass());
                    webServiceConnection.setMapping("Lop", new Lop().getClass());
                    webServiceConnection.setMapping("Mon", new Mon().getClass());


                    //Start connect and get response
                    SoapObject response = webServiceConnection.getResponse();

                    List<DeThi> dethis = new ArrayList<>();
                    for(int i = 0; i < response.getPropertyCount(); i++){
                        SoapObject responseElement = (SoapObject)response.getProperty(i);

                        DeThi dethi = new DeThi();
                        dethi.setProperty(0, responseElement.getProperty(0));
                        dethi.setProperty(1, responseElement.getProperty(1));
                        dethi.setProperty(2, responseElement.getProperty(2));

                        //create ds trac nghiem
                        List<TracNghiem> dsTracNghiem = new ArrayList<>();
                        SoapObject responeDSTracNghiem = (SoapObject) response.getProperty(3);
                        for (int j =0; j< responeDSTracNghiem.getPropertyCount(); j++ ){
                            SoapObject responeTracNghiem = (SoapObject) response.getProperty(j);
                           TracNghiem tn = new MotLuaChon();
                           tn.setProperty(0, responeTracNghiem.getProperty(0));
                           tn.setProperty(1, responeTracNghiem.getProperty(1));
                           dsTracNghiem.add(tn);
                        }
                        dethi.dsTracNghiem = dsTracNghiem;

//                        get lop and mon from respone
                        Lop lop = new Lop();
                        Mon mon = new Mon();
                        SoapObject responeLop = (SoapObject) responseElement.getProperty(4);
                        SoapObject responeMon= (SoapObject) responseElement.getProperty(5);
                        lop.setProperty(0, responeLop.getProperty(0));
                        lop.setProperty(1, responeLop.getProperty(1));
                        mon.setProperty(0, responeMon.getProperty(0));

//            Add de thi vao danh sach
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