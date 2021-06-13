package com.example.teacherapplication.Model;

import java.util.*;

/**
 * 
 */
public class MotLuaChon extends TracNghiem {

    /**
     * Default constructor
     */
    public MotLuaChon(String label) {
        super(label, "");
        dsTraLoi = new ArrayList<CauTraLoi>();
    }

    public MotLuaChon(String label, String cauhoi) {
        super(label, cauhoi);
        dsTraLoi = new ArrayList<CauTraLoi>();
    }

    @Override
    public void createBlankCauTraLois(int qty) {
        for(int stt = 1; stt <= qty; stt++)
            dsTraLoi.add(new CauTraLoi(dsTraLoi.size() + stt));
    }

    @Override
    public void setCauTraLoi(int i, String traloi, boolean isTrue) {
        dsTraLoi.get(i).setValue(traloi, isTrue);
    }

    /**
     * 
     */
    private List<CauTraLoi> dsTraLoi;


    public List<CauTraLoi> getDsTraLoi() {
        return dsTraLoi;
    }

    @Override
    public String toString() {
        return super.toString() + "MotLuaChon{" +
                "dsTraLoi=" + dsTraLoi +
                '}';
    }
}