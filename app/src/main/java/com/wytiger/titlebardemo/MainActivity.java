package com.wytiger.titlebardemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wytiger.titlebardemo.basetitle.TitleBaseActivity;

public class MainActivity extends TitleBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected boolean handleLeftClick() {
        Log.d(TAG, "onTitleLeftClick");
        return true;
    }

    @Override
    protected void setTitleBar() {
        titlebar.setLeftText("定位");
        titlebar.setTitleText("主页");
        titlebar.setRightImage(R.drawable.menu);
        titlebar.setRightText("菜单");
    }

    public void onTextClick(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
