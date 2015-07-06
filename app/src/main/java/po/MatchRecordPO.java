package po;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gaoyang on 15/7/6.
 */
public class MatchRecordPO implements Parcelable{
    private String user_id;
    private String user_id_array;
    private String begin_time;
    private String end_time;
    private String title;

    public MatchRecordPO(String user_id,String user_id_array,String begin_time,String end_time,String title){
        setBegin_time(begin_time);
        setEnd_time(end_time);
        setUser_id(user_id);
        setUser_id_array(user_id_array);
        setTitle(title);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getUser_id());
        dest.writeString(getUser_id_array());
        dest.writeString(getBegin_time());
        dest.writeString(getEnd_time());
    }

    public static final Parcelable.Creator<MatchRecordPO> CREATOR = new Creator<MatchRecordPO>()
    {
        @Override
        public MatchRecordPO[] newArray(int size)
        {
            return new MatchRecordPO[size];
        }

        @Override
        public MatchRecordPO createFromParcel(Parcel in)
        {
            return new MatchRecordPO(in);
        }
    };

    public MatchRecordPO(Parcel in)
    {
        user_id = in.readString();
        user_id_array = in.readString();
        begin_time = in.readString();
        end_time=in.readString();
        title=in.readString();
    }
}
