package com.flimbis.frameview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
 *
 * @author Prince
 * */
public class FrameView extends FrameLayout {
    private String frameView_shape;
    private int frameView_stroke_color;

    // used programmatically
    public FrameView(@NonNull Context context) {
        super(context);
    }

    // used in xml layout
    public FrameView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        // Obtain a typed array of attributes
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FrameView, 0, 0);
        frameView_shape = a.getString(R.styleable.FrameView_frameView_shape);
        frameView_stroke_color = a.getColor(R.styleable.FrameView_frameView_strokeColor, Color.BLACK);

        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
