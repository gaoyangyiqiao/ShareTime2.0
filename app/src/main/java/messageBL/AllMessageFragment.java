package messageBL;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/11.
 */
public class AllMessageFragment extends ListFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contactsFragment = inflater.inflate(R.layout.activity_contacts,container,false);
        return contactsFragment;
    }
}
