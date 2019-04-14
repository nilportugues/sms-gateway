package com.corneliouzbett.smsgateway.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {

    public static Boolean checkConnectivity(){
        boolean connected = false;
        try{
            int timeOutInMilliSec=5000;
            URL url = new URL("http://www.google.com/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(timeOutInMilliSec);
            conn.setReadTimeout(timeOutInMilliSec);
            int responseCode = conn.getResponseCode();
            if(200 <= responseCode && responseCode <= 399){
                connected = true;
                System.out.println("Internet is Available");
            }
        }
        catch(Exception ex){
            connected = false;
            System.out.println("No Internet Connectivity");
        }
     return connected;
    }
}
