package com.zly.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhuliyi.pulltorefreshdemo.R;

/**
 * 侧滑菜单
 * Created by zhuliyi on 2015/12/27.
 */
public class MenuFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_menu,null);


        return rootView;
    }
}
