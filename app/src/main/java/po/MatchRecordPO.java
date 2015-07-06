package po;

/**
 * Created by gaoyang on 15/7/6.
 */
public class MatchRecordPO {
    private String user_id;
    private String user_id_array;
    private String begin_time;
    private String end_time;

    public MatchRecordPO(String user_id,String user_id_array,String begin_time,String end_time){
        setBegin_time(begin_time);
        setEnd_time(end_time);
        setUser_id(user_id);
        setUser_id_array(user_id_array);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id_array() {
        return user_id_array;
    }

    public void setUser_id_array(String user_id_array) {
        this.user_id_array = user_id_array;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
