package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by admin on 2015/4/29.
 */
public class ActivityPO {
    private ArrayList<String> perName;
    private String id;
    private String theme;
    private String content;
    private String founder;
    private Date startTime;
    private Date endTime;
    private String contacts;
    private int right;//对外可见的权限
    public Date getStartTime(){
        return startTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public void setStartTime(Date  startTime){
        this.startTime=startTime;
    }
    public void setEndTime(Date endTime){
        this.endTime=endTime;
    }
    public void setContent(String content){
        this.content=content;
    }
    public ActivityPO(){}

    public ActivityPO(String id,String theme,String content,String founder,
                      Date startTime,Date endTime,String contacts,int right){
        this.id = id;
        this.contacts = contacts;
        this.content = content;
        this.theme = theme;
        this.founder = founder;
        this.startTime = startTime;
        this.endTime = endTime;
        this.right = right;
    }
    public String getId(){
        return id;
    }
    public String getTheme(){
        return theme;
    }
    public String getContent(){
        return content;
    }
    public String getFounder(){
        return founder;
    }
    public String getContacts(){
        return contacts;
    }
    public int getRight(){
        return right;
    }
    public void setRight(int right){
        this.right = right;
    }

    public String getStartTimeStr(){
        String result = String.format("%d/%d %d:%d",startTime.getMonth(),
                startTime.getDay(),startTime.getHours(),startTime.getMinutes());
        return result;
    }
    public String getEndTimeStr(){
        String result = String.format("%d/%d %d:%d",endTime.getMonth(),endTime.getDay(),
                endTime.getHours(),endTime.getMinutes());
        return result;
    }
    public int getNumOfPer(){
        return perName.size();
    }
}
