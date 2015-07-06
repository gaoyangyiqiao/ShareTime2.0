package po;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import turingmachine.com.sharetime20.weekview.WeekViewEvent;

/**
 * Created by hello on 2015/7/6.
 */
public class RecordPO implements Serializable {
    public ArrayList<WeekViewEvent> getEventList(){
        ArrayList<WeekViewEvent> list=new ArrayList<WeekViewEvent>();
        return list;
    }
}
