package po;

import java.util.ArrayList;
import java.util.Iterator;


/*
 * @author zfy
 * @date 2015/1/28
 * @description 这个类是属于user的时间表类，包括user可以支配的时间和在这些时间会发生的活动
 * @version 1.0
 * 
 */

public class Schedule extends LinkList {
    private ScheduleNode first;
    private ScheduleNode last;
    private int size;
    private int freeDate;

    public void insert(ScheduleNode node) {
        if (first == null) {
            first = node;
            size++;
            last = node;
        } else {
            last.next = node;
            last = last.next;
            size++;
        }
    }

    public void delect(ScheduleNode node) {

    }

    public void delectActivity(TimeNode timeNode, ActivityItem activity) {//某段时间内删除活动
        ScheduleNode temp = first;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            if (temp.time == timeNode) {
                temp.aList.delect(activity);
            }
        }

    }

    public void addActivity(TimeNode timeNode, ActivityItem activity) {//某段时间内增加活动
        ScheduleNode temp = first;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            if (temp.time == timeNode) {
                temp.addActivity(activity);
            }

        }
    }

    //设置某段时间有空，把alist设置成null，而默认的情况为一个新建的alist
    public void setFree(LinkList<TimeNode> timeList) {
        ScheduleNode temp = first;
        for (int i = 0; i < size; i++) {
            temp.aList = null;
            temp = temp.next;


        }
    }

    public TimeNode[] getFreeDate() {//空闲时间
        ArrayList<TimeNode> alist = new ArrayList<TimeNode>();
        ScheduleNode temp = first;
        while (temp != last) {
            if (temp.aList == null) {
                alist.add(temp.time);
            }
        }
        return (TimeNode[]) alist.toArray();
    }


    @Override
    public String toString() {
        return "#schedule" + "," + "first" + "," + first.toString() + "," + "last" + "," + last.toString() + "," + "size" + "," + size + "freeDate" + "," + freeDate;
    }

    public LinkList<ActivityItem> getActivity() {
        LinkList<ActivityItem> list = new LinkList<ActivityItem>();
        ScheduleNode temp = first;
        while (temp != null) {
            Iterator iter=temp.aList.iterator();
            while(iter.hasNext()){
                list.insert((ActivityItem)iter.next());
            }
            temp=temp.next;
        }
        return list;
    }

}



