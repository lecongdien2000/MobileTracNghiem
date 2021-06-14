package com.example.teacherapplication.Model;

import java.util.*;

/**
 * 
 */
public class MotLuaChon extends TracNghiem {

    /**
     * Default constructor
     */
    public MotLuaChon() {
    }

    /**
     * 
     */
    public List<CauTraLoi> dsTraLoi;

    /**
     * 
     */
    public int dapAn;

    public MotLuaChon(List<CauTraLoi> cauTraLois, int dapAn, String cauhoi, int stt) {
        this.dapAn = dapAn;
        this.dsTraLoi = cauTraLois;
        this.cauHoi = cauhoi;
        this.stt = stt;
    }

}