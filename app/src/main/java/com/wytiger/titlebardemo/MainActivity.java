package com.wytiger.titlebardemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onLeftClick() {
//        super.onLeftClick();
        Log.d(TAG,"onLeftClick");
    }

    @Override
    protected void initTitleBar() {
        titlebar.setOnButtonClickListener(new Titlebar.OnButtonClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this,"左侧按钮被点击了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick() {
                Toast.makeText(MainActivity.this,"右侧按钮被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onTextClick(View v){
        startActivity(new Intent(this,SecondActivity.class));
    }
}
