package com.itchunyang.eventpost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.itchunyang.eventpost.post.EventPostActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eventPost(View view) {
        startActivity(new Intent(this, EventPostActivity.class));
    }


}
