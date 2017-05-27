package com.wytiger.titlebardemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * http://blog.csdn.net/ydxlt/article/details/50805822
 * Created by lt on 2016/3/4.
 */
public class Titlebar extends RelativeLayout {
    private static final String TAG = "Titlebar";

    private String mLeftText;
    private int mLeftTextColor;
    private float mLeftSize;
    private Drawable mLeftImage;

    private String mTitleText;
    private int mTitleTextColor;
    private float mTitleSize;

    private String mRightText;
    private int mRightTextColor;
    private float mRightSize;
    private Drawable mRightImage;

    private TextView mLeftTextView;
    private ImageView mLeftImageView;
    private TextView titleTextView;
    private TextView mRightTextView;
    private ImageView mRightImageView;

    public Titlebar(Context context) {
        this(context, null);
    }

    public Titlebar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Titlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttribute(context, attrs);
        initView(context);
    }


    private void initAttribute(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Titlebar);
        //左
        mLeftText = typedArray.getString(R.styleable.Titlebar_leftText);
        mLeftTextColor = typedArray.getColor(R.styleable.Titlebar_leftTextColor, Color.GRAY);
        mLeftSize = typedArray.getDimension(R.styleable.Titlebar_leftTextSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        mLeftImage = typedArray.getDrawable(R.styleable.Titlebar_leftButtonImage);
        //中
        mTitleText = typedArray.getString(R.styleable.Titlebar_titleText);
        mTitleTextColor = typedArray.getColor(R.styleable.Titlebar_titleColor, Color.GRAY);
        mTitleSize = typedArray.getDimension(R.styleable.Titlebar_titleSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        //右
        mRightText = typedArray.getString(R.styleable.Titlebar_rightText);
        mRightTextColor = typedArray.getColor(R.styleable.Titlebar_rightTextColor, Color.GRAY);
        mRightSize = typedArray.getDimension(R.styleable.Titlebar_rightTextSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        mRightImage = typedArray.getDrawable(R.styleable.Titlebar_rightImage);

        typedArray.recycle();
    }

    public void setLeftText(String leftText){
        mLeftText = leftText;
    }

    public void setLeftTextColor(int leftTextColor){
        mLeftTextColor = leftTextColor;
    }

    public void setLeftTextSize(int leftTextSize){
        mLeftSize = leftTextSize;
    }

    public void setLeftImage(int leftImage){
        mLeftImage = getContext().getResources().getDrawable(leftImage);
    }

    public void setTitleText(String titleText){
        mTitleText = titleText;
    }

    public void setTitleTextColor(int titleTextColor){
        mTitleTextColor = titleTextColor;
    }

    public void setTitleTextSize(int titleTextSize){
        mTitleSize = titleTextSize;
    }

    public void setRightText(String rightText){
        mRightText = rightText;
    }

    public void setRightTextColor(int rightTextColor){
        mRightTextColor = rightTextColor;
    }

    public void setRightTextSize(int rightTextSIze){
        mRightSize = rightTextSIze;
    }

    public void setRightImage(int rightImage){
        mRightImage = getContext().getResources().getDrawable(rightImage);
    }

    private void initView(Context context) {
        if (mLeftImage == null & mLeftText != null) {
            // 当用户没有设置左侧按钮图片并设置了左侧的按钮文本属性时--添加左侧文本按钮
            mLeftTextView = new TextView(context);
            mLeftTextView.setText(mLeftText);
            mLeftTextView.setTextColor(mLeftTextColor);
            mLeftTextView.setTextSize(mLeftSize);
            LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            leftParams.addRule(RelativeLayout.CENTER_VERTICAL);
            addView(mLeftTextView, leftParams);
        } else if (mLeftImage != null) {
            // 添加左侧图片按钮
            LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            leftParams.addRule(RelativeLayout.CENTER_VERTICAL);
            mLeftImageView = new ImageView(context);
            mLeftImageView.setImageDrawable(mLeftImage);
            addView(mLeftImageView, leftParams);
        } else {
            Log.w(TAG, "titlebar left is null");
        }

        if (mTitleText != null) {
            // 添加中间标题
            titleTextView = new TextView(context);
            titleTextView.setText(mTitleText);
            titleTextView.setTextColor(mTitleTextColor);
            titleTextView.setTextSize(mTitleSize);
            LayoutParams titleTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            titleTextViewParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            addView(titleTextView, titleTextViewParams);
        } else {
            Log.w(TAG, "titlebar center is null");
        }

        if (mRightImage == null & mRightText != null) {
            // 当用户没有设置右侧按钮图片并设置了左侧的按钮文本属性时--添加右侧文本按钮
            mRightTextView = new TextView(context);
            mRightTextView.setText(mRightText);
            mRightTextView.setTextColor(mRightTextColor);
            mRightTextView.setTextSize(mRightSize);
            LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
            addView(mRightTextView, rightParams);
        } else if (mRightImage != null) {
            // 添加右侧图片按钮
            LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
            mRightImageView = new ImageView(context);
            mRightImageView.setImageDrawable(mRightImage);
            addView(mRightImageView, rightParams);
        } else {
            Log.w(TAG, "titlebar right is null");
        }
    }



    /**
     * 在button点击事件接口
     */
    public interface OnButtonClickListener {
        void onLeftClick();

        void onRightClick();
    }

    public interface OnLeftClickListener {
        void onLeftClick();
    }

    public interface OnRightClickListener {
        void onRightClick();
    }

    /**
     * 设置点击事件
     *
     * @param onButtonClickListener
     */
    public void setOnButtonClickListener(final OnButtonClickListener onButtonClickListener) {
        if (onButtonClickListener != null) {
            if (mLeftTextView != null) {
                mLeftTextView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onLeftClick();
                    }
                });
            }
            if (mLeftImageView != null) {
                mLeftImageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onLeftClick();
                    }
                });
            }
            if (mRightTextView != null) {
                mRightTextView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onRightClick();
                    }
                });
            }
            if (mRightImageView != null) {
                mRightImageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onRightClick();
                    }
                });
            }
        }
    }

    public void setOnLeftClickListener(final OnLeftClickListener onButtonClickListener) {
        if (onButtonClickListener != null) {
            if (mLeftTextView != null) {
                mLeftTextView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onLeftClick();
                    }
                });
            }
            if (mLeftImageView != null) {
                mLeftImageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onLeftClick();
                    }
                });
            }
        }
    }

    public void setOnRightClickListener(final OnRightClickListener onButtonClickListener) {
        if (onButtonClickListener != null) {
            if (mRightTextView != null) {
                mRightTextView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onRightClick();
                    }
                });
            }
            if (mRightImageView != null) {
                mRightImageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClickListener.onRightClick();
                    }
                });
            }
        }
    }
}
