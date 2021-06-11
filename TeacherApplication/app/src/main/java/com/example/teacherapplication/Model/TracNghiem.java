package com.example.teacherapplication.Model;

import java.util.*;

/**
 * 
 */
public abstract class TracNghiem {

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


    /**
     * @param cauhoi
     */
    public void setCauhoi(String cauhoi) {
        // TODO implement here
    }

    /**
     * @param cautraloi
     */
    public void addCauTraLoi(CauTraLoi cautraloi) {
        // TODO implement here
    }

}