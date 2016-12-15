package com.zephyr.exercise2016_12_15_network_f;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public interface IHttpListener {

    /**
     * 请求成功
     * @param stream
     */
    void onSuccess(InputStream stream);

    /**
     * 请求失败
     */
    void onError();

}
