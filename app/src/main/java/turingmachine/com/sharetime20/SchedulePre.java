package turingmachine.com.sharetime20;

import android.widget.Switch;

import java.util.ArrayList;

import po.ActivityPO;
import po.SchedulePO;

/**
 * Created by hello on 2015/4/29.
 */
public class SchedulePre {
    private SchedulePO schedule;

    public SchedulePre(SchedulePO schedule){
        this.schedule=schedule;
    }


    public ArrayList getActivityPre(){
        ArrayList<ActivityPO> list=schedule.getActivityList();
        int length=list.size();
        ArrayList<ActivityPre> result=new ArrayList<>();
        for(int i=0;i<length;i++){
            ActivityPO activityPO=list.get(i);
            result.add(new ActivityPre(activityPO,schedule.getStartTime(),i));
        }
        return result;
    }
    public ArrayList getToDoPre(){
        ArrayList<ActivityPO> list=schedule.getActivityList();
        int length=list.size();
        ArrayList<ToDoPre> result=new ArrayList<>();
        for(int i=0;i<length;i++){
            ActivityPO activityPO=list.get(i);
            result.add(new ToDoPre(activityPO,schedule.getStartTime(),i));
        }
        return result;
    }

}
