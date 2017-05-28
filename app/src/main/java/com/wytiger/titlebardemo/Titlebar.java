package com.wytiger.titlebardemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 终结自定义标题栏
 * Created by wytiger on 2017/05/24.
 * https://github.com/wytiger/TitlebarDemo
 */
public class Titlebar extends RelativeLayout {
    private static final String TAG = "Titlebar";
    private Context context;

    private String mLeftText;
    private int mLeftTextColor;
    private float mLeftTextSize;
    private Drawable mLeftImage;

    private String mTitleText;
    private int mTitleTextColor;
    private float mTitleSize;

    private String mRightText;
    private int mRightTextColor;
    private float mRightTextSize;
    private Drawable mRightImage;

    private ImageView leftImageView;
    private TextView leftTextView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private TextView rightTextView;
    LinearLayout leftLayout;
    LinearLayout rightLayout;

    public Titlebar(Context context) {
        this(context, null);
    }

    public Titlebar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Titlebar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initAttribute(context, attrs);
        initView(context);
    }


    private void initAttribute(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Titlebar);
        //左
        mLeftImage = typedArray.getDrawable(R.styleable.Titlebar_leftImage);
        mLeftText = typedArray.getString(R.styleable.Titlebar_leftText);
        mLeftTextColor = typedArray.getColor(R.styleable.Titlebar_leftTextColor, Color.GRAY);
        mLeftTextSize = typedArray.getDimension(R.styleable.Titlebar_leftTextSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        //中
        mTitleText = typedArray.getString(R.styleable.Titlebar_titleText);
        mTitleTextColor = typedArray.getColor(R.styleable.Titlebar_titleColor, Color.GRAY);
        mTitleSize = typedArray.getDimension(R.styleable.Titlebar_titleSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        //右
        mRightImage = typedArray.getDrawable(R.styleable.Titlebar_rightImage);
        mRightText = typedArray.getString(R.styleable.Titlebar_rightText);
        mRightTextColor = typedArray.getColor(R.styleable.Titlebar_rightTextColor, Color.GRAY);
        mRightTextSize = typedArray.getDimension(R.styleable.Titlebar_rightTextSize, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));

        typedArray.recycle();
    }


    private void initView(Context context) {
        //左侧按钮
        leftLayout = new LinearLayout(context);
        LinearLayout.LayoutParams leftLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        leftLayoutParams.gravity = Gravity.CENTER;
        RelativeLayout.LayoutParams leftRelativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        leftRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        leftRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(leftLayout, leftRelativeLayoutParams);

        leftImageView = new ImageView(context);
        leftImageView.setImageDrawable(mLeftImage);
        leftLayout.addView(leftImageView, leftLayoutParams);
        leftTextView = new TextView(context);
        leftTextView.setText(mLeftText);
        leftTextView.setTextColor(mLeftTextColor);
        leftTextView.setTextSize(mLeftTextSize);
        leftLayout.addView(leftTextView, leftLayoutParams);
        setLeftVisible();

        //中间标题
        titleTextView = new TextView(context);
        titleTextView.setText(mTitleText);
        titleTextView.setTextColor(mTitleTextColor);
        titleTextView.setTextSize(mTitleSize);
        LayoutParams titleTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleTextViewParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(titleTextView, titleTextViewParams);


        //右侧按钮
        rightLayout = new LinearLayout(context);
        LinearLayout.LayoutParams rightLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rightLayoutParams.gravity = Gravity.CENTER;
        RelativeLayout.LayoutParams rightRelativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rightRelativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightRelativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(rightLayout, rightRelativeLayoutParams);

        rightImageView = new ImageView(context);
        rightImageView.setImageDrawable(mRightImage);
        rightLayout.addView(rightImageView, rightLayoutParams);
        rightTextView = new TextView(context);
        rightTextView.setText(mRightText);
        rightTextView.setTextColor(mRightTextColor);
        rightTextView.setTextSize(mRightTextSize);
        rightLayout.addView(rightTextView, rightLayoutParams);
        setRightVisible();
    }

    private void setLeftVisible() {
        if (mLeftImage != null) {
            leftImageView.setVisibility(View.VISIBLE);
        } else {
            leftImageView.setVisibility(View.GONE);
        }

        if (mLeftText != null) {
            leftTextView.setVisibility(View.VISIBLE);
        } else {
            leftTextView.setVisibility(View.GONE);
        }
    }

    private void setRightVisible() {
        if (mRightImage != null) {
            rightImageView.setVisibility(View.VISIBLE);
        } else {
            rightImageView.setVisibility(View.GONE);
        }

        if (mRightText != null) {
            rightTextView.setVisibility(View.VISIBLE);
        } else {
            rightTextView.setVisibility(View.GONE);
        }
    }


    public void setLeftText(String leftText) {
        mLeftText = leftText;
        leftTextView.setText(mLeftText);
        setLeftVisible();
    }

    public void setLeftTextColor(int leftTextColor) {
        mLeftTextColor = leftTextColor;
    }

    public void setLeftTextSize(int leftTextSize) {
        mLeftTextSize = leftTextSize;
    }

    public void setLeftImage(int leftImage) {
        mLeftImage = getContext().getResources().getDrawable(leftImage);
        setLeftVisible();
    }

    public void setTitleText(String titleText) {
        mTitleText = titleText;
        titleTextView.setText(mTitleText);
    }

    public void setTitleTextColor(int titleTextColor) {
        mTitleTextColor = titleTextColor;
    }

    public void setTitleTextSize(int titleTextSize) {
        mTitleSize = titleTextSize;
    }

    public void setRightText(String rightText) {
        mRightText = rightText;
        rightTextView.setText(mRightText);
        setRightVisible();
    }

    public void setRightTextColor(int rightTextColor) {
        mRightTextColor = rightTextColor;
    }

    public void setRightTextSize(int rightTextSIze) {
        mRightTextSize = rightTextSIze;
    }

    public void setRightImage(int rightImage) {
        mRightImage = getContext().getResources().getDrawable(rightImage);
    }

    public interface OnLeftClickListener {
        void onLeftClick();
    }

    public interface OnRightClickListener {
        void onRightClick();
    }


    public void setOnLeftClickListener(final OnLeftClickListener leftClickListener) {
        leftLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                leftClickListener.onLeftClick();
            }
        });
    }

    public void setOnRightClickListener(final OnRightClickListener rightClickListener) {
        rightLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightClickListener.onRightClick();
            }
        });
    }
}
