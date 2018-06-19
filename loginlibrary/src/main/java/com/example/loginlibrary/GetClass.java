package com.example.loginlibrary;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetClass extends AsyncTask<String,Void,String> {

    String result;
    String res;

    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myconnection = null;

        try {
            link = new URL(urls[0]);
            myconnection = (HttpURLConnection)link.openConnection();
            myconnection.connect();
            InputStream in = myconnection.getInputStream();
            InputStreamReader myStreamReader = new InputStreamReader(in);
            int data = myStreamReader.read();
            while(data!= -1){
                char current = (char)data;
                result+= current;
                data = myStreamReader.read();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}