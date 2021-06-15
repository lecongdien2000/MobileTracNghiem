package com.example.dangbaiviet.Model;

import java.util.*;

/**
 *
 */
public abstract class TracNghiem {


    public TracNghiem(int stt, String label, String cauHoi, List<String> dsTraLoi, int dapAn) {
        this.stt = stt;
        this.label = label;
        this.cauHoi = cauHoi;
        this.dsTraLoi = dsTraLoi;
        this.dapAn = dapAn;
    }

    /**
     * Default constructor
     */
    public TracNghiem() {
    }

    /**
     *
     */
    public int stt;

    /**
     *
     */
    public String label;

    /**
     *
     */
    public String cauHoi;

    /**
     *
     */
    public List<String> dsTraLoi;

    /**
     *
     */
    public int dapAn;




    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public List<String> getDsTraLoi() {
        return dsTraLoi;
    }

    public void setDsTraLoi(List<String> dsTraLoi) {
        this.dsTraLoi = dsTraLoi;
    }

    public int getDapAn(int i) {
        return dapAn;
    }

    public void setDapAn(int dapAn) {
        this.dapAn = dapAn;
    }
}