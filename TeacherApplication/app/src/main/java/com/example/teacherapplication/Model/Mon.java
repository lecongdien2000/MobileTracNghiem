package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Mon implements Serializable {


    public Mon(){

    }
    /**
     * Default constructor
     */
    /**
     * 
     */
    public String ten;

    /**
     * 
     */
    public List<Lop> lopCoMonHoc;

    public Mon(String ten){
        this.ten = ten;
    }


    @Override
    public String toString() {
        return "Mon{" +
                "ten='" + ten + '\'' +
                ", lopCoMonHoc=" + lopCoMonHoc +
                '}';
    }
}