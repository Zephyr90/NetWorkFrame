package com.zephyr.exercise2016_12_15_network_f;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Volley.sendRequest(null, "", ResponseBean.class, new IJsonListener() {
            @Override
            public void onSuccess(Object o) {
                Log.d("MainActivity", "onSuccess: " + o);
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this, "请求出错", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
