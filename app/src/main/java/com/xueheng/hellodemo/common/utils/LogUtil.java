package com.xueheng.hellodemo.common.utils;


import com.orhanobut.logger.Logger;

/**
 *
 * 对Logger二次封装
 * Created by xueheng on 2017/12/24.
 */

public class LogUtil {


    public static void d(Object  object){
       Logger.d(object);
    }

    public static void  i(String message,Object object){
        Logger.i(message,object);
    }

    public static void json(String json){
        Logger.json(json);
    }

}
