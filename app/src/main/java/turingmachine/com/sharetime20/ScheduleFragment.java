package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.Fragment;
import android.app.LocalActivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
    private TextView textView1;
    private TextView textView2;
    private FrameLayout frameLayout;
    private ToDoListView toDoListView;
    private ListView listView;
   public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       scheduleView=new ScheduleView(this.getActivity());
        View scheduleLayout = LayoutInflater.from(getActivity()).inflate(R.layout.scheduleview,null);



    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        scheduleView=new ScheduleView(this.getActivity());
        View scheduleLayout = LayoutInflater.from(getActivity()).inflate(R.layout.scheduleview,null);
        Activity activity=getActivity();
        textView1=(TextView)activity.findViewById(R.id.changepanel1);
        textView2=(TextView)activity.findViewById(R.id.changepanel2);
        frameLayout=(FrameLayout)activity.findViewById(R.id.frame);
        listView=(ListView)activity.findViewById(R.id.listView);
        return scheduleLayout;
    }
    public void initView(){
        textView1.setOnClickListener(new Listener());
        textView2.setOnClickListener(new Listener());

    }
    public class Listener implements View.OnClickListener {
        public void onClick(View view){
            if(view.equals(textView1)){
                frameLayout.addView(scheduleView);frameLayout.removeView(toDoListView);
            }
            if(view.equals(textView2)){
                frameLayout.addView(toDoListView);frameLayout.removeView(scheduleView);
            }

        }

    }

}
