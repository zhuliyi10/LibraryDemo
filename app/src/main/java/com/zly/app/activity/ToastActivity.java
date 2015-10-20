package com.zly.app.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
