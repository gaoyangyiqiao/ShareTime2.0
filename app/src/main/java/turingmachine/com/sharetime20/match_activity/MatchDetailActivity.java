package turingmachine.com.sharetime20.match_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import netconnection.AddActivity;
import netconnection.Config;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.ScheduleFragment;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapButton;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapEditText;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;

public class MatchDetailActivity extends Activity {
    private TextView tv_back;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MatchDetailFragment matchDetailFragment;
    private ScheduleFragment scheduleFragment;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        initViews();
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_matchdetail,matchDetailFragment);
        fragmentTransaction.commit();

    }
    public void getMatchResult(){
    }
    public void buildMatch(View view){
        matchDetailFragment.setContent(scheduleFragment);
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_matchdetail,scheduleFragment);
        fragmentTransaction.commit();

    }
    public void returnBuild(View view){
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_matchdetail,matchDetailFragment);
        fragmentTransaction.commit();
    }
    public void initViews(){
        matchDetailFragment=new MatchDetailFragment();
        scheduleFragment=new ScheduleFragment();
        tv_back= (TextView) findViewById(R.id.tv_back_in_matchdetail);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

