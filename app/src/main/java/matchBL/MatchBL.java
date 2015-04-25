package matchBL;

import java.util.ArrayList;
import java.util.Date;

import po.CheckedImgPO;
import po.ContactPO;
import po.MatchInfoPO;

/**
 * Created by admin on 2015/4/11.
 */
public class MatchBL {
    //TODO

    public static ArrayList<ContactPO> data ;

    public static void setContactList(ArrayList<ContactPO> newData){
        data = newData;
    }

    public static ArrayList<MatchInfoPO> getMatchInfoList(){
        return null;
    }

    public static ArrayList<CheckedImgPO> getCheckerImgList(){
       return null;
    }

    public static MatchInfoPO getMatchResult(int[] position){
        return null;
    }
}
