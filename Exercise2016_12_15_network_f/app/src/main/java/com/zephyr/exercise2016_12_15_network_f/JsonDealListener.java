package com.zephyr.exercise2016_12_15_network_f;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public class JsonDealListener<M> implements IHttpListener{

    private Class<M> mClass;

    private IJsonListener<M> mJsonListener;

    private Handler handler = new Handler(Looper.getMainLooper());

    public JsonDealListener(Class<M> aClass, IJsonListener<M> jsonListener) {
        mClass = aClass;
        mJsonListener = jsonListener;
    }

//    {
//        "people":[
//        {"firstName":"Brett","lastName":"McLaughlin","email":"aaaa"},
//        {"firstName":"Jason","lastName":"Hunter","email":"bbbb"},
//        {"firstName":"Elliotte","lastName":"Harold","email":"cccc"}
//        ]
//    }
    String str = "\"people\":{\"firstName\":\"Brett\",\"lastName\":\"McLaughlin\",\"email\":\"aaaa\"}";
    @Override
    public void onSuccess(InputStream stream) {
        String content = getContent(stream);
        Gson gson = new Gson();
//        final M response = gson.fromJson(content, mClass);
//        final M response = gson.fromJson(content, mClass);
        final M response = gson.fromJson(str, mClass);
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (mJsonListener != null) {
                    mJsonListener.onSuccess(response);
                }
            }
        });
    }

    /**
     * 解析stream为M
     * @param stream
     * @return
     * TODO 未实现流的读写
     */
    private String getContent(InputStream stream) {
        return "";
    }

    @Override
    public void onError() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (mJsonListener != null) {
                    mJsonListener.onError();
                }
            }
        });
    }

}
