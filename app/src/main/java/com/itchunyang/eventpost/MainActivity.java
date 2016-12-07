package com.itchunyang.eventpost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "EventPost";
    private Button btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = (Button) findViewById(R.id.btn01);
        btn01.setOnClickListener(new BtnClickListener());
        btn01.setOnTouchListener(new BtnOnTouchListener());
    }

    class BtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.i(TAG, "onClick: ");
        }
    }

    class BtnOnTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.i(TAG, "onTouch: action="+event.getAction());
            return false;
        }
    }
}
