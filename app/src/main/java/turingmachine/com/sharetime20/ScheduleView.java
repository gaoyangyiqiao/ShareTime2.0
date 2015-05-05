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
import java.util.Date;

import po.ActivityPO;
import po.SchedulePO;

//import po.ActiviryPO;
//import po.ScheduleConfig;

public class ScheduleView extends View  implements View.OnTouchListener {
    //颜色
    //画笔
    public  static int topBarNum= 3;
    public  static int leftBarNum=8;
    public static int sideBar=70;//上边条目的高度
    public static int boxHeight=130;//每个格子的高度
    public static int boxWeight=150;
    public static int startX=0;//画布开始x
    public static int startY=0;//画布开始y
    public static int foucuseX=-1;//手的焦点x
    public static int foucuseY=-1;//手的焦点y
    public ActivityPre lastActivityPre;//上一次的位置
    public static int[] boxColor= { Color.argb(200, 71, 154, 199),
            Color.argb(200, 230, 91, 62), Color.argb(200, 50, 178, 93),
            Color.argb(200, 255, 225, 0), Color.argb(200, 102, 204, 204),
            Color.argb(200, 51, 102, 153), Color.argb(200, 102, 153, 204)
    };//格子背景色

    public static final int contentBg = Color.argb(255, 255, 255, 255);
    public static final int barBg = Color.argb(255, 225, 225, 225);
    public static final int bayText = Color.argb(255, 150, 150, 150);
    public static final int barBgHrLine = Color.argb(255, 150, 150, 150);
    public static final int boxBorder = Color.argb(180, 150, 150, 150);//格子边界颜色
    public static final int markerBorder = Color.argb(100, 150, 150, 150);//中间十字的颜色
    //public static final int[] hours={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    private Context context;
    private String[] weekdays={"周一","周二","周三","周四","周五","周六","周日"};
    private String[] hours={"1","2","3","4","5","6","7","8","9","10","12","13",};
    private Paint paint;
    private Canvas canvas;
    private long eventStartTime=0;
    private ArrayList<ActivityPre> activityInfo=new ArrayList<>();
    private ScheduleViewConfig scheduleViewConfig;

    public ScheduleView(Context context) {
        super(context);
        paint=new Paint();
        scheduleViewConfig=new ScheduleViewConfig(context);
        this.setOnTouchListener(this);
        boxWeight=(getWidth()-sideBar)/topBarNum;
       // activityInfo.add(new ActivityPre("lxy",1,2));
       activityInfo.add(new ActivityPre("zfy",3,2));
        activityInfo.add(new ActivityPre("i love you" ,11,3));
      activityInfo.add(new ActivityPre("hhh",23,2));
        ActivityPO activityPO= new ActivityPO();
        activityPO.setContent("Give you promiss");
        activityPO.setStartTime(new Date(2015, 5, 2, 23, 0, 0));
        activityPO.setEndTime(new Date(2015,5,2,24,0,0));
        activityInfo.add(new ActivityPre(activityPO,new Date()));
    }

    public ScheduleView(Context context, AttributeSet set) {
        super(context, set);
        paint=new Paint();
        this.setOnTouchListener(this);
        scheduleViewConfig=new ScheduleViewConfig(context);
        boxWeight=(getWidth()-sideBar)/topBarNum;
       // activityInfo.add(new ActivityPre("lxy",1,2));
        activityInfo.add(new ActivityPre("zfy",3,2));
        activityInfo.add(new ActivityPre("i love you" ,11,2));
        activityInfo.add(new ActivityPre("hhh",23,2));
       ActivityPO activityPO= new ActivityPO();
        activityPO.setContent("Give you promiss");
        activityPO.setStartTime(new Date(2015, 5, 2, 23, 0, 0));
        activityPO.setEndTime(new Date(2015,5,2,24,0,0));
        activityInfo.add(new ActivityPre(activityPO,new Date()));
    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        boxWeight=(getWidth()-sideBar)/topBarNum;
        drawBox();
        drawLeftBar();
        drawMarker();
        drawTopBar();
    }

