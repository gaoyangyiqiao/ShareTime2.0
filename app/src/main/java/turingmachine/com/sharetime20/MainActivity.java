package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View.OnClickListener;

import com.nineoldandroids.view.ViewHelper;


import java.util.ArrayList;
import java.util.Random;

import turingmachine.com.sharetime20.draglayout.DragLayout;


public class MainActivity extends Activity implements OnClickListener{
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager2;
    private FrameLayout frame2;
    private ScheduleFragment scheduleFragment2;
    private ToDoListFragment toDoListFragment2;
    private DragLayout dl;
    private ContactsFragment contactsFragment;
    private MatchFragment matchFragment;
    private TabHostFragment scheduleFragment;
    private ToDoListFragment toDoListFragment;
    public View contactsLayout;
    public View matchLayout;
    public View scheduleLayout;
    public View todo;
    private FragmentManager fragmentManager;
    private ImageView iv_contacts;
    private ImageView iv_match;
    private ImageView iv_schedule;
    private ImageView iv_head_icon;
    private ImageView iv_drag_icon;
    private ListView info_list;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDragLayout();
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
        iv_head_icon = (ImageView) findViewById(R.id.iv_bottom);
        iv_drag_icon= (ImageView) findViewById(R.id.iv_icon);
        contactsLayout.setOnClickListener(this);
        matchLayout.setOnClickListener(this);
        scheduleLayout.setOnClickListener(this);

        dl= (DragLayout) findViewById(R.id.dl);
        info_list= (ListView) findViewById(R.id.lv_infolist);
        ArrayList info=new ArrayList();
        info.add("姓名");
        info.add("gaoyang");
        info.add("账号");
        info.add("001");
        info.add("对外权限");
        info.add("可见");
        info.add("学号");
        info.add("131250043");
        info.add("导入教务网");
        info.add("");
        info_list.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                R.layout.item_text, new String[]{"NewBee", "gaoyang", "131250043", "right"}));
        info_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

            }
        });

        iv_drag_icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.open();
            }
        });

       }

    private void initDragLayout() {
        dl = (DragLayout) findViewById(R.id.dl);
        dl.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {
                info_list.smoothScrollToPosition(new Random().nextInt(30));
            }

            @Override
            public void onClose() {
                shake();
            }

            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(iv_head_icon,percent);
            }
        });

    }

    private void shake() {
        iv_drag_icon.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
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
//                tv_schedule.setTextColor(Color.WHITE);
                if (scheduleFragment == null) {
                    // 如果ScheduleFragment为空，则创建一个并添加到界面上
                    //scheduleFragment = new ScheduleFragment();
                    scheduleFragment=new TabHostFragment();
                    transaction.add(R.id.main_content, scheduleFragment);
                } else {
                    // 如果MScheduleFragment不为空，则直接将它显示出来
                    transaction.show(scheduleFragment);
                }
                break;
            case 1:
                // 当点击了匹配tab时，改变控件的图片和文字颜色
                iv_match.setImageResource(R.drawable.tab_match_pressed);
//                tv_match.setTextColor(Color.WHITE);
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
//                tv_contacts.setTextColor(Color.WHITE);
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
    public void  b(View view) {
        toDoListFragment2=new ToDoListFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, toDoListFragment2);
        fragmentTransaction.commit();
    }
    //从match界面跳转到match add界面
    public void d(View view) {
        MatchAddFragmet m=new MatchAddFragmet();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.matchframe,m);
        fragmentTransaction.commit();
    }
    public void e(View view) {
         matchFragment=new MatchFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.matchframe,matchFragment);
        fragmentTransaction.commit();
    }
    public void a(View view) {
        scheduleFragment2=new ScheduleFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,scheduleFragment2);
        fragmentTransaction.commit();
    }
    public void c(View view) {
        SignupFragment s=new SignupFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,s);
        fragmentTransaction.commit();
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
                dl.open();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
