package com.example.teacherapplication.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Lop implements Serializable {

    /**
     * Default constructor
     */
    public Lop(int lop, String label) {
        this.lop = lop;
        this.label = label;
    }

    /**
     * 
     */
    public int lop;

    /**
     * 
     */
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
}