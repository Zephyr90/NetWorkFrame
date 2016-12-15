package com.zephyr.exercise2016_12_15_network_f;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public interface IHttpService {

    /**
     * 设置请求URL
     * @param url
     */
    void setUrl(String url);

    /**
     * 设置请求体
     * @param data
     */
    void setRequestData(byte[] data);

    /**
     * 执行网络请求
     */
    void excute();

    /**
     * 设置请求回调
     * @param listener
     */
    void setHttpListener(IHttpListener listener);


}
