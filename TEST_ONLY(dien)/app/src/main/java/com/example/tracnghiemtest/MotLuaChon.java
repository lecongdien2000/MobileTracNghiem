package com.example.tracnghiemtest;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 
 */
public class MotLuaChon extends TracNghiem {
    public List<CauTraLoi> dsTraLoi;

    public MotLuaChon(String label) {
        super(label, "");
        dsTraLoi = new ArrayList<CauTraLoi>();
    }

    public MotLuaChon(String label, String cauhoi) {
        super(label, cauhoi);
        dsTraLoi = new ArrayList<CauTraLoi>();
    }

    public MotLuaChon() {

    }

    @Override
    public void createBlankCauTraLois(int qty) {
        for(int stt = 1; stt <= qty; stt++)
            dsTraLoi.add(new CauTraLoi(dsTraLoi.size() + stt));
    }

    @Override
    public void setCauTraLoi(int i, String traloi, boolean isTrue) {
        dsTraLoi.get(i).setValue(traloi, isTrue);
    }

    /**
     * 
     */


    public MotLuaChon(List<CauTraLoi> cauTraLois, String cauhoi) {
        this.dsTraLoi = cauTraLois;
        this.cauHoi = cauhoi;
    }


    public List<CauTraLoi> getDsTraLoi() {
        return dsTraLoi;
    }

    @Override
    public String toString() {
        return super.toString() + "MotLuaChon{" +
                "dsTraLoi=" + dsTraLoi +
                '}';
    }


    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0: return label;
            case 1: return cauHoi;
            case 2: return dsTraLoi;
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
        SoapObject responseElement = null;
        switch (i){
            case 0: label = o.toString(); break;
            case 1: cauHoi = o.toString(); break;
            case 2:
                List<CauTraLoi> cauTraLois = new ArrayList<>();
                responseElement = (SoapObject)o;
                for(int k = 0; k < ((SoapObject) o).getPropertyCount(); k++){
                    SoapObject rEE = (SoapObject) (responseElement.getProperty(k));
                    CauTraLoi cauTraLoi = new CauTraLoi();
                    cauTraLoi.setProperty(0, rEE.getProperty(0));
                    cauTraLoi.setProperty(1, rEE.getProperty(1));
                    cauTraLoi.setProperty(2, rEE.getProperty(2));
                    cauTraLois.add(cauTraLoi);
                }
                this.dsTraLoi = cauTraLois;
                break;
                default: break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable properties, PropertyInfo info) {
        switch(i)
        {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "label";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "cauHoi";
                break;
            case 2:
                info.type = PropertyInfo.OBJECT_CLASS;
                info.name = "dsTraLoi";
                break;
            default:break;
        }
    }
}