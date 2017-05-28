package com.wytiger.titlebardemo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;


/**
 * Author: wytiger
 * Time: 2017/05/24
 * Desc: 业务无关的Activity基类
 */
public abstract class TitleBaseActivity extends AppCompatActivity
        implements Titlebar.OnLeftClickListener,Titlebar.OnRightClickListener{
    protected String TAG = "TitleBaseActivity";
    protected Titlebar titlebar;
    protected FrameLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        initData();
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏,5.0之后无效,需要设置主题无标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
        setContentView(R.layout.activity_base);
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
            titlebar.setOnLeftClickListener(this);
            titlebar.setOnRightClickListener(this);
            initTitleBar();
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

    /**
     * 子类必须重写,以设置标题
     */
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
     * 若不希望关闭本页面,子类可重写handleLeftClick()方法处理自己的业务并返回true或者直接设置左侧点击事件.
     */
    @Override
    public void onLeftClick() {
        //子类没有处理,则结束本页面
        if (!handleLeftClick()){
            finish();
            Log.d(TAG,"onLeftClick finish");
        }
    }

    @Override
    public void onRightClick() {
        //do nothing
    }

    /**
     * 点击左边,默认关闭本页面.
     * 若不希望关闭本页面,子类可重写此方法处理自己的业务并返回true
     */
    protected boolean handleLeftClick(){

        return false;
    }
}
