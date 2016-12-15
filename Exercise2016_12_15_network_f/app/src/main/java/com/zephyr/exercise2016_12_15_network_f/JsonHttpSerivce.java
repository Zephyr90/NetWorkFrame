package com.zephyr.exercise2016_12_15_network_f;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public class JsonHttpSerivce implements IHttpService {
    private String url;
    private byte[] requestData; // 高扩展
    private IHttpListener httpListener;
    private URLConnection connection;
//    private HttpClient mClient = new DefaultHttpClient();
//    private HttpRequestBase mHttpRequestBase;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setRequestData(byte[] data) {
        this.requestData = data;
    }

    @Override
    public void excute() {
        try {
            httpListener.onSuccess(new FileInputStream(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            httpListener.onError();
        }
//        mHttpRequestBase = new HttpPost();
//        ByteArrayEntity entity = new ByteArrayEntity(requestData);
//        ((HttpPost) mHttpRequestBase).setEntity(entity);
//        try {
//            mClient.execute(mHttpRequestBase);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void setHttpListener(IHttpListener listener) {
        this.httpListener = listener;
    }
}
