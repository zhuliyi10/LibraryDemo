package com.zly.app.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.zhuliyi.pulltorefreshdemo.R;

public class PopupWindowActivity extends Activity {

    private PopupWindow popupWindow;
    private Button btsShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        btsShow= (Button) findViewById(R.id.button_showPopup);
        btsShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(R.layout.popup_panel, null);
                popupWindow=new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                // 使其聚集
                popupWindow.setFocusable(true);
                //设置SelectPicPopupWindow弹出窗体动画效果
                popupWindow.setAnimationStyle(R.style.AnimBottom);
                // 设置允许在外点击消失
                popupWindow.setOutsideTouchable(true);
                // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAtLocation(PopupWindowActivity.this.findViewById(R.id.button_showPopup), Gravity.BOTTOM, 0, 0);
            }
        });


    }

}
