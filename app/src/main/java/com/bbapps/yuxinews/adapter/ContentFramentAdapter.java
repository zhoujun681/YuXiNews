package com.bbapps.yuxinews.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bbapps.yuxinews.base.BasePager;

import java.util.ArrayList;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.adapter
 * @ClassName: ContentFramentAdapter
 * @Author: Bb
 * @CreateDate: 2019/10/25 13:25
 * @Version: 1.0
 * @Description: ContentFramentAdapter
 */
public class ContentFramentAdapter extends PagerAdapter {

    private final ArrayList<BasePager> basePagers;

    public ContentFramentAdapter(ArrayList<BasePager> basePagers){
        this.basePagers=basePagers;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return basePagers.size();
    }

    /**
     * 相当于getview，获取当前页面位置并指定页面内容
     * @param container Viewpager
     * @param position  创建的页面的位置
     * @return
     */
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        BasePager basePager = basePagers.get(position);//得到各个页面实例
        View rootView = basePager.rootView;
        //调用各个页面的initdata,如果这里调用，则会提前初始化下一个标签的数据，这里改为点击选项后调用
//            basePager.initData();
        container.addView(rootView);
        return rootView;
    }

    /**
     *通过比较当前view和从容器中获取的view,确定是否是容器中的view
     * @param view 当前视图
     * @param object instantiateItem返回的值
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
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
        container.removeView((View) object);
    }
}