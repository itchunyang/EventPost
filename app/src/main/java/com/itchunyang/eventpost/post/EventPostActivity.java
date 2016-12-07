package com.itchunyang.eventpost.post;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.itchunyang.eventpost.R;

/**
 * 布局:
 *  activity--->MyFrameLayout--->MyLinearLayout--->MyView
 *
 *
 *  点击MyFrameLayout
 *      1)action_down
 *          Activity: dispatchTouchEven
 *          MyFrameLayout: dispatchTouchEvent
 *          MyFrameLayout: onInterceptTouchEvent
 *          MyFrameLayout: onTouchEvent
 *          Activity: onTouchEvent
 *
 *      2)action_up
 *          Activity: dispatchTouchEvent
 *          Activity: onTouchEvent
 *
 *
 *  点击MyLinearLayout
 *      1)action_down
 *          Activity: dispatchTouchEvent
 *          MyFrameLayout: dispatchTouchEven
 *          MyFrameLayout: onInterceptTouchEvent
 *          MyLinearLayout: dispatchTouchEvent
 *          MyLinearLayout: onInterceptTouchEvent
 *          MyLinearLayout: onTouchEvent
 *          MyFrameLayout: onTouchEvent
 *          Activity: onTouchEvent
 *          Activity: dispatchTouchEvent
 *          Activity: onTouchEvent
 *
 *      2)action_up
 *          Activity: dispatchTouchEvent
 *          Activity: onTouchEvent
 *
 *
 *  点击MyView
 *      1)action_down
 *          Activity: dispatchTouchEvent
 *          MyFrameLayout: dispatchTouchEvent
 *          MyFrameLayout: onInterceptTouchEvent
 *          MyLinearLayout: dispatchTouchEvent
 *          MyLinearLayout: onInterceptTouchEvent
 *          MyView: dispatchTouchEvent
 *          MyView: onTouchEvent
 *          MyLinearLayout: onTouchEvent
 *          MyFrameLayout: onTouchEvent
 *          Activity: onTouchEvent
 *
 *      2)action_up
 *          Activity: dispatchTouchEvent
 *          Activity: onTouchEvent
 *
 *
 *                                   ViewGroup      View    Activity
 *  dispatchTouchEvent    事件分发      Yes           Yes       Yes
 *  onInterceptTouchEvent 事件拦截      Yes           No        No
 *  onTouchEvent          事件响应      Yes           Yes       Yes
 */

public class EventPostActivity extends Activity {

    public static final String TAG = "Activity";
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_post);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("button onclick");
            }
        });
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("button onTouch");
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onUserInteraction() {
//        Log.i(TAG, "onUserInteraction: ");
        super.onUserInteraction();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
    }
}
