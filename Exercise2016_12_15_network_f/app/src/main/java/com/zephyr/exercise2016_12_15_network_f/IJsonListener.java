package com.zephyr.exercise2016_12_15_network_f;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public interface IJsonListener<M> {

    /**
     * 请求成功
     * @param m
     */
    void onSuccess(M m);

    /**
     * 请求失败
     */
    void onError();
}
