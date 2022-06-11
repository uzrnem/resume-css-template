package com.example.generic;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.function.Consumer;

public class HttpClientAsycTask {
    String url;
    Map<String, String> headers;
    String method;
    HttpClientAsycTaskHandler task = null;
    Consumer<String> result;

    public HttpClientAsycTask(String url, Map<String, String> headers, String method, Consumer<String> result) {
        this.url = url;
        this.headers = headers;
        this.method = method;
        this.result = result;
    }

    public void execute(Map<String, String> params) {

        if (task != null) {
            task.cancel(true);
        }
        task = new HttpClientAsycTaskHandler();
        task.setupData(url, headers, method, params, result);
        task.execute();
    }

    public void cancelOldTask() {
        if (task != null) {
            task.cancel(true);
        }
    }

    class HttpClientAsycTaskHandler extends AsyncTask<String, Integer, String> {
        HttpURLConnection httpConn = null;
        InputStreamReader isReader = null;
        BufferedReader bufReader = null;
        String url;
        Map<String, String> headers;
        String method;
        Map<String, String> params;
        Consumer<String> resultMethod;

        public void setupData(String url, Map<String, String> headers, String method, Map<String, String> params, Consumer<String> result) {
            this.url = url;
            this.headers = headers;
            this.method = method;
            this.params = params;
            this.resultMethod = result;
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer readTextBuf = new StringBuffer();


            for (Map.Entry<String, String> paramEntry : params.entrySet()) {
                url = url.replace(paramEntry.getKey(), paramEntry.getValue());
                for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                    headers.put(headerEntry.getKey(), headerEntry.getValue().replace(paramEntry.getKey(), paramEntry.getValue()));
                }
            }
            try {
                httpConn = (HttpURLConnection) new URL( url ).openConnection();
                httpConn.setRequestMethod(method);
                httpConn.setConnectTimeout(10000);
                httpConn.setReadTimeout(10000);
                for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                    httpConn.setRequestProperty(headerEntry.getKey(), headerEntry.getValue());
                }
                InputStream inputStream = httpConn.getInputStream();
                isReader = new InputStreamReader(inputStream);
                bufReader = new BufferedReader(isReader);
                String line = bufReader.readLine();
                while (line != null) {
                    readTextBuf.append(line);
                    line = bufReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readTextBuf.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            this.resultMethod.accept(result);
        }
    }
}