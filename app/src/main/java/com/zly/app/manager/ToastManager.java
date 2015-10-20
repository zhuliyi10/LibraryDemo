package com.zly.app.manager;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhuliyi on 2015/10/16.
 */
public class ToastManager {
    public static Toast mToast=null;
    public static void showToast(Context context,String text,int duration){
        if(mToast==null){
            mToast=Toast.makeText(context,text,duration);
        }else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}
