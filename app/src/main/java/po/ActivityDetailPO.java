package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by admin on 2015/4/13.
 */
public class ActivityDetailPO {

    private String id;
    private Date receiveTime;
    private ArrayList<TimeNodePO> timeList;
    private ContactPO founder;
    private int right;//活动的对外可见权限
    private String theme;
    private String content;
    private ArrayList<ContactPO> members;
    private int numOfMembers;
    public ActivityDetailPO(Date receiveTime,String id,ArrayList<TimeNodePO> timeList,ContactPO founder,int right,
                            String theme,String content,ArrayList<ContactPO> members){
        this.id = id;
        this.receiveTime = receiveTime;
        this.timeList = timeList;
        this.founder = founder;
        this.right = right;
        this.theme = theme;
        this.content = content;
        this.members = members;
        this.numOfMembers = members.size();
    }
    public String getId(){
        return id;
    }
    public ArrayList<TimeNodePO> getTimeList(){
        return timeList;
    }
    public ContactPO getFounder(){
        return founder;
    }
    public int getRight(){
        return right;
    }
    public String getTheme(){
        return theme;
    }
    public String getContent(){
        return content;
    }
    public ArrayList<ContactPO> getMembers(){
        return members;
    }
    public int getNumOfMembers(){
        return numOfMembers;
    }
    public String getFounderIconStr(){
        return founder.getImageurl();
    }
    public ArrayList<String> getMemberIconsStr(){
        ArrayList<String> result = new ArrayList<String>();
        if(members.size() == 0){
            return result;
        }
        else{
            for(ContactPO po:members){
                result.add(po.getImageurl());
            }
            return result;
        }
    }
    public String getTimeStr(){
        if(this.getTimeList().size() == 0){
            return "-";
        }
        else{
            if(this.getTimeList().size() == 1){
                return this.getTimeList().get(0).getStr();
            }
            else{
                String result = this.getTimeList().get(0).getStr();
                for(int i = 1;i < this.getTimeList().size();i++){
                    result += ";";
                    result += this.getTimeList().get(i).getStr();
                }
                return result;
            }
        }
    }
    public String getReceiveTimeStr(){
        return String.format("%d/%d/%d %2d:%2d:&2d",receiveTime.getYear(),receiveTime.getMonth(),
                receiveTime.getDay(),receiveTime.getHours(),receiveTime.getMinutes(),receiveTime.getSeconds());
    }
}
