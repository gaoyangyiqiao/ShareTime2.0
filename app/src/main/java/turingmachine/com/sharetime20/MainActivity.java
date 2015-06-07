package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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
import java.util.Date;
import java.util.Random;

import netconnection.Config;
import netconnection.GetClassTable;
import netconnection.GetUserSchedule;
import turingmachine.com.sharetime20.draglayout.DragLayout;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;


public class MainActivity extends Activity implements OnClickListener{
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager2;
    private FrameLayout frame2;
    int index=1;
    NewActivityFragment s;
    private ScheduleFragment scheduleFragment2;
    private ToDoListFragment toDoListFragment2;
    private DragLayout dl;
    private ContactsFragment contactsFragment;
    private MatchFragment matchFragment2;
    private MatchChoose matchFragment;
    private TabHostFragment scheduleFragment;
    private ToDoListFragment toDoListFragment;
    private MatchAddFragmet matchAddFragmet=new MatchAddFragmet();
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
        fragmentManager = getFragmentManager();
        initViews();
        initDragLayout();

        setTabSelection(0);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,scheduleFragment2);
        fragmentTransaction.commit();


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

        matchFragment=new MatchChoose();
        toDoListFragment2=new ToDoListFragment();
        matchFragment2=new MatchFragment();
        matchAddFragmet=new MatchAddFragmet();
        scheduleFragment2=new ScheduleFragment();
        s=new NewActivityFragment();


        GetUserSchedule getUserSchedule=new GetUserSchedule(Config.getCachedId(this),Config.getCachedId(this),scheduleFragment2);
        GetClassTable getClassTable=new GetClassTable(Config.getCachedStudentId(this),Config.getCachedStudentPassword(this),scheduleFragment2);



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
                    matchFragment = new MatchChoose();
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

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, toDoListFragment2);
        fragmentTransaction.commit();
    }
    //从match界面跳转到match add界面
    public void d(View view) {

    }
    public void e(View view) {

    }
    public void f(View view) {

        fragmentTransaction = fragmentManager.beginTransaction();
        if(index==1) {
            fragmentTransaction.replace(R.id.matchchoose, matchFragment2);
            index=2;
        }
        else{
            fragmentTransaction.replace(R.id.matchchoose, matchAddFragmet);
            index=1;
        }
        fragmentTransaction.commit();
    }
    public void a(View view) {

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,scheduleFragment2);
        fragmentTransaction.commit();
    }
    public void c(View view) {

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,s);
        fragmentTransaction.commit();
    }
    public void g(View view) {
            WeekViewEvent w=(WeekViewEvent)view.getTag();
        if(w==null)return;
        Date st=w.getStartTime().getTime();
        Date et=w.getEndTime().getTime();
        String content=w.getName()+"  "+(st.getYear()+1900)+"/"+st.getMonth()+"/"+st.getDay()+" "+st.getHours()+":"+st.getMinutes()+" 到 "+(et.getYear()+1900)+"/"+et.getMonth()+"/"+et.getDay()+" "+et.getHours()+":"+et.getMinutes();
        Resources resources=getResources();
        Drawable drawable=resources.getDrawable(R.drawable.logo);
        toDoListFragment2.update(drawable,content);
        scheduleFragment2.add(w);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,scheduleFragment2);
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


}
