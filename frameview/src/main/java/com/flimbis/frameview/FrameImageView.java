package com.flimbis.frameview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/*
 *
 * @author Prince
 * */
public class FrameImageView extends RelativeLayout {
    private String viewShape;
    private int strokeColor;
    private Drawable imageSrc;
    private ImageView imageView;
    private Context context;

    // used programmatically
    public FrameImageView(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    // used in xml layout
    public FrameImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttributes(attrs);
    }

    private void initAttributes(AttributeSet attrs) {
        inflate(context, R.layout.frame_image_view_layout, this);
        imageView = findViewById(R.id.img_src);

        // Obtain a typed array of attributes
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FrameImageView, 0, 0);
        viewShape = a.getString(R.styleable.FrameImageView_frameView_shape);
        strokeColor = a.getColor(R.styleable.FrameImageView_frameView_strokeColor, Color.BLACK);
        imageSrc = a.getDrawable(R.styleable.FrameImageView_frameView_src);

        // set shape
        setViewShape(1);
        // default padding
        this.setPadding(10, 15, 10, 15);

        if (null != imageSrc)
            setImageDrawable(imageSrc);

        a.recycle();
    }

    public void setImageDrawable(Drawable imageSrc) {
        imageView.setImageDrawable(imageSrc);
    }

    public void setViewShape(int shape) {
        //this.setBackgroundColor(getResources().getColor(R.color.defaultPrimary));
        if (Build.VERSION.SDK_INT >= 16)
            this.setBackground(ContextCompat.getDrawable(context, R.drawable.frameview_bkgrnd_circle));
        else
            this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.frameview_bkgrnd_circle));
    }
}
