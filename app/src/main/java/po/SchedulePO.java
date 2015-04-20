package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by gaoyang on 15/3/25.
 */
public class SchedulePO {
    private Date startTime;
    private int length;
    private ArrayList<ActiviryPO> activityList;
    public SchedulePO(){
    }
    public SchedulePO(Date startTime,int length,ArrayList<ActiviryPO> activityList){
        this.startTime=startTime;
        this.activityList=activityList;
        this.length=length;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<ActiviryPO> getActivityList() {
        return activityList;
    }

    public void setActivityList(ArrayList<ActiviryPO> activityList) {
        this.activityList = activityList;
    }
}
