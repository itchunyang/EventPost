package com.itchunyang.eventpost.post;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by luchunyang on 2016/12/7.
 */

public class MyLinearLayout extends LinearLayout {
    public static final String TAG = "MyLinearLayout";

    
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     *
     * @return
     * return true
     *      [ACTION_DOWN]
     *      Activity: dispatchTouchEvent
     *      MyFrameLayout: dispatchTouchEvent
     *      MyFrameLayout: onInterceptTouchEvent
     *      MyLinearLayout: dispatchTouchEvent
     *
     *      [ACTION_UP]
     *      Activity: dispatchTouchEvent
     *      MyFrameLayout: dispatchTouchEvent
     *      MyFrameLayout: onInterceptTouchEvent
     *      MyLinearLayout: dispatchTouchEvent
     *
     *  return false
     *      [ACTION_DOWN]
     *      Activity: dispatchTouchEvent
     *      MyFrameLayout: dispatchTouchEvent
     *      MyFrameLayout: onInterceptTouchEvent
     *      MyLinearLayout: dispatchTouchEvent
     *      MyFrameLayout: onTouchEvent
     *      Activity: onTouchEvent
     *
     *      [ACTION_UP]
     *      Activity: dispatchTouchEvent
     *      Activity: onTouchEvent
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: ");
//        return super.dispatchTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, "onInterceptTouchEvent: ");
        return super.onInterceptTouchEvent(ev);// = retrun false
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);//或者return false   事件回传给父组件
//        return true; //消费事件不回传，自己消费掉
    }
}
