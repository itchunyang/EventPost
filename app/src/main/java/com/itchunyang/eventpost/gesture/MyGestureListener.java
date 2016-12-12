package com.itchunyang.eventpost.gesture;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by luchunyang on 2016/12/10.
 */

public class MyGestureListener implements GestureDetector.OnGestureListener {
    public static final String TAG = "OnGestureListener";
    final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITX = 200;

    /**
     * 用户轻触触摸屏，由1个MotionEvent ACTION_DOWN触发
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(TAG, "onDown: ");
        return false;
    }

    /**
     * 用户轻触触摸屏，尚未松开或拖动，由一个1个MotionEvent ACTION_DOWN触发
     * 如果在按下的瞬间(没有松开或者是拖动)的时候onShowPress就会执行.
     * 如果拖动了，就不执行onShowPress
     * @param e
     */
    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(TAG, "onShowPress: " + motionEventString(e));
    }

    /**
     * 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
     * 一次点击up事件；在touch down后又没有滑动（onScroll），又没有长按（onLongPress），然后Touchup时触发
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(TAG, "onSingleTapUp: " + motionEventString(e));
        return false;
    }

    /**
     * 用户按下触摸屏，并拖动，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
     * @param e1 手势起点的移动事件
     * @param e2 当前手势点的移动事件
     * @param distanceX 代表两次滑动事件滑动x轴上面的距离
     * @param distanceY 代表两次滑动事件滑动Y轴上面的距离
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i(TAG, "onScroll: e1=" + motionEventString(e1) + " e2=" + motionEventString(e2) + " distanceX=" + distanceX + " distanceY=" + distanceY);
        return false;
    }

    /**
     * Touch了不移动一直Touch down时触发
     * @param e
     */
    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(TAG, "onLongPress: "+motionEventString(e));
    }

    /**
     * 用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
     * @param e1 手势起点的移动事件
     * @param e2 当前手势点的移动事件
     * @param velocityX X轴上的移动速度，像素/秒
     * @param velocityY Y轴上的移动速度，像素/秒
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TAG, "onFling: e1=" + motionEventString(e1) + " e2=" + motionEventString(e2) + " velocityX=" + velocityX + " velocityY=" + velocityY);

        //首先，先说一下实现的功能：当用户向左滑动距离超过100px，且滑动速度超过100 px/s时,即判断为向左滑动;向右同理
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITX) {
            // Fling left
            Log.i(TAG, ">>>>>>Fling left");
        } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITX) {
            // Fling right
            Log.i(TAG, ">>>>>>Fling right");
        }
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
