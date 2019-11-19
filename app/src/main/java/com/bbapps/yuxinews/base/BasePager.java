/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.base
 * @ClassName: BasePager
 * @Author: Bb
 * @CreateDate: 2019/10/22 13:19
 * @Version: 1.0
 * @Description: java类作用描述
 */
package com.bbapps.yuxinews.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bbapps.yuxinews.MainActivity;
import com.bbapps.yuxinews.R;
import com.bbapps.yuxinews.fragment.ContentFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.base
 * @ClassName: BasePager
 * @Author: Bb
 * @CreateDate: 2019/10/22 13:19
 * @Version: 1.0
 * @Description: 各个页面的基类
 */
public class BasePager {
//定义区------------------------------------------------------
    public final Context context; //上下文
    public View rootView; //代表各个不同页面

    @ViewInject(R.id.tv_title)
    public TextView tv_title; //标题
    @ViewInject(R.id.ib_menu)
    public ImageButton ib_menu; //点击策划按钮
    @ViewInject(R.id.fl_content)
    public FrameLayout fl_content; //用于加载各个子页面

//方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public BasePager(Context context){
        this.context=context;
        rootView=initView();
    }

    //---继承方法区-------------------------------------------
    //---普通方法区-------------------------------------------

    /**
     * 初始化公共视图部分
     * @return
     */
    private View initView() {
        View view = View.inflate(context, R.layout.base_pager, null);
        x.view().inject(BasePager.this,view); //把类和view关联起来，就可以使用注解
        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭左侧菜单
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();//关< - >开
            }
        });
        return view;
    }

    /**
     * 初始化数据，供子类重写
     */
    public  void initData(){

    }
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
//其他区域----------------------------------------------------  
}
