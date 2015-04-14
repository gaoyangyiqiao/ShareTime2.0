package matchBL;

import java.util.ArrayList;
import java.util.Date;

import po.ContactPO;
import po.Contacts;
import po.LinkList;
import po.MatchInfoPO;
import po.Schedule;
import po.TimeNode;
import po.User;

/**
 * Created by admin on 2015/4/11.
 */
public class MatchBL {

    public static ArrayList<ContactPO> data ;

    public static void setContactList(ArrayList<ContactPO> newData){
        data = newData;
    }

    public static ArrayList<MatchInfoPO> getMatchInfoList(){
        ArrayList<MatchInfoPO> list = new ArrayList<MatchInfoPO>();
        Date date = new Date();
        Date start = new Date();
        start.setHours(20);
        start.setMinutes(30);
        Date end = new Date();
        end.setHours(21);
        end.setMinutes(0);
        TimeNode node = new TimeNode(start,end);
        ArrayList<TimeNode> nodes = new ArrayList<TimeNode>();
        nodes.add(node);
        User user = new User(null,null,1,"yindi","15850550557",null);
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User(null,null,2,"hehe","100000",null));
        userList.add(new User(null,null,3,"heheda","100000",null));
        list.add(new MatchInfoPO(1,date,nodes,user,userList));
        return list;
    }

    public static ArrayList<CheckedImg> getCheckerImgList(){
        ArrayList<CheckedImg> result = new ArrayList<CheckedImg>();
        if(data == null||data.size() == 0){
            return result;
        }
        else{
            for(int i = 0;i <= data.size() - 1;i++){
                CheckedImg img = new CheckedImg();
                img.setImg(data.get(i).getImageurl());
                img.setId(String.valueOf(i));
                img.setName(data.get(i).getName());
            }
            return result;
        }
    }

    public static MatchInfoPO getMatchResult(int[] position){
        return null;
    }
}
