package com.example.achar.javatokotlin.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import static android.graphics.Paint.Style.FILL_AND_STROKE;
import static android.graphics.Paint.Style.STROKE;

/**
 * Created by ext.charles.ma on 17/12/1.
 *
 * 自制的雷达控件，六边形能力图
 */

public class MBtestView extends View {

    private Paint paint;
    private Paint pointPaint;
    private Paint paintGray;

    private Paint paintWhite;
    private TextPaint paintWhiteText;
    private TextPaint paintBlackText;

    private Path path;
    private Path pathInner;
    private Path pathInnerSTROKE;

    private double cos30 = Math.cos(30 * Math.PI / 180);
    private double sin30 = Math.sin(30 * Math.PI / 180);


    public MBtestView(Context context) {
        this(context, null);
    }

    public MBtestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MBtestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //创建一个路径，我需要把多边形的路径计算出来（算点）
        path = new Path();
        pathInner = new Path();
        pathInnerSTROKE = new Path();
        //创建一个画笔，启动绘制
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);  //这个是外轮廓的画笔
        paint.setStyle(STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4f);

        paintGray = new Paint(Paint.ANTI_ALIAS_FLAG); //这个是交叉线的画笔
        paintGray.setStyle(STROKE);
        paintGray.setColor(Color.GRAY);
        paintGray.setStrokeWidth(3f);

        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);  //这个是中心的画笔
        pointPaint.setStyle(FILL_AND_STROKE);
        pointPaint.setColor(Color.WHITE);
        pointPaint.setStrokeWidth(8f);
        pointPaint.setAlpha(88);

        paintWhite = new Paint(Paint.ANTI_ALIAS_FLAG); //这个就是数据的画笔了
        paintWhite.setStyle(STROKE);
        paintWhite.setColor(Color.WHITE);
        paintWhite.setStrokeWidth(2f);


        paintWhiteText = new TextPaint(Paint.ANTI_ALIAS_FLAG); //这个就是数据字体的白色画笔了
        paintWhiteText.setTextSize(15 * getResources().getDisplayMetrics().density + 0.5f);
        paintWhiteText.density = getResources().getDisplayMetrics().density;
        paintWhiteText.setColor(Color.WHITE);

        paintBlackText = new TextPaint(Paint.ANTI_ALIAS_FLAG); //这个就是数据字体的黑色画笔了
        paintBlackText.setTextSize(14 * getResources().getDisplayMetrics().density + 0.5f);
        paintBlackText.density = getResources().getDisplayMetrics().density;
        paintBlackText.setColor(Color.BLACK);


    }

    Rect rect1 = new Rect();
    Rect rect2 = new Rect();

    //现在暂时使用屏幕宽度的1/4作为最大值，这个值是一个内边的长度，因为整体图形应该有2个这个距离 + 字体的高度
    //    private float maxYValue = 500 / getResources().getDisplayMetrics().density + 0.5f;
    private float maxYValue = getResources().getDisplayMetrics().widthPixels / 4;

    private int MaxValue = 100;

    private float qqq = 0;

    private float data_1 = 0.8f;

    private float[] dataList = new float[]{-1, -1, -1, -1, -1, -1};
    private String[] dataNameList = new String[]{"", "", "", "", "", ""};

    public String[] getDataNameList() {
        return dataNameList;
    }

    public void setDataNameList(String[] dataNameList) {
        this.dataNameList = dataNameList;
    }

    public float[] getDataList() {
        return dataList;
    }

    public void setDataList(float[] dataList) {
        this.dataList = dataList;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centreX = getWidth() / 2;
        int centreY = getHeight() / 2;

        //通过path部署外轮廓的轨迹了
        path.moveTo(centreX, centreY - maxYValue);
        path.lineTo((float) (centreX + maxYValue * cos30), (float) (centreY - maxYValue * sin30));
        path.lineTo((float) (centreX + maxYValue * cos30), (float) (centreY + maxYValue * sin30));
        path.lineTo(centreX, centreY + maxYValue);
        path.lineTo((float) (centreX - maxYValue * cos30), (float) (centreY + maxYValue * sin30));
        path.lineTo((float) (centreX - maxYValue * cos30), (float) (centreY - maxYValue * sin30));
//        path.lineTo(centreX, centreY - maxYValue);
        path.close();

        //通过path部署内部得分轮廓的填充内容
        pathInner.moveTo(centreX, centreY - (maxYValue * getDataList()[0]) * qqq);
        pathInner.lineTo((float) (centreX + (maxYValue * cos30 * dataList[1]) * qqq), (float) (centreY - (maxYValue *
                sin30 *
                dataList[1]) * qqq));
        pathInner.lineTo((float) (centreX + (maxYValue * cos30 * dataList[2]) * qqq), (float) (centreY + (maxYValue *
                sin30 *
                dataList[2]) * qqq));
        pathInner.lineTo(centreX, centreY + (maxYValue * dataList[3]) * qqq);
        pathInner.lineTo((float) (centreX - (maxYValue * cos30 * dataList[4]) * qqq), (float) (centreY + (maxYValue *
                sin30
                * dataList[4]) *
                qqq));
        pathInner.lineTo((float) (centreX - (maxYValue * cos30 * dataList[5]) * qqq), (float) (centreY - (maxYValue *
                sin30
                * dataList[5]) *
                qqq));
//        pathInner.lineTo(centreX, centreY - (maxYValue * 0.8f) * qqq);
        pathInner.close();

        //通过path部署内部得分轮廓
        pathInnerSTROKE.moveTo(centreX, centreY - (maxYValue * dataList[0]));

        pathInnerSTROKE.lineTo((float) (centreX + (maxYValue * cos30 * dataList[1])), (float) (centreY - (maxYValue *
                sin30 *
                dataList[1])));

        pathInnerSTROKE.lineTo((float) (centreX + (maxYValue * cos30 * dataList[2])), (float) (centreY + (maxYValue *
                sin30 *
                dataList[2])));

        pathInnerSTROKE.lineTo(centreX, centreY + (maxYValue * dataList[3]));

        pathInnerSTROKE.lineTo((float) (centreX - (maxYValue * cos30 * dataList[4])), (float) (centreY + (maxYValue *
                sin30 *
                dataList[4])));
        pathInnerSTROKE.lineTo((float) (centreX - (maxYValue * cos30 * dataList[5])), (float) (centreY - (maxYValue *
                sin30 *
                dataList[5])));
//        pathInnerSTROKE.lineTo(centreX, centreY - (maxYValue * 0.8f));
        pathInnerSTROKE.close();

        //绘制外轮廓
        canvas.drawPath(path, paint);
        //绘制交叉线
        canvas.drawLine(centreX, centreY - maxYValue, centreX, centreY + maxYValue, paintGray);
        canvas.drawLine((float) (centreX + maxYValue * cos30), (float) (centreY - maxYValue * sin30), (float) (centreX -
                maxYValue * cos30), (float) (centreY + maxYValue * sin30), paintGray);
        canvas.drawLine((float) (centreX + maxYValue * cos30), (float) (centreY + maxYValue * sin30), (float) (centreX -
                maxYValue * cos30), (float) (centreY - maxYValue * sin30), paintGray);
        //绘制中心点
        canvas.drawPoint(centreX, centreY, pointPaint);


        //绘制得分轮廓
        if (canCanvas) {
            canvas.drawPath(pathInnerSTROKE, paintWhite);
        }
        //绘制得分的填充
        canvas.drawPath(pathInner, pointPaint);


        if (dataList[0] != -1) {
            //绘制每个数据的显示值和名称
            //第一个数据
            paintWhiteText.getTextBounds(dataNameList[0], 0, dataNameList[0].length(), rect1);

            paintWhiteText.getTextBounds((Math.round(100 * dataList[0]) + "%"), 0, (Math.round(100 * dataList[0]) + "%")
                    .length(), rect2);
            canvas.drawText(dataNameList[0], centreX - rect1.width(), centreY - maxYValue - rect1.height() * 0.5f,
                    paintBlackText);
            canvas.drawText((Math.round(dataList[0] * 100) + "%"), centreX + rect2.width() * 0.25f, centreY -
                    maxYValue - rect1.height() * 0.5f, paintWhiteText);
            //第二个数据
            paintWhiteText.getTextBounds(dataNameList[1], 0, dataNameList[1].length(),
                    rect1);
            paintWhiteText.getTextBounds((Math.round(100 * dataList[1]) + "%"), 0, (Math.round(100 * dataList[1]) + "%")
                    .length(), rect2);
            canvas.drawText(dataNameList[1], (float) (centreX + maxYValue * cos30) + 20, (float) (centreY -
                    maxYValue * sin30), paintBlackText);
            canvas.drawText((Math.round(100 * dataList[1]) + "%"), (float) (centreX + maxYValue * cos30) + 20 +
                    rect1.width() + rect2.width() * 0.25f, (float) (centreY - maxYValue * sin30), paintWhiteText);
            //第三个数据
            paintWhiteText.getTextBounds(dataNameList[2], 0, dataNameList[2].length(),
                    rect1);
            paintWhiteText.getTextBounds((Math.round(100 * dataList[2]) + "%"), 0, (Math.round(100 * dataList[2]) + "%")
                    .length(), rect2);
            canvas.drawText(dataNameList[2], (float) (centreX + maxYValue * cos30) + 20, (float) (centreY +
                    maxYValue * sin30), paintBlackText);
            canvas.drawText((Math.round(100 * dataList[2]) + "%"), (float) (centreX + maxYValue * cos30) + 20 +
                    rect1.width() + rect2.width() * 0.25f, (float) (centreY + maxYValue * sin30), paintWhiteText);
            //第四个数据
            paintWhiteText.getTextBounds(dataNameList[3], 0, dataNameList[3].length(), rect1);
            paintWhiteText.getTextBounds((Math.round(100 * dataList[3]) + "%"), 0, (Math.round(100 * dataList[3]) + "%")
                    .length(), rect2);
            canvas.drawText(dataNameList[3], centreX - rect1.width(), centreY + maxYValue + rect1.height() + 10,
                    paintBlackText);
            canvas.drawText((Math.round(100 * dataList[3]) + "%"), centreX + rect2.width() * 0.25f, centreY +
                    maxYValue + rect1.height()+ 10, paintWhiteText);

            //第五个数据
            paintWhiteText.getTextBounds(dataNameList[4], 0, dataNameList[4].length(), rect1);
            paintWhiteText.getTextBounds((Math.round(100 * dataList[4]) + "%"), 0, (Math.round(100 * dataList[4]) + "%")
                    .length(), rect2);
            canvas.drawText(dataNameList[4], (float) (centreX - maxYValue * cos30) - rect1.width()- rect2.width() * 1.25f - 20,
                    (float) (centreY + maxYValue * sin30), paintBlackText);
            canvas.drawText((Math.round(100 * dataList[4]) + "%"), (float) (centreX - maxYValue * cos30) -
                    rect2.width() - 20, (float) (centreY + maxYValue * sin30), paintWhiteText);

            //第六个数据
            paintWhiteText.getTextBounds(dataNameList[5], 0, dataNameList[5].length(), rect1);
            paintWhiteText.getTextBounds((Math.round(100 * dataList[5]) + "%"), 0, (Math.round(100 * dataList[5]) + "%")
                    .length(), rect2);
            canvas.drawText(dataNameList[5], (float) (centreX - maxYValue * cos30) - rect1.width() - rect2.width() * 1.25f - 20, (float)
                            (centreY - maxYValue * sin30), paintBlackText);
            canvas.drawText((Math.round(100 * dataList[5]) + "%"), (float) (centreX - maxYValue * cos30) -
                    rect2.width() - 20, (float) (centreY - maxYValue * sin30), paintWhiteText);

            canvas.drawText(maxYValue + "", 10, 60, paintWhiteText);
        }


    }


    private Boolean canCanvas = false;

    public float getQqq() {
        return qqq;
    }

    public void setQqq(float qqq) {
        this.qqq = qqq;
        invalidate();
    }

    public float getData_1() {
        return data_1;
    }

    public void setData_1(float data_1) {
        this.data_1 = data_1;
        pathInnerSTROKE.reset();
        pathInner.reset();
        path.reset(); //之前重绘制时，我没有调用这个的reset，因为没有必要，结局就是cpu占用随着点击次数上升而上升，现在设置了就可以了，原因？？
        invalidate();
    }


    public void animateY(int durationMillis) {

//        if (android.os.Build.VERSION.SDK_INT < 11)
//            return;

        pathInnerSTROKE.reset();
        pathInner.reset();
        path.reset();  //之前重绘制时，我没有调用这个的reset，因为没有必要，结局就是cpu占用随着点击次数上升而上升，现在设置了就可以了，原因？？
        canCanvas = false;

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "qqq", 0f, 1f);
        if (animatorY.isRunning()) {
            animatorY.cancel();
            canCanvas = false;
        }

        animatorY.setDuration(durationMillis);
//        animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//            }
//        });
        animatorY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                canCanvas = true;
                invalidate();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorY.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorY.start();


    }

}
