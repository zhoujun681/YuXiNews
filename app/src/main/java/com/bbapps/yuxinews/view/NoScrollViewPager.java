/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.view
 * @ClassName: NoScrollViewPager
 * @Author: Bb
 * @CreateDate: 2019/10/24 13:42
 * @Version: 1.0
 * @Description: java类作用描述
 */
package com.bbapps.yuxinews.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.view
 * @ClassName: NoScrollViewPager
 * @Author: Bb
 * @CreateDate: 2019/10/24 13:42
 * @Version: 1.0
 * @Description: 自定义ViewPager，屏蔽左右滑动
 */
public class NoScrollViewPager extends ViewPager {

    /**
     * 请在各个区的行号处按ctrl点击或者按F11添加书签，也可以使用ctrl+F11添加带符号的书签。
     * 最后使用shift+F11快速跳转。或者使用alt+2打开收藏面板查看。
     **/
//定义区------------------------------------------------------
//方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //---继承方法区-------------------------------------------

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    //---普通方法区-------------------------------------------
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
//其他区域----------------------------------------------------  
}
