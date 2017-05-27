package com.wytiger.titlebardemo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class BaseActivity extends AppCompatActivity {
    protected FrameLayout contentView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //BaseActivity调用setContentView方法时进入
        if (R.layout.activity_base == layoutResID) {
            super.setContentView(R.layout.activity_base);
            contentView = (FrameLayout) findViewById(R.id.layout_content);
            contentView.removeAllViews();
        } else {
            //BaseActivity子类调用setContentView方法时进入
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView);

            initData();
            initView();
            loadDataAsync();
        }
    }

    /**
     * 初始化数据, 在子类的initView()之前被调用
     */
    protected void initData() {
        //Override by subclass
    }

    /**
     * 初始化视图,在子类的initData()之后被调用
     */
    protected void initView() {
        //Override by subclass
    }

    /**
     * 耗时任务获取数据
     */
    protected void loadDataAsync() {
        //Override by subclass
    }
}
