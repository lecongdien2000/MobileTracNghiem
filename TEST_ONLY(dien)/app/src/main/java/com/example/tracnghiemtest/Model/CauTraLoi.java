package com.example.tracnghiemtest.Model;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.Hashtable;


public class CauTraLoi implements Serializable, KvmSerializable {

    public CauTraLoi() {

    }

    public int stt;

    public String noiDung;

    public boolean isDapAn;

    // H
    public CauTraLoi(int stt, String noiDung, boolean isDapAn){
        this.stt = stt;
        this.noiDung = noiDung;
        this.isDapAn = isDapAn;
    }

    public CauTraLoi(int stt) {
        this.stt = stt;
        this.noiDung = "";
        this.isDapAn = false;
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


    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0: return stt;
            case 1: return noiDung;
            case 2: return isDapAn;
            default:break;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0: stt = Integer.parseInt(o.toString()); break;
            case 1: noiDung = o.toString(); break;
            case 2: isDapAn = Boolean.parseBoolean(o.toString()); break;
            default: break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable properties, PropertyInfo info) {
        switch(i)
        {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "stt";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "noiDung";
                break;
            case 2:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "isDapAn";
                break;
            default:break;
        }
    }
}