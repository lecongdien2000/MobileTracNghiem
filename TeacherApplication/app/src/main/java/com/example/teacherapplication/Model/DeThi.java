package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class DeThi implements Serializable {

    /**
     * Default constructor
     */
    public DeThi() {
    }

    public DeThi(String tieuDe, String noiDung, Lop lop, Mon monHoc) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.dsTracNghiem = new ArrayList<TracNghiem>();
        this.lop = lop;
        this.monHoc = monHoc;
        this.isAccepted = false;
    }

    /**
     * 
     */
    private String tieuDe;

    /**
     * 
     */
    private String noiDung;

    /**
     * 
     */
    private List<TracNghiem> dsTracNghiem;

    /**
     * 
     */
    private Lop lop;

    /**
     * 
     */
    private Mon monHoc;

    /**
     * 
     */
    private boolean isAccepted;




    /**
     * @return
     */
    public List<TracNghiem> getDSTracNghiem() {
        return dsTracNghiem;
    }

    /**
     * @param tracnghiem
     */
    public void setTracNghiem(TracNghiem tracnghiem) {
        // TODO implement here
    }

}