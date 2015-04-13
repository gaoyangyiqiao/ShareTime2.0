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
}
