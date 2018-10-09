package com.example.achar.javatokotlin.activity.diff_recycle_view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.achar.javatokotlin.R;


/**
 * Created by ext.charles.ma on 17/9/22.
 */

public class ProgressCircleView extends View {

    private int mBorderColor;
    private float mBorderWidth;
    private Paint mPaint;
    //    private int progress;
    RectF oval;
    private int roundColor;
    private float roundWidth;
    private int roundProgressColor;

    private int progressAmount;
    private int progressColor;

    public ProgressCircleView(Context context) {
        this(context, null);
    }

    public ProgressCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {


        mPaint = new Paint();

        oval = new RectF();

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProgressCircleView, 0, 0);

        roundColor = typedArray.getColor(R.styleable.ProgressCircleView_border_color,
                Color.GRAY);
        roundWidth = typedArray.getDimension(R.styleable.ProgressCircleView_border_width,
                6);
        roundProgressColor = typedArray.getColor(
                R.styleable.ProgressCircleView_myRoundProgressColor, Color.GREEN);
        typedArray.recycle();


    }

    public void setAmountForColor(Context context, int amount) {
        this.progressAmount = amount;
        updateStrokeColor(context);
        postInvalidate();
    }

    private void updateStrokeColor(Context context) {
//        this.progressColor = context.getResources().getColor(
//                new ScoreToColorConverter(context)
//                        .convert(progressAmount)
//        );
        this.roundProgressColor = progressColor;
    }

    public int getRoundColor() {
        return roundColor;
    }

    public void setRoundColor(int color) {
        roundProgressColor = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);
        float centre = getWidth() / 2;
        float centreY = getHeight() / 2;
        float radius = (centre - roundWidth / 2);

        mPaint.setColor(roundColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(roundWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

//        canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环

        mPaint.setColor(roundProgressColor);
        oval.set(centre - radius, centre - radius, centre + radius, centre
                + radius);

        canvas.drawArc(oval, -90, progress, false, mPaint);

        mPaint.setStrokeWidth(0);
        mPaint.setColor(roundColor);
        mPaint.setTextSize(75);
        mPaint.setTypeface(Typeface.DEFAULT); // 设置字体
        float textWidth = mPaint.measureText(progressText + "%");
        float textHeight = mPaint.measureText(progressText+"");
        if (progressText >= 100) {
            canvas.drawText(progressText + "%", centre - textWidth / 2,
                    centreY + textHeight * 0.2f, mPaint); // 画出进度百分比
        }else {
            canvas.drawText(progressText + "%", centre - textWidth / 2,
                    centreY + textHeight * 0.3f, mPaint); // 画出进度百分比
        }

    }

    public static final String PROGRESS_PROPERTY = "progress";

    protected float progress;
    protected int progressText;



    public float getProgress() {
        return progress;
    }

    int num = 0;
    public void setProgress(float progress) {
        this.progress = progress * 360 / 100;
        num++;
        invalidate();// UI thread
        // postInvalidate();//non-UI thread.
    }


    public void dodo(int progressText, float progress) {
        this.progressText = progressText;
        this.progress = progress;

        ObjectAnimator progressAnimation = ObjectAnimator.ofFloat(this, "progress", 0, progress);
        progressAnimation.setDuration(500);// 动画执行时间


        progressAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        progressAnimation.start();
    }

}
