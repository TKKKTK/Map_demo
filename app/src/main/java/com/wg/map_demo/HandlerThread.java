package com.wg.map_demo;

import android.os.Looper;

public class HandlerThread extends Thread{
    private Looper mLooper;

    @Override
    public void run() {
        Looper.prepare();
        synchronized (this) {
            mLooper = Looper.myLooper();
            notifyAll();
        }
        Looper.loop();
    }

    public Looper getLooper() throws Exception {
        if (!isAlive()) {
            throw new Exception("current thread is not alive");
        }
        synchronized (this){
            if (null == mLooper){
                wait();
            }
        }
        return mLooper;
    }
}
