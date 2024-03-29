package com.example.teacherapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public class ActivitiesTransfer {
    final static String DETHI_MESSAGECODE = "dethi";
    final static String TRACNGHIEM_MESSAGECODE = "tracnghiem";
    final static String INDEX_MESSAGECODE = "index";
    final static String ACTION = "ACTION_CODE";
    public static void sendMessage(Activity fromActivity, Class toActivityClass, Bundle bundle){
        Intent intent = new Intent(fromActivity, toActivityClass);
        intent.putExtras(bundle);
        fromActivity.startActivity(intent);
    }
    public static String receiveStringMessage(Intent intent, String message_code){
        return intent.getExtras().getString(message_code);
    }
    public static int receiveIntMessage(Intent intent, String message_code){
        return intent.getExtras().getInt(message_code);
    }
    public static double receiveDoubleMessage(Intent intent, String message_code){
        return intent.getExtras().getDouble(message_code);
    }
    public static boolean receiveBooleanMessage(Intent intent, String message_code){
        return intent.getExtras().getBoolean(message_code);
    }
    public static char receiveCharMessage(Intent intent, String message_code){
        return intent.getExtras().getChar(message_code);
    }
    public static float receiveFloatMessage(Intent intent, String message_code){
        return intent.getExtras().getFloat(message_code);
    }
    public static long receiveLongMessage(Intent intent, String message_code){
        return intent.getExtras().getLong(message_code);
    }
    public static byte receiveByteMessage(Intent intent, String message_code){
        return intent.getExtras().getByte(message_code);
    }
    public static Serializable receiveSerializableMessage(Intent intent, String message_code){
        return intent.getExtras().getSerializable(message_code);
    }
}
