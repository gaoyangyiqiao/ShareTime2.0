package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
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
import android.widget.Spinner;

import com.nineoldandroids.view.ViewHelper;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cn.smssdk.SMSSDK;
import netconnection.Config;
import netconnection.GetClassTable;
import netconnection.GetUserSchedule;
import tools.GetIconByLetter;
import tools.SortContactPO;
import turingmachine.com.sharetime20.draglayout.DragLayout;
import turingmachine.com.sharetime20.expandableselector.ExpandableItem;
import turingmachine.com.sharetime20.expandableselector.ExpandableSelector;
import turingmachine.com.sharetime20.expandableselector.OnExpandableItemClickListener;
import turingmachine.com.sharetime20.match_activity.MatchDetailActivity;
import turingmachine.com.sharetime20.match_activity.MatchDetailFragment;
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

    //下拉菜单
//    private Spinner spinner;
//    private ArrayList<String> spinner_list;
//    private ArrayAdapter spinner_adapter;
    ExpandableSelector sizesExpandableSelector;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        SMSSDK.initSDK(this, Config.APP_SMS_KEY, Config.APP_SMS_SECRET);

        initViews();
        initDragLayout();

        setTabSelection(0);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,scheduleFragment2);
        fragmentTransaction.commit();


    }

    private void initViews(){
        initializeSizesExpandableSelector();

        contactsLayout = findViewById(R.id.tab_main_contact);
        matchLayout = findViewById(R.id.tab_main_match);
        scheduleLayout = findViewById(R.id.tab_main_schedule);
        iv_contacts = (ImageView)findViewById(R.id.img_contacts);
        iv_match = (ImageView)findViewById(R.id.img_match);
        iv_schedule = (ImageView)findViewById(R.id.img_schedule);
        iv_head_icon = (ImageView) findViewById(R.id.iv_bottom);
        if(Config.getCachedName(getApplicationContext()).length()>0){
            iv_head_icon.setImageDrawable(new GetIconByLetter().getIcon(this,new SortContactPO().getFirstLetter(Config.getCachedName(getApplicationContext()))));
        }
        iv_drag_icon= (ImageView) findViewById(R.id.iv_icon);
        contactsLayout.setOnClickListener(this);
        matchLayout.setOnClickListener(this);
        scheduleLayout.setOnClickListener(this);


        toDoListFragment2=new ToDoListFragment();
        matchFragment2=new MatchFragment();
        matchAddFragmet=new MatchAddFragmet();
        scheduleFragment2=new ScheduleFragment();
        s=new NewActivityFragment();

//        System.out.println("----->>>>"+Config.getCachedId(this));
        GetUserSchedule getUserSchedule=new GetUserSchedule(Config.getCachedId(this),Config.getCachedId(this),scheduleFragment2);
        GetClassTable getClassTable=new GetClassTable(Config.getCachedStudentId(this),Config.getCachedStudentPassword(this),scheduleFragment2);



        dl= (DragLayout) findViewById(R.id.dl);
        info_list= (ListView) findViewById(R.id.lv_infolist);
        ArrayList info=new ArrayList();

        info_list.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                R.layout.item_text, new String[]{Config.getCachedName(this),""+Config.getCachedId(this), ""+Config.getCachedStudentId(this), "对外权限：1"}));
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
                sizesExpandableSelector.setVisibility(View.VISIBLE);
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
                sizesExpandableSelector.setVisibility(View.INVISIBLE);
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
                sizesExpandableSelector.setVisibility(View.INVISIBLE);
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
        sizesExpandableSelector.setVisibility(View.INVISIBLE);
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
          Intent intent=new Intent(MainActivity.this,MatchDetailActivity.class);
          startActivity(intent);
