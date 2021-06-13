package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public abstract class TracNghiem implements Serializable {

    /**
     * Default constructor
     */
    public TracNghiem() {
    }

    public TracNghiem(String label, String cauHoi) {
        this.label = label;
        this.cauHoi = cauHoi;
    }


    public String label;

    /**
     * 
     */
    public String cauHoi;


    public void setCauhoi(String cauhoi) {
        this.cauHoi = cauhoi;
    }

    /**
     * @param cautraloi
     */
    public void addCauTraLoi(CauTraLoi cautraloi) {
        // TODO implement here
    }

    public abstract void createBlankCauTraLois(int qty);


    public abstract void setCauTraLoi(int i, String traloi, boolean isTrue);
}