    //画相交处的十字线
    public void drawMarker() {

        paint.setColor(markerBorder);
        for (int i = 0; i < topBarNum - 1; i++) {
            for (int j = 0; j < leftBarNum - 1; j++) {
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(startX + sideBar + boxWeight * (i + 1) - boxWeight / 20, startY + sideBar + boxHeight * (j + 1) - 1, startX + sideBar + boxWeight * (i + 1) + boxWeight / 20, startY + sideBar + boxHeight * (j + 1) + 1,paint);
                canvas.drawRect(startX + sideBar + boxWeight * (i + 1) - 1, startY + sideBar + boxHeight * (j + 1) - boxHeight / 20, startX + sideBar + boxWeight * (i + 1) + 1, startY + sideBar + boxHeight * (j + 1) + boxHeight / 20,paint);
            }
        }
    }

    //画格子

    public void drawBox() {
        int length = activityInfo.size();
        for(int i=0;i<length;i++){
            ActivityPre activityPre=activityInfo.get(i);
            int startx=activityPre.getStartX();
            int starty=activityPre.getStartY();
            int endx=activityPre.getEndX();
            int endy=activityPre.getEndY();
            paint.setStyle(Paint.Style.FILL);

           if(activityPre.getId()==1) paint.setColor(boxColor[i % boxColor.length]);
            if(activityPre.getId()==2)paint.setColor(boxColor[1 % boxColor.length]);
            canvas.drawRect(startx, starty, endx,endy,paint);

            paint.setColor(boxBorder);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(startx, starty, endx,endy,paint);
            paint.setColor(Color.BLACK);
            String inf =activityPre.getContent();
            Rect textRect = new Rect();
            paint.getTextBounds(inf, 0, inf.length(), textRect);
            paint.setTextSize(30);
            int th = textRect.bottom - textRect.top;
            int tw = textRect.right - textRect.left;
            int row = (int) ((tw + 30) / boxWeight + 1);
            int len = inf.length() / row;
            canvas.drawText(inf,startx+20,starty+(endy-starty)/2,paint);
            for (int j = 0; j < row - 1; j++) {
                canvas.drawText(inf, len * j, len * (j + 1), startx + 5, starty + 10 + th * (j + 1), paint);
            }
        }
    }


    public void drawTopBar() {

        paint.setColor(barBg);
        paint.setStyle(Paint.Style.FILL);
        //画第一个边框线
        canvas.drawRect(startX + sideBar, 0, startX + sideBar + boxWeight * topBarNum, sideBar, paint);
        paint.setColor(barBgHrLine);
        paint.setTextSize(25);
        canvas.drawRect(startX + sideBar + boxWeight - 1, 0, startX + sideBar + boxWeight, sideBar,paint);
        //画第一个文字
        Rect textBounds = new Rect();
        paint.getTextBounds(weekdays[0], 0, weekdays[0].length(), textBounds);
        int textHeight = textBounds.bottom - textBounds.top;
        int textWeight = textBounds.right - textBounds.left;
        canvas.drawText(weekdays[0], startX + sideBar + boxWeight / 2 - textWeight / 2, sideBar / 2 + textHeight / 2, paint);
        //画剩下的边框线和文字
        for (int m = 0; m < topBarNum - 1; m++) {
            canvas.drawRect(startX + sideBar + (m + 2) * boxWeight - 1, 0, startX + sideBar + (m + 2) * boxWeight, sideBar, paint);
            canvas.drawText(weekdays[m + 1], startX + sideBar + (m + 1) * boxWeight + boxWeight / 2 - textWeight / 2, sideBar / 2 + textHeight / 2,paint);
        }

    }

