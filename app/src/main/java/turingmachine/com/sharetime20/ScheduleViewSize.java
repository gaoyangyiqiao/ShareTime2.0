package turingmachine.com.sharetime20;

import android.graphics.Color;

import po.ScheduleConfig;

/**
 * Created by hello on 2015/4/24.
 */
public final class ScheduleViewSize {
   public  static int topBarNum= ScheduleConfig.days;
   public  static int leftBarNum=ScheduleConfig.hoursInDay;
   public static int topBarHeight=50;//上边条目的高度
   public static int boxHeight=120;//每个格子的高度
   public static int startX=0;//画布开始x
   public static int startY=0;//画布开始y
   public static int foucuseX=-1;//手的焦点x
   public static int foucuseY=-1;//手的焦点y
    public static int boxWeight=120;
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
}
