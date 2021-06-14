package com.example.teacherapplication.Database;

import java.util.*;
import com.example.teacherapplication.Model.*;

/**
 * 
 */
public class Database {

    /**
     * Default constructor
     */
    public Database() {
    }

    public static DeThi getFullExamInfor(String id) {
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
        DeThi deThi = new DeThi(dsCauHoi, "On thi cuoi ki");
        return deThi;
    }

    public static DeThi getAPartExamInfor(int id) {
        DeThi dt = new DeThi("On tap kiem tra", "De thi on tap kiem tra cuoi ki moi nhat",
                new Lop(10, "10"), new Mon("toan"));
        return dt;
    }

    /**
     * @return
     */
    public List<Lop> getDSLop() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Mon> getDSMon() {
        // TODO implement here
        return null;
    }

    /**
     * @param dethi
     */
    public void insertDeThi(DeThi dethi) {
        // TODO implement here
    }

    /**
     * @param subject 
     * @param lop 
     * @return
     */
    public ArrayList<DeThi> getDeThi(String subject, int lop) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public DeThi getExamInfor() {
        // TODO implement here
        return null;
    }

    /**
     * @param idDe 
     * @return
     */
    public DeThi getExamInfor(String idDe) {
        // TODO implement here
        return null;
    }

    /**
     * @param isAccepted 
     * @param id
     */
    public void processExam(boolean isAccepted, String id) {
        // TODO implement here
    }

}