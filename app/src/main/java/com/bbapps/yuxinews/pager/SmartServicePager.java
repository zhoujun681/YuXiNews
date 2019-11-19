/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.pager
 * @ClassName: HomePager
 * @Author: Bb
 * @CreateDate: 2019/10/22 15:39
 * @Version: 1.0
 * @Description: java类作用描述
 */
package com.bbapps.yuxinews.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.bbapps.yuxinews.base.BasePager;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.pager
 * @ClassName: HomePager
 * @Author: Bb
 * @CreateDate: 2019/10/22 15:39
 * @Version: 1.0
 * @Description: 智慧服务
 */
public class SmartServicePager extends BasePager {

    //定义区------------------------------------------------------
//方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public SmartServicePager(Context context) {
        super(context);
    }
    //---继承方法区-------------------------------------------

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("智慧服务");
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setText("智慧服务内容");
        fl_content.addView(textView);
    }

    //---普通方法区-------------------------------------------
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
//其他区域----------------------------------------------------  
}
