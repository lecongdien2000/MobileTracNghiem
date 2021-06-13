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


    public void setValue(String traloi, boolean isDapAn) {
        this.isDapAn = isDapAn;
        this.noiDung = traloi;
    }
}