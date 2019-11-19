package com.bbapps.yuxinews.utils;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.utils
 * @ClassName: Constants
 * @Author: Bb
 * @CreateDate: 2019/10/25 13:36
 * @Version: 1.0
 * @Description: 常量
 */
public class Constants {
    //服务器基础地址 10.0.2.2为电脑相对于as自带android模拟器的地址，相当于本机的127.0.0.1
    public static final String BASE_URL="http://10.0.2.2:8090/web_home";
    //新闻中心数据请求网络地址
    public static final String NEWSCENTER_PAGER_URL=BASE_URL+"/static/api/news/categories.json";
}
