package com.example.teacherapplication.Model;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.*;

public class Mon implements Serializable, KvmSerializable {


    public Mon(){

    }

    public String ten;

    public Mon(String ten){
        this.ten = ten;
    }


    @Override
    public String toString() {
        return "Mon{" +
                "ten='" + ten + '\'' +
                '}';
    }


    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0: return ten;
            default:break;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 1;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0: ten = o.toString(); break;
            default: break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable properties, PropertyInfo info) {
        switch(i)
        {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "ten";
                break;
            default:break;
        }
    }
}