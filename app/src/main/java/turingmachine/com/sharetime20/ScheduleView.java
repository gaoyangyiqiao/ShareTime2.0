package turingmachine.com.sharetime20;

import android.app.Notification;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import po.ActiviryPO;
import po.ScheduleConfig;

public class ScheduleView extends View implements View.OnTouchListener{
    //颜色
    //画笔
    private Paint mPaint; // 画笔,包含了画几何图形、文本等的样式和颜色信息
    private int startX = ScheduleViewSize.startX;//画布的原点X（所有的画图操作，都是基于这个原点的，touch中只要修改这个值）
    private int startY = ScheduleViewSize.startY;//画布的原点Y（所有的画图操作，都是基于这个原点的，touch中只要修改这个值）
    private static final int sideBar = ScheduleViewSize.topBarHeight;//左边，上面bar的宽度
    private static final int boxHeight = ScheduleViewSize.boxHeight;//每个格子的高度
    private static final int boxWeight=ScheduleViewSize.boxWeight;
    private static int eachBoxW = 120;//每个格子的宽度，后面根据屏幕对它做了均分
    private int focusX = -1;//当前手指焦点的位置坐标
    private int focusY = -1;//当前手指焦点的位置坐标
    private static int leftBarNum = ScheduleViewSize.leftBarNum;//左边栏总格子数
    private static int topBarNmu = ScheduleViewSize.topBarNum;//顶部栏总共格子数
    private String[] weekdays;//星期
    public static final int classBorder = Color.argb(180, 150, 150, 150);
    private boolean isMove = false; // 判断是否移动
    private Context context;
    private int [] boxColor=ScheduleViewSize.boxColor;
    private ArrayList<ActivityData> activityInfo;
    public ScheduleView(Context context){
        super(context);
    }
    public ScheduleView(Context context,AttributeSet set){
        super(context,set);
    }
    public boolean onTouch(View view,MotionEvent event){
        return true;
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        drawBox(canvas);
        drawLeftBar(canvas);
        drawMarker(canvas);
        drawTopBar(canvas);
    }
    //画相交处的十字线
    public void drawMarker(Canvas canvas){
         mPaint.setColor(ScheduleViewSize.markerBorder);
        for(int i=0;i<topBarNmu-1;i++){
            for(int j=0;j<leftBarNum-1;j++){
                mPaint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(startX+sideBar+boxWeight*(i+1)-boxWeight/20,startY+sideBar+boxHeight*(j+1)-1,startX+sideBar+boxWeight*(i+1)+boxWeight/20,startY+sideBar+boxHeight*(j+1)+1,mPaint);
                canvas.drawRect(startX+sideBar+boxWeight*(i+1)-1,startY+sideBar+boxHeight*(j+1)-boxHeight/20,startX+sideBar+boxWeight*(i+1)+1,startY+sideBar+boxHeight*(j+1)+boxHeight/20,mPaint);
            }
        }
    }
    //画格子
    public void drawBox(Canvas canvas){
         int length=activityInfo.size();
        for(int i=0;i<length;i++){
            ActivityData activityData=activityInfo.get(i);
            int sx=activityData.getStartx();
            int sy=activityData.getStarty();
            int ex=activityData.getEndx();
            int ey=activityData.getEndy();
            int stx=startX+sideBar+(sx-1)*boxWeight;
            int sty=startY+sideBar+(sy-1)*boxHeight;
            int enx=startX+sideBar+ex*boxWeight;
            int eny=startY+sideBar+ey*boxHeight;


            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(boxColor[i%boxColor.length]);
            canvas.drawRect(stx,sty,enx,eny,mPaint);

            mPaint.setColor(Color.WHITE);
            String inf=activityData.getContent();
            Rect textRect=new Rect();
            mPaint.getTextBounds(inf,0,inf.length(),textRect);
            int th=textRect.bottom-textRect.top;
            int tw=textRect.right-textRect.left;
            int row=(int)((tw+30)/boxWeight+1);
            int len=inf.length()/row;
            for(int j=0;j<row-1;j++){
                canvas.drawText(inf,len*j,len*(j+1),stx+5,sty+10+th*(j+1),mPaint);
            }

            //边框
            mPaint.setColor(classBorder);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(stx,sty,enx,eny,mPaint);

        }
    }
    public void drawTopBar(Canvas canvas){

    }
    public void drawLeftBar(Canvas canvas){

    }
    public void setActivityInfo(ArrayList<ActivityData> list){
        this.activityInfo=list;
        invalidate();
    }



}