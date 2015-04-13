package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import turingmachine.com.sharetime20.Listener;

/**
 * Created by admin on 2015/3/28.
 * 这个类用于管理schedule界面
 */
public class ScheduleFragment extends Fragment {
    private ImageButton imageButtonLeft;//日期后退
    private ImageButton imageButtonRight;//日期前进
    private TextView[] tlist;//展示schedule用的组件
    private ListView listview;//
    private View view;
    private ArrayList<TextView> listForTV;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View scheduleLayout = inflater.inflate(R.layout.activity_schedule,container,false);
        this.view=scheduleLayout;
        init(null);
        return scheduleLayout;
    }
    public void init(String[] schedule){

        imageButtonLeft=(ImageButton)view.findViewById(R.id.imageButton);
        imageButtonRight=(ImageButton)view.findViewById(R.id.imageButton2);
       Listener listener1=new Listener("up",tlist);
        Listener listener2=new Listener("down",tlist);
        imageButtonLeft.setOnClickListener(listener2);
        imageButtonRight.setOnClickListener(listener1);
        listForTV=new ArrayList<TextView>();
        tlist=new TextView[3];
        tlist[0]=(TextView)view.findViewById(R.id.textView);
        tlist[1]=(TextView)view.findViewById(R.id.textView2);
        tlist[2]=(TextView)view.findViewById(R.id.textView3);
        listForTV.add((TextView)view.findViewById(R.id.TV11));
        listForTV.add((TextView)view.findViewById(R.id.TV12));
        listForTV.add((TextView)view.findViewById(R.id.TV13));
        listForTV.add((TextView)view.findViewById(R.id.TV14));
        listForTV.add((TextView)view.findViewById(R.id.TV15));
        listForTV.add((TextView)view.findViewById(R.id.TV16));
        listForTV.add((TextView)view.findViewById(R.id.TV17));
        listForTV.add((TextView)view.findViewById(R.id.TV18));
        listForTV.add((TextView)view.findViewById(R.id.TV21));
        listForTV.add((TextView)view.findViewById(R.id.TV22));
        listForTV.add((TextView)view.findViewById(R.id.TV23));
        listForTV.add((TextView)view.findViewById(R.id.TV24));
        listForTV.add((TextView)view.findViewById(R.id.TV25));
        listForTV.add((TextView)view.findViewById(R.id.TV26));
        listForTV.add((TextView)view.findViewById(R.id.TV27));
        listForTV.add((TextView)view.findViewById(R.id.TV28));
        listForTV.add((TextView)view.findViewById(R.id.TV31));
        listForTV.add((TextView)view.findViewById(R.id.TV32));
        listForTV.add((TextView)view.findViewById(R.id.TV33));
        listForTV.add((TextView)view.findViewById(R.id.TV34));
        listForTV.add((TextView)view.findViewById(R.id.TV35));
        listForTV.add((TextView)view.findViewById(R.id.TV36));
        listForTV.add((TextView)view.findViewById(R.id.TV37));
        listForTV.add((TextView)view.findViewById(R.id.TV38));
        assignSchedule(null);
    }
    //布置activity
    public void  assignSchedule(String[] schedule){
listForTV.get(0).setText("Are you here.");
        listForTV.get(1).setText("I am here.");
    }
    //新建活动
    public void newActivity(){

    }
    public void delActivity(){

    }
   public void back(){

   }
    public void forward(){

    }
}
