package com.example.demo_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

    Activity contextParent;

    // Constructor
    public MyAsyncTask(Activity contextParent) {
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Thông báo
        Toast.makeText(contextParent, "Bắt đầu tải xuống", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(50); // Giả lập thời gian tải
            publishProgress(i); // Cập nhật tiến trình
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        // Cập nhật giao diện tại đây
        // Bạn không thể sử dụng Toast trong phương thức này
        ProgressBar progressBar = contextParent.findViewById(R.id.prbDemo);
        progressBar.setProgress(values[0]);
        TextView textView = contextParent.findViewById(R.id.txtStatus);
        textView.setText(values[0] + "%");
    }

    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
        // Thông báo khi tiến trình kết thúc
        Toast.makeText(contextParent, "Đã hoàn thành, Finished", Toast.LENGTH_SHORT).show();
    }
}
