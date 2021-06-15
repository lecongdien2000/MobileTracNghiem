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
    public  Database() {
    }

    /**
     * @return
     */
    public static List<Lop> getDSLop() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static List<Mon> getDSMon() {
        // TODO implement here
        return null;
    }

    /**
     * @param dethi
     */
    public static void insertDeThi(DeThi dethi) {
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

}