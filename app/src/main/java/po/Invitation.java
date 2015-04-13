package po;

import java.util.Date;

public class Invitation {
    private int id;
    private User sender;
    private Contacts receiver;//接收人列表
    private ActivityItem event;
    private Date startTime;
    private int state;//邀请的状态，比如是否送达，是否接收
    public Invitation(User sender, Contacts receiver, ActivityItem event, Date startTime){
        this.sender=sender;
        this.receiver=receiver;
        this.event=event;
        this.startTime=startTime;
        state=0;
        id=getMax();
    }
    public Invitation(int id, User sender, Contacts receiver, ActivityItem event, Date startTime, int state){
        this(sender, receiver, event, startTime);
        this.state=state;
        this.id=id;
    }
    public int getMax(){
        return 0;
    }

    public int getId(){
        return id;
    }

    public User getUser(){
        return sender;
    }

    public Contacts getReceiver(){
        return receiver;
    }

    public ActivityItem getItem(){
        return event;
    }

    public Date getStartTime(){
        return startTime;
    }

    public int getState(){
        return state;
    }
    public String toString(){
        return "#Invitation,id," + id + ",sender," + sender.toString() + ",receiver," + receiver.toString()
                + ",event," + event.toString() + ",start," + startTime.toString() + ",state," + new Integer(state).toString() ;
    }
}
