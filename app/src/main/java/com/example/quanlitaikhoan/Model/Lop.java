package com.example.quanlitaikhoan.Model;

public class Lop {

    public Lop(int lop) {
        this.lop = lop;
    }
    public int lop;
    public String label;

    @Override
    public String toString() {
        return "Lớp "+lop ;
    }
}