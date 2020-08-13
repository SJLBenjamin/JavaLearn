package com.example.javalearn.asynchtask;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

public class AsynchTaskLearn {
    public static void asynchTash(final Activity mainActivity){
        AsyncTask asyncTask = new AsyncTask<String,String,String>() {
            @Override
            protected String doInBackground(String[] objects) {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(""+i);
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "结束了";
            }



            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(mainActivity, "开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onProgressUpdate(String[] values) {
                super.onProgressUpdate(values);
                Toast.makeText(mainActivity, values[0].toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onPostExecute(String o) {
                super.onPostExecute(o);
                Toast.makeText(mainActivity, o.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        asyncTask.execute("123");
    }
}
