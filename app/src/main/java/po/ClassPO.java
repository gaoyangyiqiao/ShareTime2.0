package po;

import java.util.Date;

/**
 * Created by gaoyang on 15/5/18.
 */
public class ClassPO {

    public String name;
    public String place;
    public Date begin_time;
    public Date end_time;

    public ClassPO(String name,String place,Date begin_time,Date end_time){
        setName(name);
        setPlace(place);
        setBegin_time(begin_time);
        setEnd_time(end_time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
