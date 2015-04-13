package matchBL;

import java.util.ArrayList;

import po.ContactPO;
import po.MatchInfoPO;

/**
 * Created by admin on 2015/4/11.
 */
public class MatchBL {

    public static ArrayList<ContactPO> data ;

    public static void setContactList(ArrayList<ContactPO> newData){
        data = newData;
    }

    public static ArrayList<MatchInfoPO> getMatchInfoList(){
        return null;
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
