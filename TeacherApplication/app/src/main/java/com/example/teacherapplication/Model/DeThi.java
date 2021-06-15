package com.example.teacherapplication.Model;

import java.util.*;

/**
 * 
 */
public class DeThi {
    private String tieuDe;
    private String noiDung;
    private List<TracNghiem> dsTracNghiem;
    private Lop lop = new Lop();
    private Mon monHoc  = new Mon();
    public boolean isAccepted;

    public String getTieuDe() {
        return tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getLop() {
        return "Lớp " + lop.lop;
    }

    public Mon getMonHoc() {
        return monHoc;
    }

    public DeThi() {
    }
    public DeThi(String tieuDe, String noiDung, int lop, String monHoc) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lop.lop = lop;
        this.monHoc.ten = monHoc;
    }

    /**
     * @return
     */
    public List<TracNghiem> getDSTracNghiem() {
        // TODO implement here
        return null;
    }

    /**
     * @param tracnghiem
     */
    public void setTracNghiem(TracNghiem tracnghiem) {
        // TODO implement here
    }

}