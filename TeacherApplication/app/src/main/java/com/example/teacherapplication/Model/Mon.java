package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Mon implements Serializable {

    /**
     * Default constructor
     */
    public Mon(String ten) {
        this.ten = ten;
    }

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