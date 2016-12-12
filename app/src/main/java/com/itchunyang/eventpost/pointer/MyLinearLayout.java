package com.itchunyang.eventpost.pointer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by luchunyang on 2016/12/10.
 * https://my.oschina.net/banxi/blog/56421 博客
 */

public class MyLinearLayout extends LinearLayout {

    /**
     * 多点触摸的2个重要概念是指针索引和指针ID
     * 指针索引：Android把多点触摸时的一个手指抽象成一个“指针”，这个指针有其索引，从0开始。
     * 这个索引分配给对应的手指之后，值是会随着手指数量的增减而改变的。如果同时有2根手指在屏幕上，
     * 第一根手指指针索引为0，第二根为1，如果第一根手指离开屏幕，第二根的指针索引变为0，因为此刻屏幕上只有1根手指
     *
     * 指针ID：唯一标识一根手指的id，相当于表的主键，这个值和索引不一样，是不会变的。
     */
    public static final String TAG = "MultiplePointer";

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //过滤一下移动信息,否则不好看
        if(event.getAction() == MotionEvent.ACTION_MOVE)
            return true;


        /**
         * 当单点触摸时,是一样的
         * 多点触控时:
         * mAction的低8位即0x00到0xff用来表示动作的类型信息。
         * 例如：MotionEvent#ACTION_DOWN的值是 0,即0x00
         *      MotionEvent#ACTION_UP的值是 1，即0x01。
         *
         * mAction的第二个8位(8-15位)即0x00到0xff用来表示触控点索引信息
         *
         * ACTION_MASK             = 0xff;
         * ACTION_POINTER_INDEX_MASK  = 0xff00
         */

        Log.i(TAG, "-------------------------------------------------");
        Log.i(TAG, "当前一共触点个数="+event.getPointerCount());

        //返回action,包含动作类型和触点索引信息
        Log.i(TAG, "Action="+event.getAction());

        //返回经过掩码的action,没有触控点索引信息
        Log.i(TAG, "ActionMasked="+event.getActionMasked());

        Log.i(TAG, "ActionIndex=" + event.getActionIndex());

        int actionIndex = event.getActionIndex();
        Log.i(TAG, "x="+event.getX(actionIndex)+" y="+ event.getY(actionIndex));
        Log.i(TAG, "触控点ID="+event.getPointerId(actionIndex));
        Log.i(TAG, "-------------------------------------------------");

        return true;
    }

}
