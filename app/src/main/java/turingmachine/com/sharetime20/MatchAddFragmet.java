package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hello on 2015/6/5.
 */
public class MatchAddFragmet extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchAddFragment = inflater.inflate(R.layout.activity_settings,container,false);
        return matchAddFragment;
    }
}
