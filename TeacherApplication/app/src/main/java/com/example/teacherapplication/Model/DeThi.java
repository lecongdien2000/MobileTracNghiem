package com.example.teacherapplication.Model;

import java.util.*;

/**
 * 
 */
public class DeThi {

    /**
     * Default constructor
     */
    public DeThi() {
    }

    /**
     * 
     */
    public String tieuDe;

    /**
     * 
     */
    public String noiDung;

    /**
     * 
     */
    public List<TracNghiem> dsTracNghiem;

    /**
     * 
     */
    public Lop lop;

    /**
     * 
     */
    public Mon monHoc;

    /**
     * 
     */
    public boolean isAccepted;




    /**
     * @return
     */
    public List<TracNghiem> getDSTracNghiem() {
        // TODO implement here
        return this.dsTracNghiem;
    }

    /**
     * @param tracnghiem
     */
    public void setTracNghiem(TracNghiem tracnghiem) {
        // TODO implement here
    }
    public String getId(){
        return "1";
    }

    public DeThi(List<TracNghiem> dsTracNghiem, String tieuDe){
        this.dsTracNghiem = dsTracNghiem;
         this.tieuDe = tieuDe;
    }

    public DeThi(String tieuDe, String noiDung, Lop lop, Mon mon){
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lop = lop;
        this.monHoc = mon;
    }
}