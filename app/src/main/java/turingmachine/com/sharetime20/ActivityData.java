package turingmachine.com.sharetime20;

import java.util.ArrayList;

import po.ActiviryPO;
import po.ActivityDetailPO;

/**
 * Created by hello on 2015/4/24.
 */
public class ActivityData {
    private ActiviryPO activiryPO;
    private int length;
    private String content;
    //以下的坐标反应的是该活动在表格里的位置,从1开始编号
    private int startx;
    private int starty;

    public int getStartx() {
        return startx;
    }

    public void setStartx(int startx) {
        this.startx = startx;
    }
    public int getStarty(){
        return starty;
    }

    private int endx;
    private int endy;
    public int getEndx(){
        return endx;
    }
    public int getEndy(){
        return endy;
    }
    public ActivityData(ActiviryPO activityPO,int length){
        this.activiryPO=activityPO;
        this.length=0;
    }
    public String getContent(){
        return content;
    }

}
