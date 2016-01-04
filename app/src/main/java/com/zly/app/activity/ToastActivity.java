package com.zly.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhuliyi.pulltorefreshdemo.R;
import com.zly.app.manager.ToastManager;

public class ToastActivity extends BaseActivity {

    private Button btToast;
    private int time=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        btToast= (Button) findViewById(R.id.button_toast);
        btToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastManager.showToast(ToastActivity.this, "你点击了" + time++ + "次！", Toast.LENGTH_LONG);
            }
        });

    }


}
