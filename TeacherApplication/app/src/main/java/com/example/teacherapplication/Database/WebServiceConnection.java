package com.example.teacherapplication.Database;


import android.app.DownloadManager;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebServiceConnection {
    static String NAMESPACE = "http://tracnghiemwebservice.com/";
    static String URL = "http://192.168.1.7/TracNghiem/TracNghiemSV.asmx?WSDL";
    String METHOD_NAME = null;
    String SOAP_ACTION = null;

    SoapObject request;
    SoapSerializationEnvelope envelope;
    HttpTransportSE androidHttpTransport;
    SoapObject response;

    public WebServiceConnection(String methodNameWS){
        setInfo(methodNameWS);
        initProperty();
        setEnvelope();
    }


    public SoapObject getResponse(){
        return execute();
    }

    public void setProperty(String param, Object value){
        request.addProperty(param, value);
    }
    public void setClassProperty(String name, Object value, Class classOfValue){
        PropertyInfo pi = new PropertyInfo();
        pi.setName(name);
        pi.setValue(value);
        pi.setType(classOfValue);
        request.addProperty(pi);
    }
    public void setMapping(String name, Class theClass){
        envelope.addMapping(NAMESPACE, name, theClass);
    }

    private SoapObject execute() {
        try {
            androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            response = (SoapObject)envelope.getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private void setEnvelope() {
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
    }

    private void setInfo(String methodNameWS) {
        METHOD_NAME = methodNameWS;
        SOAP_ACTION = NAMESPACE + METHOD_NAME;
    }
    private void initProperty(){
        request = new SoapObject(NAMESPACE, METHOD_NAME);
    }


}
