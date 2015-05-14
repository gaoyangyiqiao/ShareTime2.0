package turingmachine.com.sharetime20;

import java.util.Date;

import po.ActivityPO;

/**
 * Created by hello on 2015/5/11.
 */
public class ToDoPre {
    private int index=0;
    private Date startTime;
    private Date endTime;
    private int intend;
    private String content;
    private ActivityPO activityPO;
    public int getIndex(){
        return index;
    }
    public int getIntend(){
        return intend;
    }
    public Date getStartTime(){
        return startTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public String getContent(){
        return content;
    }
    public ToDoPre(ActivityPO activityPO,Date startTime,int index){
        this.activityPO=activityPO;
        this.content=activityPO.getContent();
        this.startTime=activityPO.getStartTime();
        this.endTime=activityPO.getEndTime();
        this.index=index;
    }
}
