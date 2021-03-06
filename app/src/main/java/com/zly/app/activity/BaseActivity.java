package com.zly.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.zhuliyi.pulltorefreshdemo.R;
import com.zly.app.manager.MenuItem;
import com.zly.library.swipebacklayout.ReturnActivity;

public class BaseActivity extends ReturnActivity {
    private View viewLayout;
    public FrameLayout flMain;
    public RelativeLayout actionBar;
    public LinearLayout llLeft, llCenter, llRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewLayout = View.inflate(this, R.layout.activity_base, null);
        actionBar = (RelativeLayout) viewLayout.findViewById(R.id.main_actionbar);
        llLeft = (LinearLayout) viewLayout.findViewById(R.id.linearLayout_left);
        llCenter = (LinearLayout) viewLayout.findViewById(R.id.linearLayout_center);
        llRight = (LinearLayout) viewLayout.findViewById(R.id.linearLayout_right);
        flMain = (FrameLayout) viewLayout.findViewById(R.id.frameLayout_main);
        //设置返回
        addLeftItem(new MenuItem(this)
                        .show(MenuItem.ICON_LEFT, MenuItem.ITEM_ICON)
                        .setIcon(R.mipmap.back)
        );
        //设置标题
        addCenterItem(new MenuItem(this)
                        .show(MenuItem.ICON_TOP, MenuItem.ITEM_TITLE)
                        .setTitle("广州大学")
        );

        //右边
        addRightItem(new MenuItem(this)
                        .show(MenuItem.ICON_RIGHT, MenuItem.ITEM_BOTH)
                        .setIcon(R.mipmap.contact)
        );
    }

    @Override
    public void setContentView(int viewId) {
        View view = View.inflate(this, viewId, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        flMain.addView(view);
        super.setContentView(viewLayout);
    }

    /**
     * 设置没有标题栏
     */
    public void setNoActionBar() {
        actionBar.setVisibility(View.GONE);
    }

    /**
     * 添加一个左边的item
     *
     * @param menuItem
     */
    public void addLeftItem(MenuItem menuItem) {
        llLeft.addView(menuItem.getView());
        llLeft.setVisibility(View.VISIBLE);
    }

    /**
     * 移除左边所有item
     */
    public void clearLeftItem() {
        llLeft.removeAllViews();
        llLeft.setVisibility(View.GONE);
    }

    /**
     * 添加一个中间的item
     *
     * @param menuItem
     */
    public void addCenterItem(MenuItem menuItem) {
        llCenter.addView(menuItem.getView());
        llCenter.setVisibility(View.VISIBLE);
    }

    /**
     * 移除中间所有item
     */
    public void clearCenterItem() {
        llCenter.removeAllViews();
        llCenter.setVisibility(View.GONE);
    }

    /**
     * 添加一个右边的item
     *
     * @param menuItem
     */
    public void addRightItem(MenuItem menuItem) {
        llRight.addView(menuItem.getView());
        llRight.setVisibility(View.VISIBLE);
    }

    /**
     * 移除右边所有item
     */
    public void clearRightItem() {
        llRight.removeAllViews();
        llRight.setVisibility(View.GONE);
    }


}
