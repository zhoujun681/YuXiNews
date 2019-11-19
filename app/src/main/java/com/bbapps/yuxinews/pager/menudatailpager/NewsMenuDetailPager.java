/**
 * @ProjectName: YuXiNews
 * @ClassName: NewsMenuDetailPager
 * @Author: Bb
 * @CreateDate: 2019/10/30 14:50
 * @Description: 新闻详细页面
 */
package com.bbapps.yuxinews.pager.menudatailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bbapps.yuxinews.MainActivity;
import com.bbapps.yuxinews.R;
import com.bbapps.yuxinews.base.MenuDetaiBasePager;
import com.bbapps.yuxinews.domain.NewsCenterPagerBean;
import com.bbapps.yuxinews.pager.menudatailpager.TabDetailPager.TabDetailPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class NewsMenuDetailPager extends MenuDetaiBasePager {

//定义区------------------------------------------------------
    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;

    @ViewInject(R.id.tabPageIndicator)
    private TabPageIndicator tabPageIndicator;

    @ViewInject(R.id.ib_tab_next)
    private ImageButton ib_tab_next;


    private List<NewsCenterPagerBean.DataBean.ChildrenBean> children; //页签数据的集合
    private ArrayList<TabDetailPager> tabDetailPagers;  //页签页面的集合

    //方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public  NewsMenuDetailPager(Context context, NewsCenterPagerBean.DataBean drtailPagerData){
        super(context);
        children = drtailPagerData.getChildren();
    }
    //---抽象方法区-------------------------------------------
    //---继承方法区-------------------------------------------
    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.newsmenu_detail_pager, null);
        x.view().inject(NewsMenuDetailPager.this,view);
        //设置箭头点击事件
        ib_tab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1); //会自动处理越界
            }
        });
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        //将数据填充页面
        tabDetailPagers = new ArrayList<>();
        for(int i=0;i<children.size();i++){
            tabDetailPagers.add(new TabDetailPager(context,children.get(i)));
        }

        //设置适配器
        viewPager.setAdapter(new MyNewsMenuDetailPagerAdapter());

        //把Viewpager和TabpageIndicator关联
        tabPageIndicator.setViewPager(viewPager);

        //监听页面变化，需要用tabPageIndicator
        tabPageIndicator.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    //---普通方法区-------------------------------------------
    /**
     * 设置是否可以开启侧滑菜单
     * @param touchMode
     */
    private void isEnableSlidingMenu(int touchMode) {
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.getSlidingMenu().setTouchModeAbove(touchMode);
    }
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

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
            if(position == 0){
                //第一个页面允许划出菜单
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
            }else {
                //不划出菜单
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
            }
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

    class MyNewsMenuDetailPagerAdapter extends PagerAdapter{

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return children.get(position).getTitle();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TabDetailPager tabDetailPager = tabDetailPagers.get(position);
            View rootView = tabDetailPager.rootView;
            tabDetailPager.initData();//初始化数据
            container.addView(rootView);
            return rootView;
        }


        @Override
        public void destroyItem(@NonNull ViewGroup container, int position,
                                @NonNull Object object) {
            container.removeView((View) object);
        }


        @Override
        public int getCount() {
            return tabDetailPagers.size();
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
//其他区域----------------------------------------------------  
}
