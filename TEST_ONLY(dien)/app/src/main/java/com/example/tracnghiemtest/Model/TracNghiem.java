package com.example.tracnghiemtest.Model;

import org.ksoap2.serialization.KvmSerializable;

import java.io.Serializable;

/**
 * 
 */
public abstract class TracNghiem implements Serializable, KvmSerializable {

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

    @Override
    public String toString() {
        return "TracNghiem{" +
                "label='" + label + '\'' +
                ", cauHoi='" + cauHoi + '\'' +
                '}';
    }
}