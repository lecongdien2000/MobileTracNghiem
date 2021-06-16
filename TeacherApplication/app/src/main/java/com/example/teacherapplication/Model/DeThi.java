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
    private String id;
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
    public void addTracNghiem(TracNghiem tracnghiem) {
        dsTracNghiem.add(tracnghiem);
    }

    @Override
    public String toString() {
        return "DeThi{" +
                "tieuDe='" + tieuDe + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", dsTracNghiem=" + dsTracNghiem +
                ", lop=" + lop +
                ", monHoc=" + monHoc +
                ", isAccepted=" + isAccepted +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<TracNghiem> getDsTracNghiem() {
        return dsTracNghiem;
    }

    public void setDsTracNghiem(List<TracNghiem> dsTracNghiem) {
        this.dsTracNghiem = dsTracNghiem;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Mon getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(Mon monHoc) {
        this.monHoc = monHoc;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setTracNghiem(int pos, TracNghiem tracNghiem) {
        dsTracNghiem.set(pos, tracNghiem);
    }
}