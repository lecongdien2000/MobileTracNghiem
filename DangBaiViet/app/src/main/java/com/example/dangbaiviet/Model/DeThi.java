package com.example.dangbaiviet.Model;

import java.util.*;

public class DeThi {
    public DeThi(String id, String tieuDe, String noiDung, Lop lop){
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lop = lop;
    }
    public  String id;

    public String tieuDe;

    public String noiDung;

    public List<TracNghiem> dsTracNghiem;

    public Lop lop;

    public Mon monHoc;

    public boolean isAccepted = false;

    public DeThi(boolean isAccepted) {

    }

    public List<TracNghiem> getDSTracNghiem() {
        // TODO implement here
        return null;
    }

    public void setTracNghiem(TracNghiem tracnghiem) {
        // TODO implement here
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

    @Override
    public String toString() {
        return tieuDe;
    }
}