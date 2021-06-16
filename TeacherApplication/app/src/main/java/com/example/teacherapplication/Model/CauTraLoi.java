package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class CauTraLoi implements Serializable {

    /**
     * Default constructor
     */
    public CauTraLoi() {

    }
    public CauTraLoi(int stt) {
        this.stt = stt;
        this.noiDung = "";
        this.isDapAn = false;
    }
    /**
     * 
     */
    public int stt;

    /**
     * 
     */
    public String noiDung;

    /**
     * 
     */
    public boolean isDapAn;

    public  CauTraLoi(int stt, String noiDung, boolean isDapAn){
        this.stt = stt;
        this.noiDung = noiDung;
        this.isDapAn = isDapAn;
    }


    public void setValue(String traloi, boolean isDapAn) {
        this.isDapAn = isDapAn;
        this.noiDung = traloi;
    }

    @Override
    public String toString() {
        return "CauTraLoi{" +
                "stt=" + stt +
                ", noiDung='" + noiDung + '\'' +
                ", isDapAn=" + isDapAn +
                '}';
    }
}