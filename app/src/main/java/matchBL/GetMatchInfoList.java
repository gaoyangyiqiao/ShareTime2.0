package matchBL;

import java.util.ArrayList;

import po.MatchInfoPO;

/**
 * Created by admin on 2015/4/13.
 */
public class GetMatchInfoList {

    private static ArrayList<MatchInfoPO> data;

    public static void setMatchInfoList(ArrayList<MatchInfoPO> newData){
        data = newData;
    }

    public static ArrayList<MatchInfoPO> getData(){
        return data;
    }
}
