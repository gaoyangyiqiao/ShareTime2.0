package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.app.LocalActivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 2015/3/28.
 * 这个类用于管理schedule界面
 */
public class ScheduleFragment extends Fragment {
    private ScheduleView scheduleView;

   public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        View scheduleLayout = LayoutInflater.from(getActivity()).inflate(R.layout.activity_schedule,null);
        scheduleView=new ScheduleView(null);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View scheduleLayout = inflater.inflate(R.layout.activity_schedule,container,false);
        scheduleView=new ScheduleView(null);


        return scheduleLayout;
    }

}
