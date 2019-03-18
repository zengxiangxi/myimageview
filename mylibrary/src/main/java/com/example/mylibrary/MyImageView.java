package com.example.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import com.example.mylibrary.R.styleable;
import android.view.ViewOutlineProvider;

/**
 * Create By zengxiangxi on 2019/3/18.
 */

public class MyImageView extends AppCompatImageView {
    private int imageVIewRadius = 30;

    public MyImageView(Context context) {
        super(context);
        initView();
    }

    public MyImageView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typeArray = context.obtainStyledAttributes(attrs,styleable.MyImageView,defStyleAttr,0);
        imageVIewRadius = typeArray.getInteger(styleable.MyImageView_radius,imageVIewRadius);
        typeArray.recycle();
        initView();
    }

    private void initView() {
        setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), imageVIewRadius);
            }
        });
        setClipToOutline(true);
    }


}
