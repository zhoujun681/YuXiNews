/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.base
 * @ClassName: MenuDetaiBasePager
 * @Author: Bb
 * @CreateDate: 2019/10/30 14:37
 * @Version: 1.0
 * @Description: java类作用描述
 */
package com.bbapps.yuxinews.base;

import android.content.Context;
import android.view.View;

import com.bbapps.yuxinews.domain.NewsCenterPagerBean;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.base
 * @ClassName: MenuDetaiBasePager
 * @Author: Bb
 * @CreateDate: 2019/10/30 14:37
 * @Version: 1.0
 * @Description: 新闻左侧菜单的各个页面的公共页面
 */
public abstract class MenuDetaiBasePager {
/**
 请在各个区的行号处按ctrl点击或者按F11添加书签，也可以使用ctrl+F11添加带符号的书签。
 最后使用shift+F11快速跳转。或者使用alt+2打开收藏面板查看。
 **/
//定义区------------------------------------------------------
    public final Context context; //上下文
    public View rootView; //代表各个页面视图
    protected NewsCenterPagerBean.DataBean.ChildrenBean childrenData;

    //方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public MenuDetaiBasePager(Context context){
        this.context=context;
        rootView=initView();
    }

    //---抽象方法区-------------------------------------------

    /**
     * 抽象方法，由子类实现，实现不同页面不同效果
     * @return
     */
    public abstract View initView();
    //---继承方法区-------------------------------------------
    //---普通方法区-------------------------------------------

    /**
     * 子页面需要请求和绑定数据时重新写此方法
     */
    public void initData(){

    }
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
//其他区域----------------------------------------------------  
}
