package com.example.sudoku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;

public class SquareButton extends Button {

    public SquareButton(Context context) {
        this(context, null);
    }

    public SquareButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundResource(R.drawable.bg_button);
        setGravity(Gravity.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}