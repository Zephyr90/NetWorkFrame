package com.zephyr.exercise2016_12_15_network_f;

import java.io.Serializable;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public class Volley {

    public static <T extends Serializable, M> void sendRequest(
            T request, String url, Class<M> reponse, IJsonListener jsonListener) {
        IHttpListener listener = new JsonDealListener<M>(reponse, jsonListener);
        HttpTask<T> task = new HttpTask<T>(request, url, listener);

        ThreadPoolManager.getInstance().execute(new FutureTask<Object>(task, null));

    }
}
