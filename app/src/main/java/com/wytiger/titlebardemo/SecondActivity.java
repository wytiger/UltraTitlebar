package com.wytiger.titlebardemo;

import android.os.Bundle;

public class SecondActivity extends TitleBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void initTitleBar() {
        titlebar.setTitleText("第二页");
    }

}
