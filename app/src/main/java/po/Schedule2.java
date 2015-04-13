package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hello on 2015/3/15.
 */
public class Schedule2 {
    private Date startTime;
    private int length;
    private ArrayList<ActivityItem> activityList;
    public Schedule2(){
    }
    public Schedule2(Date startTime,int length,ArrayList<ActivityItem> activityList){
        this.startTime=startTime;
        this.activityList=activityList;
        this.length=length;
    }

    public void setActivityList(ArrayList<ActivityItem> activityList) {
        this.activityList = activityList;
    }

    public ArrayList<ActivityItem> getActivityList() {
        return activityList;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setStartTime(TimeNode startTime) {
//        this.startTime = startTime;
        return;
    }

    public TimeNode getStartTime() {
//        return startTime;
        return null;
    }
}
