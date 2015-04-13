package po;

import java.util.Date;

/**
 * Created by gaoyang on 15/3/25.
 */
public class MatchInfoPO {

    private int id;
    private Date time;
    private LinkList<TimeNode> timeList;
    private User owner;
    private Contacts parList;

    public MatchInfoPO(int id,Date time, LinkList<TimeNode> timeList, User owner, Contacts parList){
        this.id = id;
        this.time = time;
        this.timeList = timeList;
        this.owner = owner;
        this.parList = parList;
    }

    public int getId(){
        return id;
    }

    public LinkList<TimeNode> getTimeList(){
        return timeList;
    }

    public String getMatchTimeStr(){
        return null;
    }

    public User getOwner(){
        return owner;
    }

    public Date getMatchHappenTime(){
        return time;
    }

    public String getHappenTimeStr(){
        return null;//待实现
    }

    public Contacts getParList(){
        return parList;
    }

    public String getMemberStr(){
        return null;//待实现
    }
}
