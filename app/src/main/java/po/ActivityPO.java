package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by admin on 2015/4/29.
 */
public class ActivityPO {
    private String id;
    private String theme;
    private String content;
    private String founder;
    private Date receiveTime;
    private Date startTime;
    private Date endTime;
    private String contacts;
    private int right;//对外可见的权限

    public ActivityPO(){}

    public ActivityPO(String id,String theme,String content,String founder,Date receiveTime,
                      Date startTime,Date endTime,String contacts,int right){
        this.id = id;
        this.contacts = contacts;
        this.content = content;
        this.theme = theme;
        this.founder = founder;
        this.receiveTime = receiveTime;
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
    public String getReceiveTimeStr(){
        String result = String.format("%d/%d %d:%d",receiveTime.getMonth(),
                receiveTime.getDay(),receiveTime.getHours(),receiveTime.getMinutes());
        return result;
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
}
