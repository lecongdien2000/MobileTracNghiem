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
        // TODO implement here
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