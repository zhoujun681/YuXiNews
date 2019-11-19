package com.bbapps.yuxinews.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bbapps.yuxinews.MainActivity;
import com.bbapps.yuxinews.R;
import com.bbapps.yuxinews.adapter.ContentFramentAdapter;
import com.bbapps.yuxinews.base.BaseFragment;
import com.bbapps.yuxinews.domain.NewsCenterPagerBean;
import com.bbapps.yuxinews.pager.NewsCenterPager;
import com.bbapps.yuxinews.utils.DensityUtil;
import com.bbapps.yuxinews.utils.LogUtil;

import java.util.List;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.fragment
 * @ClassName: LeftMenuFragment
 * @Author: Bb
 * @CreateDate: 2019/10/12 14:04
 * @Version: 1.0
 * @Description: 左侧菜单的Fragment
 */
public class LeftMenuFragment extends BaseFragment {

    private List<NewsCenterPagerBean.DataBean> data;
    private ListView listView;
    private LeftmenuFragmentAdapter adapter;
    private int prePosition;//listview点击的位置

    /**
     * 让子类实现自己的视图
     *
     * @return
     */
    @Override
    public View initView() {
        LogUtil.e("左侧菜单视图被初始化");
        listView = new ListView(context);
        listView.setPadding(0, DensityUtil.dip2px(context,40),0,0);
        listView.setDividerHeight(0); //设置分割线高度为0
        listView.setCacheColorHint(Color.TRANSPARENT); //设置默认未选中颜色，不设置容易拖动闪和变色
        listView.setSelector(android.R.color.transparent);//设置按下item不变色
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //1.记录点击位置，变成红色
                prePosition = position;
                adapter.notifyDataSetChanged();//执行getView
                //2.关闭左侧菜单
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();//关< - >开
                //3.切换到对应页面
                swichPager(prePosition);
            }
        });
        return listView;
    }

    /**
     * 根据位置切换页面
     * @param position
     */
    private void swichPager(int position) {
        MainActivity mainActivity = (MainActivity) context;
        ContentFragment contentFragment = mainActivity.getContentFragment();
        NewsCenterPager newsCenterPager = contentFragment.getNewsCenterPager();
        newsCenterPager.swichPager(position);
    }

    /**
     * 请求数据到initView的视图上
     * 此方法可以用抽象也可以用普通方法
     */
    @Override
    public void initData() {
        LogUtil.e("左侧菜单数据被初始化");
    }

    /**
     * 接收并设置数据
     *
     * @param data
     */
    public void setData(List<NewsCenterPagerBean.DataBean> data) {
        this.data = data;
        for (int i = 0; i < data.size(); i++) {
            LogUtil.e("title==" + data.get(i).getTitle());
        }

        adapter = new LeftmenuFragmentAdapter();
        //设置listview适配器
        listView.setAdapter(adapter);
        //设置默认页面
        swichPager(prePosition);

    }

    class LeftmenuFragmentAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }


        @Override
        public Object getItem(int position) {
            return null;
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) View.inflate(context, R.layout.item_leftmenu,null);
            textView.setText(data.get(position).getTitle());
            //根据点击的位置是否是当前位置设置颜色
            textView.setEnabled(prePosition==position);
            return textView;
        }
    }
}
