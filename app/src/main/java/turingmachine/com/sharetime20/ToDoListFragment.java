package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hello on 2015/4/20.
 */
public class ToDoListFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingLayout = inflater.inflate(R.layout.activity_todolist,
                container, false);
        return settingLayout;
    }
}