//        fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.matchchoose,new MatchDetailFragment());
//        fragmentTransaction.commit();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        if(index==1) {
//            fragmentTransaction.replace(R.id.matchchoose, matchFragment2);
//            index=2;
//        }
//        else{
//            fragmentTransaction.replace(R.id.matchchoose, matchAddFragmet);
//            index=1;
//        }
//        fragmentTransaction.commit();
    }
    public void a(View view) {
        sizesExpandableSelector.setVisibility(View.VISIBLE);
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

    private void initializeSizesExpandableSelector() {
        sizesExpandableSelector = (ExpandableSelector) findViewById(R.id.es_sizes);
        List<ExpandableItem> expandableItems = new ArrayList<ExpandableItem>();
        expandableItems.add(new ExpandableItem("0"));//今天
        expandableItems.add(new ExpandableItem("L"));//一天
        expandableItems.add(new ExpandableItem("M"));//三天
        expandableItems.add(new ExpandableItem("S"));//一周
        sizesExpandableSelector.showExpandableItems(expandableItems);
        sizesExpandableSelector.setOnExpandableItemClickListener(new OnExpandableItemClickListener() {
            @Override public void onExpandableItemClickListener(int index, View view) {
                ExpandableItem item=new ExpandableItem();
                switch (index) {
                    case 0:
                        break;
                    case 1:
                        item= sizesExpandableSelector.getExpandableItem(1);
//                        System.out.println(firstItem.getTitle());
                        swipeFirstItem(1, item);
                        break;
                    case 2:
                        item = sizesExpandableSelector.getExpandableItem(2);
                        swipeFirstItem(2, item);
                        break;
                    case 3:
                        item = sizesExpandableSelector.getExpandableItem(3);
                        swipeFirstItem(3, item);
                        break;
                    default:
                        break;
                }
                if(item.getTitle()!=null)
                switch (item.getTitle()){
                    case "0":
                        scheduleFragment2.getmWeekView().goToToday();
                        break;
                    case "S":
                        if (scheduleFragment2.mWeekViewType != ScheduleFragment.TYPE_DAY_VIEW) {
//                            item.setChecked(!item.isChecked());
                            scheduleFragment2.mWeekViewType  = ScheduleFragment.TYPE_DAY_VIEW;
                            scheduleFragment2.getmWeekView().setNumberOfVisibleDays(1);

                            // Lets change some dimensions to best fit the draglayout.
                            scheduleFragment2.getmWeekView().setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                            scheduleFragment2.getmWeekView().setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                            scheduleFragment2.getmWeekView().setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                        }
                        break;
                    case "M":
                        if (scheduleFragment2.mWeekViewType != ScheduleFragment.TYPE_THREE_DAY_VIEW) {
//                            item.setChecked(!item.isChecked());
                            scheduleFragment2.mWeekViewType = ScheduleFragment.TYPE_THREE_DAY_VIEW;
                            scheduleFragment2.getmWeekView().setNumberOfVisibleDays(3);

                            // Lets change some dimensions to best fit the draglayout.
                            scheduleFragment2.getmWeekView().setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                            scheduleFragment2.getmWeekView().setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                            scheduleFragment2.getmWeekView().setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                        }
                        break;
                    case "L":
                        if (scheduleFragment2.mWeekViewType != ScheduleFragment.TYPE_WEEK_VIEW) {
//                            item.setChecked(!item.isChecked());
                            scheduleFragment2.mWeekViewType = ScheduleFragment.TYPE_WEEK_VIEW;
                            scheduleFragment2.getmWeekView().setNumberOfVisibleDays(7);

                            // Lets change some dimensions to best fit the draglayout.
                            scheduleFragment2.getmWeekView().setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                            scheduleFragment2.getmWeekView().setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                            scheduleFragment2.getmWeekView().setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                        }
                        break;
                    default:
                        break;
                }
                sizesExpandableSelector.collapse();
            }

            private void swipeFirstItem(int position, ExpandableItem clickedItem) {
                ExpandableItem firstItem = sizesExpandableSelector.getExpandableItem(0);
                sizesExpandableSelector.updateExpandableItem(0, clickedItem);
                sizesExpandableSelector.updateExpandableItem(position, firstItem);
            }
        });
    }


}
