package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2015/3/28.
 */
public class SettingFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingFragment = inflater.inflate(R.layout.activity_settings,container,false);
        return settingFragment;
    }
}
