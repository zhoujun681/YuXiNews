package com.bbapps.yuxinews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bbapps.yuxinews.MainActivity;
import com.bbapps.yuxinews.R;
import com.bbapps.yuxinews.SplashActivity;
import com.bbapps.yuxinews.utils.CacheUtils;
import com.bbapps.yuxinews.utils.DensityUtil;

import java.util.ArrayList;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.activity
 * @ClassName: GuideActivity
 * @Author: Bb
 * @CreateDate: 2019/9/19 14:47
 * @Version: 1.0
 * @Description: java类作用描述
 */
public class GuideActivity extends Activity {
    private ViewPager viewpager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;
    private ImageView iv_red_point;
    private ArrayList<ImageView> imageViews;
    private int leftmax; //两点间距
    private int widthdpi; //像素转为的dip


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        btn_start_main = (Button) findViewById(R.id.btn_start_main);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);
        iv_red_point = (ImageView) findViewById(R.id.iv_red_point);

        //准备数据
        int[] ids = new int[]{
          R.drawable.guid_1,
          R.drawable.guid_2,
          R.drawable.guid_3
        };
        imageViews=new ArrayList<>();
        widthdpi = DensityUtil.dip2px(this, 10);
        for (int i = 0; i <ids.length ; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);
            //添加点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthdpi, widthdpi); //单位像素
            if(i!=0){
                //不包括第0个点，所有点距离左边10像素
                params.leftMargin = widthdpi;
            }
            point.setLayoutParams(params);
            //添加到线性布局
            ll_point_group.addView(point);
        }
        //设置viewpager适配器
        viewpager.setAdapter(new myPagerAdapter());

        //根据view的生命周期，当视图执行到onLayout或者onDraw的时候，获取视图的宽和高以及边距
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

        //得到屏幕滑动的百分比
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

        //设置按钮点击事件
        btn_start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.保存是否进入主页的状态
                CacheUtils.putBoolean(GuideActivity.this, SplashActivity.START_MAIN,true);
                //2.跳转到主页面
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);

                //3.关闭引导页面
                finish();
            }
        });
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**当页面滑动时回调
         * This method will be invoked when the current page is scrolled, either as part
         * of a programmatically initiated smooth scroll or a user initiated touch scroll.
         *
         * @param position             当前滑动的位置  Position index of the first page currently being displayed.
         *                             Page position+1 will be visible if positionOffset is nonzero.
         * @param positionOffset       页面滑动的百分比 Value from [0, 1) indicating the offset from the page at
         *                             position.
         * @param positionOffsetPixels 滑动的像素 Value in pixels indicating the offset from position.
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //两点间的距离 = 屏幕滑动百分比 * 两点间距
            int leftmargin = (int) (positionOffset * leftmax);

            //红点移动的距离 = 原来的位置 + 两点间移动的距离
            leftmargin = position*leftmax + leftmargin;

            //设置参数
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
            params.leftMargin = leftmargin;
            iv_red_point.setLayoutParams(params);
        }

        /**当页面被选中时回调
         * This method will be invoked when a new page becomes selected. Animation is not
         * necessarily complete.
         *
         * @param position 被选中页面对应的位置 Position index of the new selected page.
         */
        @Override
        public void onPageSelected(int position) {
            if(position == imageViews.size()-1){
                //最后一个页面显示按钮
                btn_start_main.setVisibility(View.VISIBLE);
            }else{
                btn_start_main.setVisibility(View.GONE);
            }
        }

        /**当页面状态发生变化时回调
         * Called when the scroll state changes. Useful for discovering when the user
         * begins dragging, when the pager is automatically settling to the current page,
         * or when it is fully stopped/idle.
         *
         * @param state The new scroll state.
         * @see ViewPager#SCROLL_STATE_IDLE  闲置静止状态
         * @see ViewPager#SCROLL_STATE_DRAGGING 拖动状态
         * @see ViewPager#SCROLL_STATE_SETTLING 自动滑动状态
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        /**
         * Callback method to be invoked when the global layout state or the visibility of views
         * within the view tree changes
         */
        @Override
        public void onGlobalLayout() {
            //因为视图树时从根节点执行，所以不止执行一次。我们只需要一次。所以执行一次后即可移除监听
            iv_red_point.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            //求出两点之间的间距
            //间距 = 第1个点距离左边的距离 - 第0个点距离左边的距离
            leftmax = ll_point_group.getChildAt(1).getLeft() - ll_point_group.getChildAt(0).getLeft();

        }
    }

    private class myPagerAdapter extends PagerAdapter {
        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 相当于getview，获取当前页面位置并指定页面内容
         * @param container Viewpager
         * @param position  创建的页面的位置
         * @return
         */
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            //添加到容器中
            container.addView(imageView);
            return imageView;
        }

        /**
         *通过比较当前view和从容器中获取的view,确定是否是容器中的view
         * @param view 当前视图
         * @param object instantiateItem返回的值
         * @return
         */
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        /**
         * 销毁页面
         * @param container 等于Viewpager
         * @param position 要销毁页面的位置
         * @param object    要销毁的页面
         */
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position,
                                @NonNull Object object) {
//            super.destroyItem(container, position, object);  //不需要，不注释会崩溃
            container.removeView((View) object);
        }
    }
}
