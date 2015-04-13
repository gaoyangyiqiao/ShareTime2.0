package po;
//节点类，就是把schedule看做一个链表，这个相当于他的节点
public class ScheduleNode {
    LinkList<ActivityItem> aList;
    TimeNode time;//每个节点包含一个时间节点
    ScheduleNode next;//指向下一个节点
    public ScheduleNode( LinkList<ActivityItem> aList, TimeNode time, ScheduleNode next){
        this.aList=aList;
        this.time=time;
        this.next=next;
    }
    public void addActivity(ActivityItem item){
        aList.insert(item);
        item.addTime(time);
    }
    public String toString(){
        return "#ScheduleNode,"+aList.toString()+","+time.toString()+","+next.toString();
    }
    public String getActivity(){
        return null;
    }


}
