package turingmachine.com.sharetime20;

import java.util.ArrayList;

import po.ScheduleConfig;
import po.SchedulePO;

/**
 * Created by hello on 2015/4/24.
 */
public class ScheduleData {
    private String[] weekdays;
    private SchedulePO schedulePO;
    private String[] week = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    private int dayNum = ScheduleConfig.days;
    private int starWeekDay;

    public ScheduleData() {

    }

    public String[] getWeekdays() {
        weekdays = new String[dayNum];
        for (int i = 0; i < dayNum; i++) {
            weekdays[i] = week[(starWeekDay + i) / 7];
        }
        return weekdays;
    }

    public ScheduleData(SchedulePO schedulePO) {
        this.schedulePO = schedulePO;
    }

    public ArrayList<ActivityData> getActivity() {


        return null;
    }
}
