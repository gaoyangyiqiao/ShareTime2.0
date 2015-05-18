package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.Fragment;
import android.app.LocalActivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
     //  private ToDoListView toDoListView;
    private ListView listView;
   public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       scheduleView=new ScheduleView(this.getActivity());
        View scheduleLayout = LayoutInflater.from(getActivity()).inflate(R.layout.tabhost,null);
       Activity activity=getActivity();
       textView1=(TextView)activity.findViewById(R.id.textview1);
       textView2=(TextView)activity.findViewById(R.id.textview2);
       frameLayout=(FrameLayout)activity.findViewById(R.id.frame);
       listView=(ListView)scheduleLayout.findViewById(R.id.listView);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        scheduleView=new ScheduleView(this.getActivity());
        View scheduleLayout = LayoutInflater.from(getActivity()).inflate(R.layout.tabhost,null);

        textView1=(TextView)scheduleLayout.findViewById(R.id.textview1);
        textView2=(TextView)scheduleLayout.findViewById(R.id.textview2);
        frameLayout=(FrameLayout)scheduleLayout.findViewById(R.id.frame);

        System.out.println(textView1.getText());
        //textView1.setOnClickListener(null);
        //textView2.setOnClickListener(null);
        listView=(ListView)scheduleLayout.findViewById(R.id.listView);
       // String [] arr={"a","b","c","d"};
      //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,arr);
        //listView.setAdapter(adapter);
       //frameLayout.addView(scheduleView);
       initView();
        return scheduleLayout;
    }
    public void initView(){
        textView1.setOnClickListener(new Listener());
        textView2.setOnClickListener(new Listener());

    }
    public class Listener implements View.OnClickListener {
        public void onClick(View view){
            if(view.equals(textView1)){
               scheduleView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);

            }
            if(view.equals(textView2)){
                scheduleView.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);

            }

        }

    }

}
