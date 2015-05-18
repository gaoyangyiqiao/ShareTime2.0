package po;

/**
 * Created by gaoyang on 15/5/18.
 */
public class ClassPO {

    private String className;
    private String place;
    private String whichDay;//Monday
    private String section;//5-7
    private String whichWeek;//0||1||1-16

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWhichDay() {
        return whichDay;
    }

    public void setWhichDay(String whichDay) {
        this.whichDay = whichDay;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getWhichWeek() {
        return whichWeek;
    }

    public void setWhichWeek(String whichWeek) {
        this.whichWeek = whichWeek;
    }
}
