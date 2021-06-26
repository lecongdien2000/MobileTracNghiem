package com.example.tracnghiemtest;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.concurrent.ExecutionException;

public class Database {

    public static Lop getLop(int solop){
        String NAMESPACE = "http://tracnghiemwebservice.com/";
        String METHOD_NAME = "getLop";
        String SOAP_ACTION = NAMESPACE + METHOD_NAME;
        String URL = "http://192.168.1.7/TracNghiem/TracNghiemSV.asmx?WSDL";

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        Lop lop = new Lop();
        request.addProperty("solop", solop);


        /*
         * Set the web service envelope
         *
         * */
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);

        envelope.addMapping(NAMESPACE, "lop",new Lop().getClass());

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        /*
         * Call the web service and retrieve result ... how luvly <3
         *
         * */
        try
        {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject)envelope.getResponse();
            lop.lop =  Integer.parseInt(response.getProperty(0).toString());
            lop.label =  response.getProperty(1).toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lop;
    }

    public static Lop getLop2(int solop) throws ExecutionException, InterruptedException {
        AsyncTask<Void, Void, Lop> async = new AsyncTask<Void, Void, Lop>() {
            @Override
            protected Lop doInBackground(Void... values) {
                WebServiceConnection webServiceConnection = new WebServiceConnection(MethodNamesTable.METHOD_4);
                webServiceConnection.setProperty("solop", solop);

                webServiceConnection.setMapping("Lop", new Lop().getClass());
                SoapObject response = webServiceConnection.getResponse();

                Lop lop = new Lop();
                lop.lop =  Integer.parseInt(response.getProperty(0).toString());
                lop.label =  response.getProperty(1).toString();

                return lop;
            }
        };
        async.execute();
        return async.get();
    }
}
