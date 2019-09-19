package com.bbapps.yuxinews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bbapps.yuxinews.SplashActivity;

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
}
