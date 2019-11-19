
package com.bbapps.yuxinews.pager.menudatailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bbapps.yuxinews.base.MenuDetaiBasePager;
/**
 * @ProjectName: YuXiNews
 * @ClassName: NewsMenuDetailPager
 * @Author: Bb
 * @CreateDate: 2019/10/30 14:50
 * @Description: 图组详细页面
 */

public class PhotosMenuDetailPager extends MenuDetaiBasePager {

//定义区------------------------------------------------------
    private TextView textView;
//方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public PhotosMenuDetailPager(Context context){
        super(context);
    }
    //---抽象方法区-------------------------------------------
    //---继承方法区-------------------------------------------
    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("图组详情");
    }

    //---普通方法区-------------------------------------------
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
//其他区域----------------------------------------------------  
}
