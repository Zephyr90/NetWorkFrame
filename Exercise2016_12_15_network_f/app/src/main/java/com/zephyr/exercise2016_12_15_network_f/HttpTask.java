package com.zephyr.exercise2016_12_15_network_f;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public class HttpTask<T> implements Runnable {

    private String url;
    private IHttpListener listener;
    private IHttpService mService;

    public <T extends Serializable>HttpTask(T requestInfo, String url, IHttpListener listener) {
        mService = new JsonHttpSerivce();
        mService.setUrl(url);
        mService.setHttpListener(listener);
        String request = new Gson().toJson(requestInfo);
        try {
            mService.setRequestData(request.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.url = url;
        this.listener = listener;
    }

    @Override
    public void run() {
         mService.excute();
    }
}
