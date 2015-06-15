package businesslogic.schedulebl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hello on 2015/4/13.
 */
public class DateToString {
    static String toString(Date time){
        SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");//时间格式化，注意空格要变成加号
        return from.format(time);
    }
}
