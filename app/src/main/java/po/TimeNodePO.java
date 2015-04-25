package po;

import java.util.Date;

/**
 * Created by admin on 2015/4/12.
 */
public class TimeNodePO {
    private Date start;
    private Date end;
    public TimeNodePO(Date start,Date end){
        this.start = start;
        this.end = end;
    }
    public void setStart(Date start){
        this.start = start;
    }
    public Date getStart(){
        return start;
    }
    public void setEnd(Date end){
        this.end = end;
    }
    public Date getEnd(){
        return end;
    }
    public String getStr(){
        String str1 = String.format("%d月%d日%d:%d",start.getMonth(),start.getDay(),
                start.getHours(),start.getMinutes());
        String str2 = String.format("%d月%d日%d:%d",end.getMonth(),end.getDay(),
                end.getHours(),end.getMinutes());
        return str1+"--"+str2;
    }
}
