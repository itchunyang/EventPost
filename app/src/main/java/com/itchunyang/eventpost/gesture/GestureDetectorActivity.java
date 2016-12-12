package com.itchunyang.eventpost.gesture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.itchunyang.eventpost.R;

public class GestureDetectorActivity extends AppCompatActivity {

    private ImageView iv;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);

        iv = (ImageView) findViewById(R.id.iv);
        iv.setLongClickable(true);

        gestureDetector = new GestureDetector(this,new MyGestureListener());
        gestureDetector.setOnDoubleTapListener(new MyDoubleTapListener());
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
    }


}
