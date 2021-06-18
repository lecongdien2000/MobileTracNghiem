package com.example.tracnghiemtest;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

public class Lop implements KvmSerializable {
    int lop;
    String label;

    public Lop(){

    }

    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0: return lop;
            case 1: return label;
            default:break;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0: lop = Integer.parseInt(o.toString()); break;
            case 1: label = o.toString(); break;
            default: break;
        }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo info) {
        switch(i)
        {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "lop";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "label";
                break;
            default:break;
        }
    }

    @Override
    public String toString() {
        return "Lop{" +
                "lop=" + lop +
                ", label='" + label + '\'' +
                '}';
    }
}
