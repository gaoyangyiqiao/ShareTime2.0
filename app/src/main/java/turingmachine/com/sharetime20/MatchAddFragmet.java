package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by hello on 2015/6/5.
 */
public class MatchAddFragmet extends Fragment {
    private ListView listView;
    private static final String[] strs = new String[] {
        "first", "second", "third", "fourth", "fifth"
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchAddFragment = inflater.inflate(R.layout.activity_match_add,container,false);
        return matchAddFragment;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView=(ListView)getActivity().findViewById(R.id.listView2);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strs));


    }
}
