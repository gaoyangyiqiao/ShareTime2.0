package po;

import java.util.ArrayList;

/**
 * Created by admin on 2015/4/13.
 */
public class ActivityDetailPO {
    private String id;
    private LinkList<TimeNode> timeList;
    private User owner;//发起者
    private int right;//活动的对外权限
    private String theme;
    private String event;
    private Contacts parList;//参与人员列表
    private int numOfPar;
    public ActivityDetailPO(String id, LinkList<TimeNode> timeList,User owner,int right,String theme,String event, Contacts parList){
        this.id = id;
        this.timeList=timeList;
        this.owner=owner;
        this.right=right;
        this.theme=theme;
        this.event=event;
        this.parList=parList;
        numOfPar=parList.theTotalNumOfContacts();
    }
    public void setRiht(int i){
        right=i;
    }
    public void addPar(User par){
        parList.addContacts(par);
        numOfPar++;
    }
    public void delPar(User par){
        parList.delectContacts(par);
        numOfPar--;
    }
    public int getNumOfPar(){
        return numOfPar;
    }
    public void addTime(TimeNode time){
        timeList.insert(time);
    }
    public void delTime(TimeNode time){
        timeList.delect(time);
    }
    public User getUser(){
        return owner;
    }
    public String getTheme(){return theme;}
    public String getEvent(){
        return event;
    }
    public LinkList<TimeNode> getTimeList(){
        return timeList;
    }
    public Contacts getParList(){
        return parList;
    }
    public String getId(){
        return id;
    }
    public String toString(){
        return "#ActivityItem,"+timeList.toString()+","+owner.toString()+","+right+","+theme+","+event+","+parList.toString()+","+numOfPar;
    }
    public String getTimeStr(){
        return timeList.toString();
    }

    public ArrayList<EventDetailFriendItem> getMembersListInfo(){
        return null;//待实现
    }
}
