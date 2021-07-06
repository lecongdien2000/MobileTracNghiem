package com.example.tracnghiemtest;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DeThi implements Serializable, KvmSerializable {
    public String id;
    public String tieuDe;
    public String noiDung;
    public List<TracNghiem> dsTracNghiem;
    public Lop lop = new Lop();
    public Mon monHoc  = new Mon();
    public boolean isAccepted;


    public DeThi(String tieuDe, String noiDung, Lop lop, Mon monHoc) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.dsTracNghiem = new ArrayList<TracNghiem>();
        this.lop = lop;
        this.monHoc = monHoc;
        this.isAccepted = false;
    }


    public String getLop() {
        return "Lớp " + lop.lop;
    }


    public DeThi() {
    }
    public DeThi(String tieuDe, String noiDung, int lop, String monHoc) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lop.lop = lop;
        this.monHoc.ten = monHoc;
    }

    public List<TracNghiem> getDSTracNghiem() {
        // TODO implement here
        return this.dsTracNghiem;
    }

    public void addTracNghiem(TracNghiem tracnghiem) {
        dsTracNghiem.add(tracnghiem);
    }

    @Override
    public String toString() {
        return "DeThi{" +
                "tieuDe='" + tieuDe + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", dsTracNghiem=" + dsTracNghiem +
                ", lop=" + lop +
                ", monHoc=" + monHoc +
                ", isAccepted=" + isAccepted +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<TracNghiem> getDsTracNghiem() {
        return dsTracNghiem;
    }

    public void setDsTracNghiem(List<TracNghiem> dsTracNghiem) {
        this.dsTracNghiem = dsTracNghiem;
    }


    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Mon getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(Mon monHoc) {
        this.monHoc = monHoc;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setTracNghiem(int pos, TracNghiem tracNghiem) {
        dsTracNghiem.set(pos, tracNghiem);
    }
    public DeThi(List<TracNghiem> dsTracNghiem, String tieuDe){
        this.dsTracNghiem = dsTracNghiem;
         this.tieuDe = tieuDe;
    }

    public DeThi(String id, String tieuDe, String noiDung, Lop lop, Mon mon){
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lop = lop;
        this.monHoc = mon;
        this.id = id;
    }

    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0: return id;
            case 1: return tieuDe;
            case 2: return noiDung;
            case 3: return dsTracNghiem;
            case 4: return lop;
            case 5: return monHoc;
            case 6: return isAccepted;
            default:break;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void setProperty(int i, Object o) {
        SoapObject responseElement = null;
        switch (i){
            case 0: id = o.toString(); break;
            case 1: tieuDe = o.toString(); break;
            case 2: noiDung = o.toString(); break;
            case 3: dsTracNghiem = (List<TracNghiem>)o; break;
            case 4:
                responseElement = (SoapObject)o;
                Lop lop = new Lop();
                lop.setProperty(0, responseElement.getProperty("lop"));
                lop.setProperty(1, responseElement.getProperty("label"));
                this.lop = lop;
                break;
            case 5:
                responseElement = (SoapObject)o;
                Mon mon = new Mon();
                mon.setProperty(0, responseElement.getProperty("ten"));
                this.monHoc = mon;
                break;
            case 6: isAccepted = Boolean.parseBoolean(o.toString()); break;
            default: break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable properties, PropertyInfo info) {
        switch(i)
        {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "tieuDe";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "noiDung";
                break;
            case 3:
                info.type = PropertyInfo.OBJECT_CLASS;
                info.name = "dsTracNghiem";
                break;
            case 4:
                info.type = PropertyInfo.OBJECT_CLASS;
                info.name = "lop";
                break;
            case 5:
                info.type = PropertyInfo.OBJECT_CLASS;
                info.name = "monHoc";
                break;
            case 6:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "isAccepted";
                break;
            default:break;
        }
    }
}