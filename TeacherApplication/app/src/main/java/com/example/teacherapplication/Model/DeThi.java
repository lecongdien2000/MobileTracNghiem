package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class DeThi implements Serializable {
    private String tieuDe;
    private String noiDung;
    private List<TracNghiem> dsTracNghiem;
    private Lop lop = new Lop();
    private Mon monHoc  = new Mon();
    public boolean isAccepted;

    public String getTieuDe() {
        return tieuDe;
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

    public Mon monHoc;
    public String id;
    /**
     * 
     */
    private boolean isAccepted;
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
        return this.dsTracNghiem;
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

    public DeThi(List<TracNghiem> dsTracNghiem, String tieuDe){
        this.dsTracNghiem = dsTracNghiem;
         this.tieuDe = tieuDe;
    }

    public DeThi(String id, String tieuDe, String noiDung, Lop lop, Mon mon){
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lop = lop;
        this.monHoc = mon;
        this.id = id;
    }
}