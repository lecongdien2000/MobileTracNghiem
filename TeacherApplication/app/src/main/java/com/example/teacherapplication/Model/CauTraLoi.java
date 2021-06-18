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
    /**
     * 
     */
    /**
     * 
     */
    public String noiDung;

    /**
     * 
     */
    public boolean isDapAn;

    // H
    public  CauTraLoi( String noiDung, boolean isDapAn){
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
                ", noiDung='" + noiDung + '\'' +
                ", isDapAn=" + isDapAn +
                '}';
    }
}