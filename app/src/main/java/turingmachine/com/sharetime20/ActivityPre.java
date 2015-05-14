package turingmachine.com.sharetime20;

import java.util.Date;

import po.ActivityPO;

/**
 * Created by hello on 2015/4/29.
 */
public class ActivityPre {
    private int index;
    private int last=1;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private String content;
    private ActivityPO po;
    private int id=1;//这个id用于区分当前activitypre是哪种类型 1 activity 2 设置的有空
    public ActivityPre(int startX,int startY,int endX,int endY){
        this.index=2;
        this.startX=startX;
        this.startY=startY;
        this.endX=endX;
        this.endY=endY;
        int col=(startX-(ScheduleView.startX+ScheduleView.sideBar))/ScheduleView.boxWeight;
        int row=(startY-(ScheduleView.startY+ScheduleView.sideBar))/ScheduleView.boxHeight;
        this.index=(col+1)*ScheduleView.leftBarNum+row+1;
        this.last=1;
        this.content="";

    }
    public ActivityPre(ActivityPO po,Date scheduleTime,int index){
        this.po=po;
        this.content=po.getContent();
        Date startTime=po.getStartTime();
        Date endTime=po.getEndTime();
        long start=startTime.getTime();
        long end=endTime.getTime();
        long gap=end-start;
        long s=start-scheduleTime.getTime();
        this.index=((int)s/(1000*60*60));
        System.out.println(scheduleTime.getHours());
        int last=(int)gap/(1000*60*60);
        this.index=1;
        this.last=last;
        int row=(index-1)%ScheduleView.leftBarNum;
        int col=index/ScheduleView.leftBarNum;
        startX=ScheduleView.startX+ScheduleView.sideBar+(col)*ScheduleView.boxWeight;
        startY=ScheduleView.startY+ScheduleView.sideBar+(row)*ScheduleView.boxHeight;
        endX=ScheduleView.startX+ScheduleView.sideBar+(col+1)* ScheduleView.boxWeight;
        endY=ScheduleView.startY+ScheduleView.sideBar+(row+1+last-1)*ScheduleView.boxHeight;
        this.index=index;
    }
    public ActivityPre(String inf,int index,int last){
        this.id=1;
        this.content=inf;
        this.index=index;
        this.last=last;
        int row=(index-1)%ScheduleView.leftBarNum;
        int col=index/ScheduleView.leftBarNum;
        startX=ScheduleView.startX+ScheduleView.sideBar+(col)*ScheduleView.boxWeight;
        startY=ScheduleView.startY+ScheduleView.sideBar+(row)*ScheduleView.boxHeight;
        endX=ScheduleView.startX+ScheduleView.sideBar+(col+1)* ScheduleView.boxWeight;
        endY=ScheduleView.startY+ScheduleView.sideBar+(row+1+last-1)*ScheduleView.boxHeight;

    }
    public String getContent(){
        return content;
    }
    public int getIndex(){
        return index;
    }
    public int getStartX(){
        return startX;
    }
    public int getStartY(){
        return startY;
    }
    public int getEndX(){
        return endX;
    }
    public int getEndY(){
        return endY;
    }
    public int getId(){
        return id;
    }
}

