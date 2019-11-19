package com.bbapps.yuxinews;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bbapps.yuxinews.fragment.ContentFragment;
import com.bbapps.yuxinews.fragment.LeftMenuFragment;
import com.bbapps.yuxinews.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String MAIN_CONTENT_TAG = "main_content_tag";
    public static final String LEFTMENU_TAG = "leftmenu_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //设置状态栏透明
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //设置不要标题
        super.onCreate(savedInstanceState);
        //初始化侧边菜单
        initSlidingMenu();

        //初始化Fragment
        initFragment();
    }

    private void initSlidingMenu() {
        //1.设置主页面
        setContentView(R.layout.activity_main);
        //2.设置左侧菜单
        setBehindContentView(R.layout.activity_leftmenu);
        //3.设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.activity_rightmenu);
        //4.设置显示模式:左+主页，左+主页+右，主页+右
        slidingMenu.setMode(SlidingMenu.LEFT);
        //5.设置滑动模式：边缘滑动，全屏滑动，不可滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //6.设置主页占据的宽度
        slidingMenu.setBehindOffset(DensityUtil.dip2px(MainActivity.this, 200));
    }

    private void initFragment() {
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //3.替换
        ft.replace(R.id.fl_main_content, new ContentFragment(), MAIN_CONTENT_TAG); //主页
        ft.replace(R.id.fl_leftmenu, new LeftMenuFragment(), LEFTMENU_TAG); //左侧菜单
        //4.提交
        ft.commit();

    }

    /**
     * 获得左侧菜单的Fragment
     * @return
     */
    public LeftMenuFragment getLeftmenuFragment() {
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //2.通过Tag得到fragment
        LeftMenuFragment leftmenuFragment = (LeftMenuFragment) fm.findFragmentByTag(LEFTMENU_TAG);
        return  leftmenuFragment;
    }

    /**
     * 得到主菜单的fragment
     * @return
     */
    public ContentFragment getContentFragment() {
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //2.通过Tag得到fragment
        ContentFragment contentFragment = (ContentFragment) fm.findFragmentByTag(MAIN_CONTENT_TAG);
        return  contentFragment;
    }
}
