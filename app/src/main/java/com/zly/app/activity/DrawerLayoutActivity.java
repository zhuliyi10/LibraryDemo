package com.zly.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.zhuliyi.pulltorefreshdemo.R;

public class DrawerLayoutActivity extends Activity {


    private DrawerLayout dlMain;
    private FrameLayout flMenu;
    private Button btDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        dlMain= (DrawerLayout) findViewById(R.id.drawer_main);
        flMenu= (FrameLayout) findViewById(R.id.frame_menu);
        dlMain.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {

            }

            @Override
            public void onDrawerClosed(View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        btDrawer= (Button) findViewById(R.id.button_drawer);
        btDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlMain.openDrawer(flMenu);
            }
        });
    }


}
