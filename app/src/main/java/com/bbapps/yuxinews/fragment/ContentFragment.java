package com.bbapps.yuxinews.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bbapps.yuxinews.MainActivity;
import com.bbapps.yuxinews.R;
import com.bbapps.yuxinews.adapter.ContentFramentAdapter;
import com.bbapps.yuxinews.base.BaseFragment;
import com.bbapps.yuxinews.base.BasePager;
import com.bbapps.yuxinews.pager.GovaffairPager;
import com.bbapps.yuxinews.pager.HomePager;
import com.bbapps.yuxinews.pager.NewsCenterPager;
import com.bbapps.yuxinews.pager.SettingPager;
import com.bbapps.yuxinews.pager.SmartServicePager;
import com.bbapps.yuxinews.utils.LogUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.fragment
 * @ClassName: ContentFragment
 * @Author: Bb
 * @CreateDate: 2019/10/12 14:07
 * @Version: 1.0
 * @Description: java类作用描述
 */
public class ContentFragment extends BaseFragment {

    @ViewInject(R.id.rg_main)
    private RadioGroup rg_main;
    @ViewInject(R.id.viewpager)
    private ViewPager viewpager;

    private ArrayList<BasePager> basePagers;//装五个页面

    /**
     * 让子类实现自己的视图
     *
     * @return
     */
    @Override
    public View initView() {
        LogUtil.e("正文视图被初始化");
        View view = View.inflate(context, R.layout.content_fragment, null);
//        rg_main = (RadioGroup) view.findViewById(R.id.rg_main);
//        viewpager = (ViewPager) view.findViewById(R.id.viewpager);

        x.view().inject(ContentFragment.this,view); //把类和view关联起来，就可以使用注解
        return view;
    }

    /**
     * 请求数据到initView的视图上
     * 此方法可以用抽象也可以用普通方法
     */
    @Override
    public void initData() {
        LogUtil.e("正文菜单数据被初始化");

        //初始化五个页面并放入集合
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(context)); //主页面
        basePagers.add(new NewsCenterPager(context)); //新闻中心
        basePagers.add(new SmartServicePager(context)); //智慧服务
        basePagers.add(new GovaffairPager(context)); //政要指南
        basePagers.add(new SettingPager(context)); //设置中心



        //设置viewPager适配器
        viewpager.setAdapter(new ContentFramentAdapter(basePagers));

        //设置radioGroup的选中状态监听
        rg_main.setOnCheckedChangeListener(new myOnCheckedChangeListener());

        //某个页面被选中，初始化相应数据
        viewpager.addOnPageChangeListener(new myOnPageChangeListener());

        //设置默认选择主页
        rg_main.check(R.id.rb_home);
        basePagers.get(0).initData(); //启动时初始化主页数据
        isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);//不可以划出侧滑菜单
    }

    /**
     * 得到新闻中心
     * @return
     */
    public NewsCenterPager getNewsCenterPager() {
        return (NewsCenterPager) basePagers.get(1);
    }

    class myOnPageChangeListener implements ViewPager.OnPageChangeListener{

        /**
         * This method will be invoked when the current page is scrolled, either as part
         * of a programmatically initiated smooth scroll or a user initiated touch scroll.
         *
         * @param position             Position index of the first page currently being displayed.
         *                             Page position+1 will be visible if positionOffset is nonzero.
         * @param positionOffset       Value from [0, 1) indicating the offset from the page at
         *                             position.
         * @param positionOffsetPixels Value in pixels indicating the offset from position.
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * This method will be invoked when a new page becomes selected. Animation is not
         * necessarily complete.
         *
         * @param position Position index of the new selected page.
         */
        @Override
        public void onPageSelected(int position) {
            basePagers.get(position).initData(); //初始化数据
        }

        /**
         * Called when the scroll state changes. Useful for discovering when the user
         * begins dragging, when the pager is automatically settling to the current page,
         * or when it is fully stopped/idle.
         *
         * @param state The new scroll state.
         * @see ViewPager#SCROLL_STATE_IDLE
         * @see ViewPager#SCROLL_STATE_DRAGGING
         * @see ViewPager#SCROLL_STATE_SETTLING
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class myOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        /**
         * <p>Called when the checked radio button has changed. When the
         * selection is cleared, checkedId is -1.</p>
         *
         * @param group     the group in which the checked radio button has changed
         * @param checkedId the unique identifier of the newly checked radio button
         */
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_home:
                    viewpager.setCurrentItem(0);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_newscenter:
                    viewpager.setCurrentItem(1);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    break;
                case R.id.rb_smartservice:
                    viewpager.setCurrentItem(2);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_govaffair:
                    viewpager.setCurrentItem(3);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_setting:
                    viewpager.setCurrentItem(4,false); //第二个参数时是否有滚动动画
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
            }
        }
    }

    /**
     * 设置是否可以开启侧滑菜单
     * @param touchMode
     */
    private void isEnableSlidingMenu(int touchMode) {
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.getSlidingMenu().setTouchModeAbove(touchMode);
    }

}
