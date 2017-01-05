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


    /**
     *
     * @return
     *      true,表示事件被自己消费了，不会传递给onInterceptTouchEvent()、onTouchEvent（）及子View，后续的事件也会传给dispatchTouchEvent（）
     *
     * ACTION_DOWN:
     * 01-04 12:39:31.035 27344-27344/com.itchunyang.eventpost I/Activity: dispatchTouchEvent:
     * 01-04 12:39:31.035 27344-27344/com.itchunyang.eventpost I/MyFrameLayout: dispatchTouchEvent:
     * 01-04 12:39:31.035 27344-27344/com.itchunyang.eventpost I/MyFrameLayout: onInterceptTouchEvent:
     * 01-04 12:39:31.035 27344-27344/com.itchunyang.eventpost I/MyLinearLayout: dispatchTouchEvent:
     *
     * ACTION_UP:
     * 01-04 12:39:31.859 27344-27344/com.itchunyang.eventpost I/Activity: dispatchTouchEvent:
     * 01-04 12:39:31.859 27344-27344/com.itchunyang.eventpost I/MyFrameLayout: dispatchTouchEvent:
     * 01-04 12:39:31.859 27344-27344/com.itchunyang.eventpost I/MyFrameLayout: onInterceptTouchEvent:
     * 01-04 12:39:31.859 27344-27344/com.itchunyang.eventpost I/MyLinearLayout: dispatchTouchEvent:
     *
     *
     *
     *      false,表示事件自己没有消费，不会传递给onInterceptTouchEvent()、onTouchEvent（）及子View，会向上消费该事件
     *
     * ACTION_DOWN:
     * 1-04 12:45:37.563 31585-31585/com.itchunyang.eventpost I/Activity: dispatchTouchEvent:
     * 01-04 12:45:37.563 31585-31585/com.itchunyang.eventpost I/MyFrameLayout: dispatchTouchEvent:
     * 01-04 12:45:37.563 31585-31585/com.itchunyang.eventpost I/MyFrameLayout: onInterceptTouchEvent:
     * 01-04 12:45:37.563 31585-31585/com.itchunyang.eventpost I/MyLinearLayout: dispatchTouchEvent:
     * 01-04 12:45:37.563 31585-31585/com.itchunyang.eventpost I/MyFrameLayout: onTouchEvent:
     * 01-04 12:45:37.563 31585-31585/com.itchunyang.eventpost I/Activity: onTouchEvent:
     *
     * ACTION_UP:
     * 01-04 12:45:38.175 31585-31585/com.itchunyang.eventpost I/Activity: dispatchTouchEvent:
     * 01-04 12:45:38.179 31585-31585/com.itchunyang.eventpost I/Activity: onTouchEvent:
     *
     *
     * 只要dispatchTouchEvent()返回的不是super.dispatchTouchEvent(ev)，那么就不会把事件分发给自己活着子View。
     *
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: ");
//        return super.dispatchTouchEvent(ev);
        return false;
    }

    /**
     *
     * @return
     *      true,拦截该事件，不再传递给子View了，并且消费该事件onTouchEvent，如果消费不了，则上级消费
     *      false,不拦截该事件 和super.onInterceptTouchEvent(ev)等价!
     */
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
