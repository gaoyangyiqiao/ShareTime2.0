package turingmachine.com.sharetime20.match_activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import turingmachine.com.sharetime20.R;

public class MatchDetailActivity extends Activity {
    private TextView tv_back;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MatchDetailFragment matchDetailFragment;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        initViews();

        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_matchdetail,matchDetailFragment);
        fragmentTransaction.commit();

    }

    public void initViews(){
        matchDetailFragment=new MatchDetailFragment();
        tv_back= (TextView) findViewById(R.id.tv_back_in_matchdetail);
    }
}

