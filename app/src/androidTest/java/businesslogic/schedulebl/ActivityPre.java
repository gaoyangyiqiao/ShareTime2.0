package businesslogic.schedulebl;

import po.ActiviryPO;

/**
 * Created by hello on 2015/4/26.
 */
public class ActivityPre {
    private int actListX;
    private int actListY;
    private int coorX;
    private int coorY;
    private ActiviryPO activityData;
    public ActivityPre(){

    }
    public ActivityPre(ActiviryPO po){
        this.activityData=po;
    }
}
