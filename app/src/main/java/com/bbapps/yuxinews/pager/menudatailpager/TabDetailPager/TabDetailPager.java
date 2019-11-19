package com.bbapps.yuxinews.pager.menudatailpager.TabDetailPager;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bbapps.yuxinews.R;
import com.bbapps.yuxinews.base.MenuDetaiBasePager;
import com.bbapps.yuxinews.domain.NewsCenterPagerBean;
import com.bbapps.yuxinews.domain.TabDetailPagerBean;
import com.bbapps.yuxinews.utils.CacheUtils;
import com.bbapps.yuxinews.utils.Constants;
import com.bbapps.yuxinews.utils.LogUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * @ProjectName: YuXiNews
 * @ClassName: TabDetailPager
 * @Author: Bb
 * @CreateDate: 2019/11/11 13:01
 * @Description: java类作用描述
 */
public class TabDetailPager extends MenuDetaiBasePager {
    //定义区-----------------------------------------------------
    private ViewPager viewpager;
    private TextView tv_title;
    private LinearLayout ll_point_group;
    private ListView listview;

    private String url;
    private List<TabDetailPagerBean.DataBean.TopnewsBean> topnews;      //顶部轮播图数据
    private int prePostion;//之前红点的位置

    //方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public TabDetailPager(Context context, NewsCenterPagerBean.DataBean.ChildrenBean childrenData) {
        super(context);
        this.childrenData = childrenData;
    }

    //---抽象方法区-------------------------------------------
    //---继承方法区-------------------------------------------

    /**
     * 抽象方法，由子类实现，实现不同页面不同效果
     *
     * @return
     */
    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.tabdetail_pager, null);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        ll_point_group = (LinearLayout) view.findViewById(R.id.ll_point_group);
        listview = (ListView) view.findViewById(R.id.listview);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //从缓存获取数据
        String saveJson = CacheUtils.getString(context, url);
        if (!TextUtils.isEmpty(saveJson)) {
            //解析数据
            processData(saveJson);
        }

        //获取地址
        url = Constants.BASE_URL + childrenData.getUrl();
        LogUtil.e(childrenData.getTitle() + "的URL:" + url);
        //获取数据
        getDataFromNet();
    }


    //---普通方法区-------------------------------------------
    private void processData(String json) {
        TabDetailPagerBean bean = parsedJson(json);
        LogUtil.e(childrenData.getTitle() + "解析成功---" + bean.getData().getNews().get(0).getTitle());

        //顶部轮播图数据
        topnews = bean.getData().getTopnews();

        //设置ViewPager适配器
        viewpager.setAdapter(new TabDetailPagerTopNewsAdapter());

        //添加点
        addPoint();

        //监听页面的改变，设置红点变化和文本变化
        viewpager.addOnPageChangeListener(new myOnPageChangeListener());
    }

    private void addPoint() {
        ll_point_group.removeAllViews();//先移除所有点
        //设置点的间距和大小
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(DensityUtil.dip2px(6),DensityUtil.dip2px(6));
        //添加点
        for (int i=0;i<topnews.size();i++){
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(R.drawable.point_selector);

            if(i==0){
                imageView.setEnabled(true);
            }else {
                imageView.setEnabled(false);
                parms.leftMargin = DensityUtil.dip2px(8);
            }


            imageView.setLayoutParams(parms);

            ll_point_group.addView(imageView);
        }
    }

    private TabDetailPagerBean parsedJson(String json) {
        return new Gson().fromJson(json, TabDetailPagerBean.class);
    }

    private void getDataFromNet() {
        RequestParams parms = new RequestParams(url);
        x.http().get(parms, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LogUtil.e(childrenData.getTitle() + "数据请求成功:" + result);
                //缓存数据
                CacheUtils.putString(context, url, result);
                if (!TextUtils.isEmpty(result)) {
                    //解析数据
                    processData(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e(childrenData.getTitle() + "数据请求失败:" + ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //接口区------------------------------------------------------
//内部类区----------------------------------------------------
    class myOnPageChangeListener implements ViewPager.OnPageChangeListener{


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }


        @Override
        public void onPageSelected(int position) {
            //1.设置文本
            tv_title.setText(topnews.get(position).getTitle());
            //2.设置红点
                //把之前的设为灰色
            ll_point_group.getChildAt(prePostion).setEnabled(false);
                //把当前的设为红色
            ll_point_group.getChildAt(position).setEnabled(true);
            prePostion = position;

        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class TabDetailPagerTopNewsAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return topnews.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //创建ImageView并添加到容器
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(R.drawable.home_scroll_default);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//设置图片拉伸显示
            container.addView(imageView);
            //获得新闻图片URL
            TabDetailPagerBean.DataBean.TopnewsBean topnewsBean = topnews.get(position);
            String imageUrl = Constants.BASE_URL + topnewsBean.getTopimage();
            //网络请求图片
            x.image().bind(imageView,imageUrl);
            return imageView;
        }


        @Override
        public void destroyItem(@NonNull ViewGroup container, int position,
                                @NonNull Object object) {
            container.removeView((View) object);
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
//其他区域----------------------------------------------------  
}
