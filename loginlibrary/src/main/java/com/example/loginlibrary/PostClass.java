package com.example.loginlibrary;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class PostClass extends AsyncTask<String, Void, String> {

    JSONObject jsonObject2;
    StringBuilder stringBuilder;

    /*public CallAPI(JSONObject jsonObject) {
        //set context variables if required
        this.jsonObject2 = jsonObject;
    }*/

    public PostClass(Map<String,String> map){
        jsonObject2 = new JSONObject(map);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {

        String urlString = params[0];
        URL url = null;

        try {
            url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //conn.connect();

            JSONObject jsonObject1 = new JSONObject();
            //    jsonObject1.put("qq","qqqq");
            //   jsonObject1.put("ww","wwww");

            jsonObject1.put("title",params[1]);
            jsonObject1.put("description",params[2]);

            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            // conn.setRequestProperty("Content-Length", String.valueOf(jsonObject1.length()));
            conn.connect();

            OutputStream outputStream = conn.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(String.valueOf(jsonObject1));
            bufferedWriter.flush();

            Log.d("Response Code", String.valueOf(conn.getResponseCode()));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}