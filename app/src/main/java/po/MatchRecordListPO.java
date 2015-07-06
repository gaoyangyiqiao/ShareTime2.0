package po;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by gaoyang on 15/7/7.
 */
public class MatchRecordListPO implements Parcelable{
    public ArrayList<MatchRecordPO> matchRecords;
    public MatchRecordListPO(){
        this.matchRecords=new ArrayList<>();
    }

    public ArrayList<MatchRecordPO> getMatchRecords() {
        return matchRecords;
    }

    public void setMatchRecords(ArrayList<MatchRecordPO> matchRecords) {
        this.matchRecords = matchRecords;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<MatchRecordListPO> CREATOR = new Creator<MatchRecordListPO>()
    {
        @Override
        public MatchRecordListPO[] newArray(int size)
        {
            return new MatchRecordListPO[size];
        }

        @Override
        public MatchRecordListPO createFromParcel(Parcel in)
        {
            return new MatchRecordListPO(in);
        }
    };

    public MatchRecordListPO(Parcel in){
        matchRecords=in.readArrayList(MatchRecordPO.class.getClassLoader());
    }
}
