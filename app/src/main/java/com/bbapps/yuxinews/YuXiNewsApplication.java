package com.bbapps.yuxinews;

import android.app.Application;

import org.xutils.x;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews
 * @ClassName: YuXiNewsApplication
 * @Author: Bb
 * @CreateDate: 2019/10/16 14:16
 * @Version: 1.0
 * @Description: 代表软件全局
 */
public class YuXiNewsApplication extends Application {
    /**
     * 在所有组件创建之前执行
     */
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }
}
