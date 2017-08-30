package com.bwie.aizhonghui.cexutils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by DANGEROUS_HUI on 2017/8/29.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