    public void drawLeftBar() {

        paint.setColor(barBg);
        paint.setStyle(Paint.Style.FILL);
        //画背景
        canvas.drawRect(startX + 0, startY + sideBar, startX + sideBar, startY + boxHeight * leftBarNum + sideBar, paint);
        //画第一个边线
        paint.setColor(barBgHrLine);
        canvas.drawRect(startX + 0, startY + sideBar + boxHeight - 1, startX + sideBar, startY+sideBar + boxHeight,paint);
        //画第一个文字
        Rect textRect = new Rect();
        paint.getTextBounds(hours[0] + "", 0, (hours[0] + "").length(), textRect);
        int textHeight = textRect.bottom - textRect.top;
        int textWight = textRect.right - textRect.left;
        canvas.drawText(hours[0] + "", startX + sideBar / 2 - textWight / 2, startY + sideBar + boxHeight / 2 + textHeight / 2,paint);
        //画剩下的边线和文字
        for (int i = 0; i < leftBarNum - 1; i++) {
            //画边线
            canvas.drawRect(startX + 0, startY + sideBar + (i + 2) * boxHeight - 1, startX + sideBar, startY + sideBar + (i + 2) * boxHeight, paint);
            //画文字
            Rect textRebounds = new Rect();
            paint.getTextBounds(hours[i + 1] + "", 0, (hours[i + 1] + "").length(), textRebounds);
            int th = textRebounds.height();
            int tw = textRebounds.width();
            canvas.drawText(hours[i + 1] + "", startX + sideBar / 2 - textWight / 2, startY + (i + 1) * boxHeight + boxHeight + textHeight / 2, paint);
        }

    }
    public boolean onTouch(View v, MotionEvent event) {
        Long startTime=event.getDownTime();
        int x=(int)event.getX();
        int y=(int)event.getY();
        x=x-sideBar;
        y=y-sideBar;
        x=x/boxWeight;
        y=y/boxHeight;
        ActivityPre activityPre=new ActivityPre(x*boxWeight+sideBar+startX,y*boxHeight+sideBar+startY,x*boxWeight+sideBar+startX+boxWeight,y*boxHeight+sideBar+startY+boxHeight);
        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE:
                if(lastActivityPre==null){
                    lastActivityPre=activityPre;
                }
                else{
                    int index1=lastActivityPre.getIndex();
                    int index2=activityPre.getIndex();
                    if((index1==(index2+1)||index1==(index2-1))&&!ifExit(lastActivityPre)){
                        activityInfo.add(activityPre);
                        activityInfo.add(lastActivityPre);paint.setStyle(Paint.Style.STROKE);
                        canvas.drawRect(activityPre.getStartX(),activityPre.getStartY(),activityPre.getEndX(),activityPre.getEndY(),paint);
                        canvas.drawRect(lastActivityPre.getStartX(),lastActivityPre.getStartY(),lastActivityPre.getEndX(),lastActivityPre.getEndY(),paint);
                        lastActivityPre=null;
                    }
                }
                break;
            case MotionEvent.ACTION_DOWN:

                //paint.setColor(Color.BLUE);
                //  canvas.drawRect(x+sideBar+startX,y+sideBar+startY,x+sideBar+startX+boxWeight,y+sideBar+startY+boxHeight,paint);
                // canvas.drawRect(x+sideBar+startX+boxWeight,y+sideBar+startY+boxHeight,x+sideBar+startX+2*boxWeight,y+sideBar+startY+2*boxHeight,paint);
                //  activityInfo.add(activityPre);
                break;
            case MotionEvent.ACTION_UP:
                lastActivityPre=null;
                break;
        }
        invalidate();
        return true;
    }
    public ArrayList<ActivityPre> getTestData(){
        SchedulePO schedulePO=new SchedulePO();
       // schedulePO.setActivityList();
        SchedulePre schedulePre=new SchedulePre(schedulePO);
        return null;
    }
    public boolean ifExit(ActivityPre activityPre){
        int length=activityInfo.size();
        for(int i=0;i<length;i++){
            ActivityPre activityPre1=activityInfo.get(i);
            if(activityPre1.getStartX()==activityPre.getStartX()&&activityPre1.getStartY()==activityPre.getStartY()){
                return true;
            }
        }
        return false;
    }

}


