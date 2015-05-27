package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends Activity implements OnClickListener{
    private ContactsFragment contactsFragment;
    private MatchFragment matchFragment;
    private ScheduleFragment scheduleFragment;
    public View contactsLayout;
    public View matchLayout;
    public View scheduleLayout;
    private FragmentManager fragmentManager;
    private ImageView iv_contacts;
    private ImageView iv_match;
    private ImageView iv_schedule;
    private TextView tv_contacts;
    private TextView tv_match;
    private TextView tv_schedule;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }

    private void initViews(){
        contactsLayout = findViewById(R.id.tab_main_contact);
        matchLayout = findViewById(R.id.tab_main_match);
        scheduleLayout = findViewById(R.id.tab_main_schedule);
        iv_contacts = (ImageView)findViewById(R.id.img_contacts);
        iv_match = (ImageView)findViewById(R.id.img_match);
        iv_schedule = (ImageView)findViewById(R.id.img_schedule);
        tv_contacts = (TextView)findViewById(R.id.tv_main_contacts);
        tv_match = (TextView)findViewById(R.id.tv_main_match);
        tv_schedule = (TextView)findViewById(R.id.tv_main_schedule);
        contactsLayout.setOnClickListener(this);
        matchLayout.setOnClickListener(this);
        scheduleLayout.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.tab_main_schedule:
                setTabSelection(0);
                break;
            case R.id.tab_main_match:
                setTabSelection(1);
                break;
            case R.id.tab_main_contact:
                setTabSelection(2);
                break;
            default:
                break;
        }
    }

    private void setTabSelection(int index){
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了日程tab时，改变控件的图片和文字颜色
                iv_schedule.setImageResource(R.drawable.tab_schedule_pressed);
                tv_schedule.setTextColor(Color.WHITE);
                if (scheduleFragment == null) {
                    // 如果ScheduleFragment为空，则创建一个并添加到界面上
                    scheduleFragment = new ScheduleFragment();
                    transaction.add(R.id.main_content, scheduleFragment);
                } else {
                    // 如果MScheduleFragment不为空，则直接将它显示出来
                    transaction.show(scheduleFragment);
                }
                break;
            case 1:
                // 当点击了匹配tab时，改变控件的图片和文字颜色
                iv_match.setImageResource(R.drawable.tab_match_pressed);
                tv_match.setTextColor(Color.WHITE);
                if (matchFragment == null) {
                    // 如果MatchFragment为空，则创建一个并添加到界面上
                    matchFragment = new MatchFragment();
                    transaction.add(R.id.main_content, matchFragment);
                } else {
                    // 如果MatchFragment不为空，则直接将它显示出来
                    transaction.show(matchFragment);
                }
                break;
            case 2:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                iv_contacts.setImageResource(R.drawable.tab_contacts_pressed);
                tv_contacts.setTextColor(Color.WHITE);
                if (contactsFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.main_content, contactsFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(contactsFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    //清除所有的选择状态
    private void clearSelection(){
        iv_contacts.setImageResource(R.drawable.tab_contacts);
        iv_match.setImageResource(R.drawable.tab_match);
        iv_schedule.setImageResource(R.drawable.tab_schedule);
        //以下缺少字体颜色的设定
    }

    private void hideFragments(FragmentTransaction fragmentTransaction){
        if(contactsFragment != null){
            fragmentTransaction.hide(contactsFragment);
        }
        if(matchFragment != null){
            fragmentTransaction.hide(matchFragment);
        }
        if(scheduleFragment != null){
            fragmentTransaction.hide(scheduleFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_settings_add_friend:
//                Intent i=new Intent(MainActivity.this, PhoneContactsActivity.class);
//                startActivity(i);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
