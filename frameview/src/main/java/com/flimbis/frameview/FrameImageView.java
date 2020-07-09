package com.flimbis.frameview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
    private int viewShape;
    private int strokeColor;
    private int backgroundColor;
    private Drawable imageSrc;
    /*
     * GradientDrawable, A Drawable with a color gradient for buttons, backgrounds.
     * It can be defined in an XML file with the <shape> element
     * */
    private GradientDrawable shapeDrawable;
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

        // defaults
        int bkgrdColor = ContextCompat.getColor(context, R.color.defaultBkgrnd);
        int strkeColor = ContextCompat.getColor(context, R.color.defaultStroke);

        // Obtain a typed array of attributes
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FrameImageView, 0, 0);
        viewShape = a.getInteger(R.styleable.FrameImageView_frameView_shape, 0);
        backgroundColor = a.getColor(R.styleable.FrameImageView_frameView_backgroundColor, bkgrdColor);
        strokeColor = a.getColor(R.styleable.FrameImageView_frameView_strokeColor, strkeColor);
        imageSrc = a.getDrawable(R.styleable.FrameImageView_frameView_src);

        // set shape
        setViewShape(viewShape);
        // background or solid
        setBackgroundColor(backgroundColor);
        // stroke color
        setStrokeColor(strokeColor);
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
        /*if (Build.VERSION.SDK_INT >= 16)
            this.setBackground(ContextCompat.getDrawable(context, R.drawable.frameview_bkgrnd_circle));
        else
            this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.frameview_bkgrnd_circle));*/

        //GradientDrawable gd = (GradientDrawable) this.getBackground();
        shapeDrawable = new GradientDrawable();
        switch (shape) {
            case 1/*square*/:
                this.setBackground(ContextCompat.getDrawable(context, R.drawable.frameview_bkgrnd_circle));
                break;
            case 2/*triangle*/:
                shapeCircle(shapeDrawable);
                break;
            default/*circle*/:
                shapeCircle(shapeDrawable);
                //this.setBackground(ContextCompat.getDrawable(context, R.drawable.frameview_bkgrnd_circle));
                break;
        }

    }

    public void setBackgroundColor(int color) {
        shapeDrawable.setColor(color);
    }

    public void setStrokeColor(int color){
        shapeDrawable.setStroke(1, color);
    }

    private void shapeCircle(GradientDrawable gd) {
        gd.setShape(GradientDrawable.OVAL);
        this.setBackground(gd);
    }
}
