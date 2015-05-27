package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.MatchListItemAdapter;
import matchBL.GetMatchInfoList;
import matchBL.MatchBL;
import turingmachine.com.sharetime20.match_activity.MatchChooseContactsActivity;
import turingmachine.com.sharetime20.match_activity.MatchDetailActivity;
import po.MatchInfoPO;

/**
 * Created by admin on 2015/3/28.
 */
public class MatchFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchFragment = inflater.inflate(R.layout.activity_match,container,false);
        return matchFragment;
    }


}
