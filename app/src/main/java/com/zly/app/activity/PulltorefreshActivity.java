package com.zly.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.zhuliyi.pulltorefreshdemo.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PulltorefreshActivity extends Activity {
    PullToRefreshListView lv;
    private String[] mListTitle = {"姓名", "性别", "年龄", "居住地", "邮箱"};
    private String[] mListStr = {"雨松MOMO", "男", "25", "北京",
            "xuanyusong@gmail.com"};
    ListView mListView = null;
    ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltorefresh);
        // 获取 PullToRefreshListView View
        lv = (PullToRefreshListView) findViewById(R.id.left_drawer);
        // ....
        int lengh = mListTitle.length;
        for (int i = 0; i < lengh; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("title", mListTitle[i]);
            item.put("text", mListStr[i]);
            mData.add(item);
        }

        // ...
        SimpleAdapter adapter = new SimpleAdapter(this, mData, android.R.layout.simple_list_item_2,
                new String[]{"title", "text"}, new int[]{android.R.id.text1, android.R.id.text2});
        // 将 SimpleAdapter 设置到 PullToRefreshListView
        lv.setAdapter(adapter);
        //设置点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(PulltorefreshActivity.this,BackTurnActivity.class);
                startActivity(intent);

            }
        });
        //同时实现下拉刷新和上拉加载,实现OnRefreshListener2
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>(){

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        // 处理刷新任务
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void reslst)
                    {
                        // 更行内容，通知 PullToRefresh 刷新结束
                        lv.onRefreshComplete();
                    }
                }.execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
//                new AsyncTask<Void, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(Void... params) {
//                        // 处理刷新任务
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        return null;
//                    }
//                    @Override
//                    protected void onPostExecute(Void reslst)
//                    {
//                        // 更行内容，通知 PullToRefresh 刷新结束
//                        lv.onRefreshComplete();
//                    }
//                }.execute();
            }
        });
//        // 刷新事件监听
//        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
//
//            @Override
//            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//                // ...
//                new AsyncTask<Void, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(Void... params) {
//                        // 处理刷新任务
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        return null;
//                    }
//                    @Override
//                    protected void onPostExecute(Void reslst)
//                    {
//                        // 更行内容，通知 PullToRefresh 刷新结束
//                        lv.onRefreshComplete();
//                    }
//                }.execute();
//            }
//        });
        //设置PullRefreshListView上提加载时的加载提示
        lv.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
        lv.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        lv.getLoadingLayoutProxy(false, true).setReleaseLabel("松开加载更多...");
        // 设置PullRefreshListView下拉加载时的加载提示
        lv.getLoadingLayoutProxy(true, false).setPullLabel("下拉刷新...");
        lv.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新...");
        lv.getLoadingLayoutProxy(true, false).setReleaseLabel("松开刷新...");
    }

}
