package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hello on 2015/6/5.
 */
public class SignupFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingFragment = inflater.inflate(R.layout.activity_signup,container,false);
        return settingFragment;
    }
}
