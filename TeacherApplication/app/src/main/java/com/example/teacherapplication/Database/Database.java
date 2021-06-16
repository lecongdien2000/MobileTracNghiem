package com.example.teacherapplication.Database;

import android.util.Log;

import java.util.*;
import com.example.teacherapplication.Model.*;

/**
 * 
 */
public class Database {

    public  static List<DeThi>    deThiExample(){
        List<DeThi> dethi = new ArrayList<>();
        dethi.add(new DeThi("001", "On tap kiem tra", "De thi on tap kiem tra cuoi ki moi nhat",
                new Lop(10, "10"), new Mon("toan")));
        dethi.add(new DeThi("002", "On tap kiem tra", "De thi on tap kiem tra cuoi ki moi nhat",
                new Lop(11, "11"), new Mon("toan")));
        dethi.add(new DeThi("003", "On tap kiem tra", "De thi on tap kiem tra cuoi ki moi nhat",
                new Lop(12, "12"), new Mon("toan")));

        List<CauTraLoi> dsCauTraLoi = new ArrayList<>();
        for(int i =1; i<5; i++){
            if (i!=1)
                dsCauTraLoi.add(new CauTraLoi(i, ("" + i), false));
            else
                dsCauTraLoi.add(new CauTraLoi(i, ("" + i), true));
        }
        List<TracNghiem> dsCauHoi= new ArrayList<>();
        for(int i =1; i<11; i++) {
            dsCauHoi.add( new MotLuaChon(dsCauTraLoi, 0, "Chon dap an dung cho 9-8:", i));
        }
        dethi.get(0).dsTracNghiem = dsCauHoi;
        dethi.get(1).dsTracNghiem = dsCauHoi;
        dethi.get(2).dsTracNghiem = dsCauHoi;

        return  dethi;
    }

    /**
     * Default constructor
     */
    public Database() {
    }

    public static DeThi getFullExamInfor(String id) {
        List<DeThi> listDe = deThiExample();
        for (int i =0; i<listDe.size(); i++){
            if(listDe.get(i).id.equals(id))
                return listDe.get(i);
        }
        return null;
    }

    public static DeThi getAPartExamInfor(String id) {
       List<DeThi> listDe = deThiExample();
       for (int i =0; i<listDe.size(); i++){
           if(listDe.get(i).id.equals(id))
               return listDe.get(i);
       }
        return null;
    }

    /**
     * @return
     */
    public static List<Lop> getDSLop() {
        List<Lop> dslop = new ArrayList<Lop>();
        dslop.add(new Lop(1, "Lớp 1"));
        dslop.add(new Lop(2, "Lớp 2"));
        dslop.add(new Lop(3, "Lớp 3"));
        dslop.add(new Lop(4, "Lớp 4"));
        dslop.add(new Lop(5, "Lớp 5"));
        dslop.add(new Lop(6, "Lớp 6"));
        dslop.add(new Lop(7, "Lớp 7"));
        dslop.add(new Lop(8, "Lớp 8"));
        dslop.add(new Lop(9, "Lớp 9"));
        dslop.add(new Lop(10, "Lớp 10"));
        dslop.add(new Lop(11, "Lớp 11"));
        dslop.add(new Lop(12, "Lớp 12"));
        return dslop;
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
    }

    /**
     * @param subject 
     * @param lop 
     * @return
     */
    public static ArrayList<DeThi> getDeThi(String subject, int lop) {
        // TODO implement here
        return null;
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


}