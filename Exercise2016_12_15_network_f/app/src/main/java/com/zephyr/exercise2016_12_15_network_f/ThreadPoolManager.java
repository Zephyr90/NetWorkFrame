package com.zephyr.exercise2016_12_15_network_f;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public class ThreadPoolManager {

    private static ThreadPoolManager manager = new ThreadPoolManager();

    private ThreadPoolExecutor mExecutor;

    private LinkedBlockingQueue<Future<?>> service = new LinkedBlockingQueue<>();

    private ThreadPoolManager() {
        mExecutor = new ThreadPoolExecutor(4, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), mHandler);
        mExecutor.execute(mRunnable);
    }

    public static ThreadPoolManager getInstance() {
        return  manager;
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                FutureTask task = null;
                try {
                    task = (FutureTask) service.take(); // 阻塞式函数
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    mExecutor.execute(task);
                }
            }
        }
    };

    public  <T>void execute(Future<T> t) {
        try {
            service.put(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RejectedExecutionHandler mHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                service.put(new FutureTask<Object>(r, null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


}
