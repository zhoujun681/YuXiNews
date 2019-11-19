/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.pager
 * @ClassName: HomePager
 * @Author: Bb
 * @CreateDate: 2019/10/22 15:39
 * @Version: 1.0
 * @Description: java类作用描述
 */
package com.bbapps.yuxinews.pager;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bbapps.yuxinews.MainActivity;
import com.bbapps.yuxinews.base.BasePager;
import com.bbapps.yuxinews.base.MenuDetaiBasePager;
import com.bbapps.yuxinews.domain.NewsCenterPagerBean;
import com.bbapps.yuxinews.fragment.LeftMenuFragment;
import com.bbapps.yuxinews.pager.menudatailpager.InteracMenuDetailPager;
import com.bbapps.yuxinews.pager.menudatailpager.NewsMenuDetailPager;
import com.bbapps.yuxinews.pager.menudatailpager.PhotosMenuDetailPager;
import com.bbapps.yuxinews.pager.menudatailpager.TopicMenuDetailPager;
import com.bbapps.yuxinews.utils.CacheUtils;
import com.bbapps.yuxinews.utils.Constants;
import com.bbapps.yuxinews.utils.LogUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.pager
 * @ClassName: HomePager
 * @Author: Bb
 * @CreateDate: 2019/10/22 15:39
 * @Version: 1.0
 * @Description: 新闻中心
 */
public class NewsCenterPager extends BasePager {

    //定义区------------------------------------------------------
    private List<NewsCenterPagerBean.DataBean> data; //左侧菜单对应数据的集合
    private ArrayList<MenuDetaiBasePager> detaiBasePagers;//左侧菜单对应页面的集合
//方法区------------------------------------------------------
    //---构造方法区-------------------------------------------
    public NewsCenterPager(Context context) {
        super(context);
    }
    //---继承方法区-------------------------------------------

    @Override
    public void initData() {
        super.initData();
        ib_menu.setVisibility(View.VISIBLE); //显示菜单显示按钮
        tv_title.setText("新闻中心");
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setText("新闻中心内容");
        fl_content.addView(textView);

        //获取缓存数据
        String saveJson = CacheUtils.getString(context, Constants.NEWSCENTER_PAGER_URL);
        if(!TextUtils.isEmpty((saveJson))){
            processData(saveJson);
        }

        //请求数据
        getDataFromNet();
    }


    //---普通方法区-------------------------------------------

    /**
     * 联网请求数据
     */
    private void getDataFromNet() {
        RequestParams parms = new RequestParams(Constants.NEWSCENTER_PAGER_URL);
        x.http().get(parms, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LogUtil.e("联网请求成功,data == "+result);
                //缓存数据
                CacheUtils.putString(context,Constants.NEWSCENTER_PAGER_URL,result);

                processData(result);
            }



            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("联网请求出错,error == "+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("联网请求异常退出,error == "+cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("联网请求完成！！");
            }
        });
    }

    /**
     * 解析json数据和显示数据
     * @param json
     */
    private void processData(String json) {
        NewsCenterPagerBean bean = parsedJson(json);
        LogUtil.e("解析json成功，获得测试数据title == "+bean.getData().get(0).getChildren().get(1).getTitle());
        //给左侧菜单传递数据
        data = bean.getData();

        //添加页面
        detaiBasePagers = new ArrayList<>();
        detaiBasePagers.add(new NewsMenuDetailPager(context,data.get(0)));
        detaiBasePagers.add(new TopicMenuDetailPager(context));
        detaiBasePagers.add(new PhotosMenuDetailPager(context));
        detaiBasePagers.add(new InteracMenuDetailPager(context));

        MainActivity mainActivity = (MainActivity) context;
        LeftMenuFragment leftmenuFragment = mainActivity.getLeftmenuFragment(); //获得左侧菜单
        leftmenuFragment.setData(data);//把数据传递给左侧菜单
    }

    /**
     * 解析json
     * @param json
     * @return
     */
    private NewsCenterPagerBean parsedJson(String json) {
        Gson gson = new Gson();
        NewsCenterPagerBean bean = gson.fromJson(json, NewsCenterPagerBean.class);
        return bean;
    }

    /**
     * 根据位置切换详情页面
     * @param position
     */
    public void swichPager(int position) {
        //1.设置标题
        tv_title.setText(data.get(position).getTitle());
        //2.移除之前内容
        fl_content.removeAllViews();
        //3.添加新内容
        MenuDetaiBasePager detaiBasePager = detaiBasePagers.get(position);
        View rootView = detaiBasePager.rootView;
        detaiBasePager.initData();//初始化数据

        fl_content.addView(rootView);
    }
//接口区------------------------------------------------------
//内部类区----------------------------------------------------
//其他区域----------------------------------------------------  
}
