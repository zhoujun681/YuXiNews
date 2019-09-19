package com.bbapps.yuxinews.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bbapps.yuxinews.R;

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
    private ArrayList<ImageView> imageViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        btn_start_main = (Button) findViewById(R.id.btn_start_main);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);

        //准备数据
        int[] ids = new int[]{
          R.drawable.guid_1,
          R.drawable.guid_2,
          R.drawable.guid_3
        };
        imageViews=new ArrayList<>();
        for (int i = 0; i <ids.length ; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);
            //设置viewpager适配器
            viewpager.setAdapter(new myPagerAdapter());
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
