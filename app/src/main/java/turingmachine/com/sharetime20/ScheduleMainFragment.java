package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by hello on 2015/4/20.
 */
public class ScheduleMainFragment extends Fragment{
    private ToDoListFragment toDoListFragment;
    private ScheduleFragment scheduleFragment;
    private FragmentManager fragmentManager;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingLayout = inflater.inflate(R.layout.activity_schedulemain,
                container, false);
        fragmentManager=getFragmentManager();
        return settingLayout;
    }
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        View scheduleLayout = LayoutInflater.from(getActivity()).inflate(R.layout.activity_schedulemain,null);
        //(Window.FEATURE_NO_TITLE);
        setTabSelection(0);

    }
    public void initViews(){

    }
    private void setTabSelection(int index){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        switch(index){
            case 0:
                if(toDoListFragment==null){
                    toDoListFragment=new ToDoListFragment();
                    fragmentTransaction.add(R.id.content,toDoListFragment);
                }
                else fragmentTransaction.show(toDoListFragment);
                break;
            case 1:
                if(scheduleFragment==null){
                    scheduleFragment=new ScheduleFragment();
                   fragmentTransaction.add(R.id.tabHost,scheduleFragment);
                }
                else fragmentTransaction.show(scheduleFragment);
                break;
        }
    }
}
