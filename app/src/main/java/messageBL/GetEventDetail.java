package messageBL;

import po.ActivityDetailPO;

/**
 * Created by admin on 2015/4/13.
 */
public class GetEventDetail {//运用单例模式

    private static ActivityDetailPO activity;

    public static void setActivityDetail(ActivityDetailPO po){
        activity = po;
    }

    public static ActivityDetailPO getActivityDetail(){
        return activity;
    }
}
