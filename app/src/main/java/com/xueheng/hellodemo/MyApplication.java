package com.xueheng.hellodemo;

/**
 * Created by Administrator on 2017/12/24.
 */

import android.app.Application;
import android.content.Context;

import org.xutils.x;


/**
 * Used 自定义Application【系统上下文】
 */
public class MyApplication extends Application{

    /**系统上下文*/
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();

        //初始化XUtils
        x.Ext.init(this);
        //设置debug模式
        x.Ext.setDebug(true);
    }

    /**获取系统上下文：用于ToastUtil类*/
    public static Context getAppContext()
    {
        return mAppContext;
    }

}
