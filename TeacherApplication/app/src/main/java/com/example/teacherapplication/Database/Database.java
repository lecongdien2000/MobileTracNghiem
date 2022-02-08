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
                    //INSERT DETHI INFOR
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_6);

                    //Set parameters of web service method
                    webServiceConnection.setProperty("name", dethi.tieuDe );
                    webServiceConnection.setProperty("subjectName", dethi.monHoc.ten );
                    webServiceConnection.setProperty("lop", dethi.lop.lop);
                    webServiceConnection.setProperty("isAccept", dethi.isAccepted);
                    webServiceConnection.setProperty("mota", dethi.noiDung );


                    SoapObject respone = webServiceConnection.getResponse();
                        // INSERT CAUHOI OF DETHI
                        for (int i = 0; i < dethi.dsTracNghiem.size(); i++) {
                            MotLuaChon mlc = (MotLuaChon) dethi.dsTracNghiem.get(i);
                            webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_10);

                            //set parameter
                            webServiceConnection.setProperty("stt", (i+1)+"");
                            webServiceConnection.setProperty("noiDung", mlc.cauHoi);

                            respone = webServiceConnection.getResponse();
                                // INSERT DAPAN OF CAU HOI
                                for (int j = 0; j < mlc.dsTraLoi.size(); j++) {
                                    CauTraLoi ctl = mlc.dsTraLoi.get(j);
                                    WebServiceConnection insertDapAnWS = new WebServiceConnection(MethodNamesTable.METHOD_11);
                                    insertDapAnWS.setProperty("stt", ctl.stt + "");
                                    insertDapAnWS.setProperty("sttCauHoi", (i + 1) + "");
                                    insertDapAnWS.setProperty("noiDung", ctl.noiDung);
                                    insertDapAnWS.setProperty("isTrue", ctl.isDapAn);

                                    insertDapAnWS.getResponse();
                                }
                        }
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
                    WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_7);

                    webServiceConnection.setProperty("subject", subject);
                    webServiceConnection.setProperty("lop", lop);

                    //Determine mapping namespace (tag) and name in Java class
                    webServiceConnection.setMapping("DeThi", new DeThi().getClass());
                    webServiceConnection.setMapping("MotLuaChon", new MotLuaChon().getClass());
                    webServiceConnection.setMapping("Lop", new Lop().getClass());
                    webServiceConnection.setMapping("Mon", new Mon().getClass());


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
                        dethi.setProperty(5, responseElement.getProperty(4));
                        dethi.setProperty(6, responseElement.getProperty(5));

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