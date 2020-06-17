package com.flimbis.frameview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
 *
 * @author Prince
 * */
public class FrameImageView extends RelativeLayout {
    private String viewShape;
    private int strokeColor;
    private Drawable imageSrc;
    private ImageView imageView;

    // used programmatically
    public FrameImageView(@NonNull Context context) {
        super(context);
    }

    // used in xml layout
    public FrameImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        // Obtain a typed array of attributes
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FrameImageView, 0, 0);
        viewShape = a.getString(R.styleable.FrameImageView_frameView_shape);
        strokeColor = a.getColor(R.styleable.FrameImageView_frameView_strokeColor, Color.BLACK);
        imageSrc = a.getDrawable(R.styleable.FrameImageView_frameView_src);

        a.recycle();
    }

    /* control view dimension*/
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);

        setMeasuredDimension(width, height);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setImageDrawable(Drawable imageSrc) {
        imageView.setImageDrawable(imageSrc);
    }
}
