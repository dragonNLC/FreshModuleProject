package com.dragon.test.vb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLinearLayout extends LinearLayout {

    public MyLinearLayout(Context context) {
        this(context, null);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init13();
    }

    private void init1() {
        inflate(getContext(), R.layout.merge_layout, this);
    }

    private void init2() {
        LayoutInflater.from(getContext()).inflate(R.layout.merge_layout, this, true);
    }

    private void init3() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.merge_layout, this, false);
        addView(view);
    }

    private void init13() {
        com.dragon.test.vb.databinding.MergeLayoutBinding viewBinding = com.dragon.test.vb.databinding.MergeLayoutBinding.inflate(LayoutInflater.from(getContext()), this);
        //addView(viewBinding.getRoot());
    }

}
