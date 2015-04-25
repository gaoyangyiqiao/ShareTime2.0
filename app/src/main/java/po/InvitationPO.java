package po;

import java.util.ArrayList;

/**
 * Created by gaoyang on 15/3/25.
 */
public class InvitationPO {//邀请信息，包括邀请发送人和具体的邀请信息

    private String id;
    private ContactPO sender;
    private ActivityDetailPO detail;

    public InvitationPO(String id,ContactPO sender, ActivityDetailPO detail){
        this.id = id;
        this.detail = detail;
        this.sender = sender;
    }

    public String getId(){
        return id;
    }

    public ContactPO getSender(){
        return sender;
    }

    public ActivityDetailPO getDetail(){
        return detail;
    }

    public String getSenderIconUrl(){
        return sender.getImageurl();
    }

    public String getTimeStr(){
        ArrayList<TimeNodePO> timeList = detail.getTimeList();
        if(timeList.size() == 0){
            return "-";
        }
        else{
            String result = timeList.get(0).getStr();
            if(timeList.size() == 0){
                return result;
            }
            else{
                for(int i = 1;i < timeList.size();i++){
                    result += ";";
                    result += "\n";
                    result += timeList.get(i).getStr();
                }
                return result;
            }
        }
    }
}
