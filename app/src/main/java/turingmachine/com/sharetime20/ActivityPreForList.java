package turingmachine.com.sharetime20;

import java.util.Date;

import po.ActivityPO;

/**
 * Created by hello on 2015/5/3.
 * description 这个类用来规定todolist上的item
 */
public class ActivityPreForList {
    private ActivityPO po;
    private int index;
    private int perNum;//参与人数
    private Date startTime;
    private Date endTime;
    private String content;
    public  ActivityPreForList(ActivityPO po){
        this.po=po;
        this.startTime=po.getStartTime();
        this.endTime=po.getEndTime();
        this.content=po.getContent();
        this.perNum=po.getNumOfPer();
    }
}
