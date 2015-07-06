package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import businesslogic.contactbl.ContactsInfoController;
import netconnection.Config;
import netconnection.GetUserSchedule;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.ScheduleFragment;
import turingmachine.com.sharetime20.match_activity.MatchDetailActivity;
import turingmachine.com.sharetime20.match_activity.MatchDetailFragment;

public class ContactInfoActivity extends Activity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ContactInfoFragment contactInfoFragment;
    private TextView tv_back;
    private ScheduleFragment scheduleFragment;
    private ContactsInfoController contactsInfoController;
    private MatchDetailFragment matchDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        fragmentManager=getFragmentManager();
        contactsInfoController=new ContactsInfoController();
        initViews();
        scheduleFragment=new ScheduleFragment();
        matchDetailFragment=new MatchDetailFragment();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_contactinfo,contactInfoFragment);
        fragmentTransaction.commit();
    }
    public void toSchedule(View view){
       System.out.println("get contact schedule");
        int id=getIntent().getIntExtra("id",0);
        System.out.println(Config.getCachedId(this)+"#"+id+"#");
        GetUserSchedule getUserSchedule=new GetUserSchedule(Config.getCachedId(this),id+"",scheduleFragment);
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_contactinfo,scheduleFragment);
        fragmentTransaction.commit();
    }
    public void bMatch(View view){
        Intent i=new Intent(ContactInfoActivity.this, MatchDetailActivity.class);
        //TODO 传输联系人id
        int id=getIntent().getIntExtra("id",0);
        i.putExtra("id",id);
        startActivity(i);
//        matchDetailFragment.setContent(scheduleFragment);
//        fragmentManager=getFragmentManager();
//        fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.main_content_in_contactinfo,scheduleFragment);
//        fragmentTransaction.commit();
    }
    public void initViews(){
        contactInfoFragment=new ContactInfoFragment();

        tv_back= (TextView) findViewById(R.id.tv_back_in_contactinfo);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
