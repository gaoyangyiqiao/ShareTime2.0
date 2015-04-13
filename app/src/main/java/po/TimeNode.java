package po;

import java.util.Date;

//这个类用于定义适合系统的一段时间
public class TimeNode {
    //timeGap指的是一段时间的长度
    static final int timeGap=0;
    private Date startTime;
    private Date endTime;
    public TimeNode(Date startTime,Date endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }
    public Date getStartTime(){
        return startTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public String toString(){
        return "#TimeNode,"+startTime.toString()+","+endTime.toString();
    }

}
