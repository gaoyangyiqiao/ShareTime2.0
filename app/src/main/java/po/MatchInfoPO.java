package po;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by gaoyang on 15/3/25.
 */
public class MatchInfoPO {

    private int id;
    private Date time;
    private ArrayList<TimeNode> timeList;
    private User owner;
    private ArrayList<User> parList;

    public MatchInfoPO(int id,Date time, ArrayList<TimeNode> timeList, User owner, ArrayList<User> parList){
        this.id = id;
        this.time = time;
        this.timeList = timeList;
        this.owner = owner;
        this.parList = parList;
    }

    public int getId(){
        return id;
    }

    public ArrayList<TimeNode> getTimeList(){
        return timeList;
    }

    public String getMatchTimeStr(){
        String str = getTimeNodeStr(timeList.get(0));
        if(timeList.size() > 2){
            for(int i = 0;i <= timeList.size() - 1;i ++){
                str += " ";
                str += getTimeNodeStr(timeList.get(i));
            }
        }
        return str;
    }

    private String getTimeNodeStr(TimeNode node){
        return node.getStartTime().toString()+"~"+node.getEndTime();
    }

    public User getOwner(){
        return owner;
    }

    public Date getMatchHappenTime(){
        return time;
    }

    public String getHappenTimeStr(){
        String str = time.toString();
        return str;
    }

    public ArrayList<User> getParList(){
        return parList;
    }

    public String getMemberStr(){
        String str = parList.get(0).getInf("name").toString();
        if(parList.size() > 1){
            for(int i = 1;i <= parList.size() - 1;i++){
                str += ",";
                str += parList.get(i).getInf("name");
            }
        }
        return str;
    }
}
