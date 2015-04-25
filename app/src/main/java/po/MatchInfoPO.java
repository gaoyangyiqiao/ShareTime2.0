package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by gaoyang on 15/3/25.
 */
public class MatchInfoPO {
    private String id;
    private ArrayList<TimeNodePO> timeList;
    private ContactPO owner;
    private Date receiveTime;//获取该匹配相关信息的时间
    private ArrayList<ContactPO> members;
    public MatchInfoPO(String id,ArrayList<TimeNodePO> timeList,ContactPO owner,Date receiveTime,ArrayList<ContactPO> members){
        this.id = id;
        this.timeList = timeList;
        this.owner = owner;
        this.receiveTime = receiveTime;
        this.members = members;
    }
    public String getId(){
        return id;
    }
    public ArrayList<TimeNodePO> getTimeList(){
        return timeList;
    }
    public ContactPO getOwner(){
        return owner;
    }
    public Date getReceiveTime(){
        return receiveTime;
    }
    public ArrayList<ContactPO> getMembers(){
        return members;
    }
    public String getReceiveTimeStr(){
        return String.format("%d/%d/%d %2d:%2d:&2d",receiveTime.getYear(),receiveTime.getMonth(),
                receiveTime.getDay(),receiveTime.getHours(),receiveTime.getMinutes(),receiveTime.getSeconds());
    }
    public String getTimeListStr(){
        if(timeList.size() == 0){
            return "-";
        }
        else{
            if(timeList.size() == 1){
                return timeList.get(0).getStr();
            }
            else{
                String result = timeList.get(0).getStr();
                for(int i = 1;i < timeList.size();i++){
                    result += ";";
                    result += timeList.get(i).getStr();
                }
                return result;
            }
        }
    }
}
