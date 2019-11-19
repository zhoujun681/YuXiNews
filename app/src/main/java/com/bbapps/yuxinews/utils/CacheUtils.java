package com.bbapps.yuxinews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bbapps.yuxinews.SplashActivity;
import com.bbapps.yuxinews.activity.GuideActivity;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.utils
 * @ClassName: CacheUtils
 * @Author: Bb
 * @CreateDate: 2019/9/19 14:39
 * @Version: 1.0
 * @Description: 缓存工具类
 */
public class CacheUtils {
    /**
     * 得到布尔类型缓存值
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("YuXiNews",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }

    /**
     * 保存布尔类型值
     * @param context
     * @param key
     * @param vaule
     */
    public static void putBoolean(Context context, String key, boolean vaule) {
        SharedPreferences sp = context.getSharedPreferences("YuXiNews",Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,vaule).commit();
    }

    /**
     * 保存文本数据
     * @param context
     * @param key
     * @param vaule
     */
    public static void putString(Context context, String key, String vaule) {
        SharedPreferences sp = context.getSharedPreferences("YuXiNews",Context.MODE_PRIVATE);
        sp.edit().putString(key,vaule).commit();
    }

    /**
     * 获取缓存文本数据
     * @param context
     * @param key
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("YuXiNews",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
