package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by hello on 2015/5/31.
 */
public class TabHostFragment extends Fragment {
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private FrameLayout frame;
    private ScheduleFragment scheduleFragment;
    private ToDoListFragment toDoListFragment;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchFragment = inflater.inflate(R.layout.activity_tabhost,container,false);
        fragmentManager = getFragmentManager();
        return matchFragment;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        scheduleFragment=new ScheduleFragment();
        toDoListFragment=new ToDoListFragment();
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

}
