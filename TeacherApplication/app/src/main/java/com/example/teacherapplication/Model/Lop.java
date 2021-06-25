package com.example.teacherapplication.Model;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Lop implements Serializable, KvmSerializable {

    /**
     * Default constructor
     */
   
    public Lop() {
    }

    public int lop;

    public String label;

    public Lop(int lop, String label){
        this.lop = lop;
        this.label = label;
    }

    @Override
    public String toString() {
        return "Lop{" +
                "lop=" + lop +
                ", label='" + label + '\'' +
                '}';
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
    public void getPropertyInfo(int i, Hashtable properties, PropertyInfo info) {
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
}