package com.bbapps.yuxinews.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bbapps.yuxinews.pager.NewsCenterPager;

/**
 * @ProjectName: YuXiNews
 * @Package: com.bbapps.yuxinews.fragment
 * @ClassName: BaseFragment
 * @Author: Bb
 * @CreateDate: 2019/10/12 14:08
 * @Version: 1.0
 * @Description: 基类Fragment
 */
public abstract class BaseFragment extends Fragment {
    public Activity context;

    /**
     * 当fragment被创建时回调
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    /**
     * 当视图被创建时回调
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 让子类实现自己的视图
     * @return
     */
    public abstract View initView();

    /**
     * 当Activity被创建后回调
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 请求数据到initView的视图上
     * 此方法可以用抽象也可以用普通方法
     */
    public abstract void initData();
}
