package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import turingmachine.com.sharetime20.swipeview.SwipeMenuListView;

/**
 * Created by hello on 2015/5/31.
 */
public class TabHostFragment extends Fragment {
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private FrameLayout frame;
    private ScheduleFragment scheduleFragment;
    private ToDoListFragment toDoListFragment;
    private Button button;
    private SwipeMenuListView swipeMenuListView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchFragment = inflater.inflate(R.layout.activity_tabhost,container,false);
        fragmentManager = getFragmentManager();

        return matchFragment;

    }
    public void onViewCreated(View view, Bundle savedInstanceState) {

        scheduleFragment=new ScheduleFragment();
        toDoListFragment=new ToDoListFragment();

        button=(Button)getActivity().findViewById(R.id.ss2);
        swipeMenuListView=(SwipeMenuListView)getActivity().findViewById(R.id.listView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeMenuListView.setEnabled(false);
                newEvent();
                swipeMenuListView.setEnabled(true);
            }
        });
        //newEvent();
    }
    public void  b(View view) {
        toDoListFragment=new ToDoListFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,toDoListFragment);
        fragmentTransaction.commit();
    }
    public void a(View view) {
        scheduleFragment=new ScheduleFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,scheduleFragment);
        fragmentTransaction.commit();
    }
    public void newEvent(){

        LayoutInflater li = LayoutInflater.from(this.getActivity());
        View view = li.inflate(R.layout.activity_add_event, null);
        new AlertDialog.Builder(this.getActivity()).setTitle("新建活动").setIcon(
                    android.R.drawable.ic_dialog_info).setView(
              view).setPositiveButton("确定", null)
            .setNegativeButton("取消", null).show();
    }

}
