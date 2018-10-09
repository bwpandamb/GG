package com.example.achar.javatokotlin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.achar.javatokotlin.R;

/**
 * Created by ext.charles.ma on 18/2/11.
 */

public class MyProgressLine extends View {

    private Paint paintStroke;
    private Paint paintFill;
    private RectF oval1;
    private RectF oval2;
    private RectF oval3;
    private int mStrokeColor;
    private int mFillColor;
    private float mStrokeWidth;
    private float mFillHeight;
    private int progressNumber;

    private int fenshu =10;


    public MyProgressLine(Context context) {
        this(context, null);
    }

    public MyProgressLine(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyProgressLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray mTypedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.MyProgressLine, 0, 0);

        mStrokeColor = mTypedArray.getColor(R.styleable.MyProgressLine_strokeColor, getResources().getColor(R.color
                .gray));
        mFillColor = mTypedArray.getColor(R.styleable.MyProgressLine_fillColor, getResources().getColor(R.color.red));
        mStrokeWidth = mTypedArray.getDimension(R.styleable.MyProgressLine_strokeWidth, 2);
        mFillHeight = mTypedArray.getDimension(R.styleable.MyProgressLine_fillHeight, 60);
        progressNumber = mTypedArray.getInteger(R.styleable.MyProgressLine_progressNumber, 0);

        paintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setColor(mStrokeColor);
        paintStroke.setStrokeWidth(mStrokeWidth);
        paintStroke.setAntiAlias(true);

        paintFill = new Paint();
        paintFill.setStyle(Paint.Style.FILL);
        paintFill.setAntiAlias(true);
        paintFill.setColor(mFillColor);


        // 设置个新的长方形
        oval1 = new RectF(0, 0, 1080, mFillHeight);
        oval2 = new RectF(mFillHeight / 2, 0, fenshu, mFillHeight);
        oval3 = new RectF(0, 0, mFillHeight, mFillHeight);

    }

    public int getFenshu() {
        return fenshu;
    }

    public void setFenshu(int fenshu) {
        this.fenshu = fenshu;
        invalidate();
    }

    public void setProgress(int fenshu){
        this.fenshu = fenshu;
        postInvalidate();
    }

    public void change(int width) {
        oval1 = new RectF(0, 0, width , mFillHeight);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureDimension(getResources().getDisplayMetrics().widthPixels, widthMeasureSpec);
        int height = measureDimension((int) (mFillHeight), heightMeasureSpec);
        change(width);
        setMeasuredDimension(width, height);
    }


    public int measureDimension(int defaultSize, int measureSpec) {
        int result;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultSize;   //UNSPECIFIED
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        oval2.set(mFillHeight / 2, 0, fenshu, mFillHeight);
        canvas.drawRoundRect(oval1, mFillHeight /2 , mFillHeight /2 , paintStroke);
        canvas.drawRect(oval2, paintFill);
        canvas.drawArc(oval3, -90, -180, true, paintFill);

    }
}
