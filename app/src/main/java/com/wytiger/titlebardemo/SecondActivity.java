package com.wytiger.titlebardemo;

import android.os.Bundle;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    public void onLeftClick() {
        super.onLeftClick();
    }
}
