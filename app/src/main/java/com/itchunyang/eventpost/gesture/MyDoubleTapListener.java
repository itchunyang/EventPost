package com.itchunyang.eventpost.gesture;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by luchunyang on 2016/12/10.
 */

public class MyDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    public static final String TAG = "OnDoubleTapListener";

    //单击事件。用来判定该次点击是SingleTap而不是DoubleTap
    //如果连续点击两次就是DoubleTap手势，如果只点击一次，系统等待一段时间后没有收到第二次点击则判定该次点击为SingleTap而不是DoubleTap
    //然后触发SingleTapConfirmed事件。触发顺序是：OnDown->onSingleTapUp->onSingleTapConfirmed
    //onSingleTapUp，只要手抬起就会执行，而对于onSingleTapConfirmed来说，如果双击的话，则onSingleTapConfirmed不会执行。
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i(TAG, "onSingleTapConfirmed: "+motionEventString(e));
        return false;
    }

    //双击事件
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i(TAG, "onDoubleTap: "+motionEventString(e));
        return false;
    }

    //双击间隔中发生的动作。指触发onDoubleTap以后，在双击之间发生的其它动作，包含down、up和move事件
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.i(TAG, "onDoubleTapEvent: "+motionEventString(e));
        return false;
    }

    String motionEventString(MotionEvent e) {

        if (e.getAction() == MotionEvent.ACTION_DOWN)
            return "ACTION_DOWN";
        else if (e.getAction() == MotionEvent.ACTION_UP)
            return "ACTION_UP";
        else if (e.getAction() == MotionEvent.ACTION_MOVE)
            return "ACTION_MOVE";

        return "";
    }
}
