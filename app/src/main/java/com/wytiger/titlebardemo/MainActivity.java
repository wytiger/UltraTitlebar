package com.wytiger.titlebardemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends TitleBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected boolean handleLeftClick() {
        Log.d(TAG, "onLeftClick");
        return true;
    }

    @Override
    protected void initTitleBar() {
        titlebar.setLeftText("定位");
        titlebar.setTitleText("主页");
        titlebar.setRightText("");
    }

    public void onTextClick(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
