package com.wytiger.titlebardemo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Author: wytiger
 * Time: 2017/05/24
 * Desc: 业务无关的Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity implements Titlebar.OnLeftClickListener{
    protected String TAG = "";
    protected Titlebar titlebar;
    protected FrameLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(R.layout.activity_base);
        TAG = getClass().getSimpleName();
    }


    /**
     * 重写setContentView
     * @param layoutResID
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //BaseActivity调用setContentView方法时进入
        if (R.layout.activity_base == layoutResID) {
            super.setContentView(R.layout.activity_base);
            //标题
            titlebar = (Titlebar) findViewById(R.id.titlebar);
            initTitleBar();
            titlebar.setOnLeftClickListener(this);
            //内容
            contentView = (FrameLayout) findViewById(R.id.layout_content);
            contentView.removeAllViews();
        } else {
            //BaseActivity子类调用setContentView方法时进入
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView);

            initView();
            loadDataAsync();
        }
    }

    protected abstract void initTitleBar();

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

    /**
     * 点击左边,默认关闭本页面.
     * 若不希望关闭本页面,子类可重写此方法并且不要调用super
     */
    @Override
    public void onLeftClick() {
        finish();
        Log.d(TAG,"onLeftClick finish");
    }
}
