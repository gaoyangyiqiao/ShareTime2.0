package turingmachine.com.sharetime20;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.RectF;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import netconnection.Config;
import netconnection.GetClassTable;
import netconnection.GetUserSchedule;
import turingmachine.com.sharetime20.weekview.DateTimeInterpreter;
import turingmachine.com.sharetime20.weekview.WeekView;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;

/**
 * Created by admin on 2015/3/28.
 * 这个类用于管理schedule界面
 */
public class ScheduleFragment extends Fragment implements WeekView.MonthChangeListener,
        WeekView.EventClickListener, WeekView.EventLongPressListener,WeekView.EmptyViewLongPressListener,WeekView.EmptyViewClickListener {
    public static final int TYPE_DAY_VIEW = 1;
    public static final int TYPE_THREE_DAY_VIEW = 2;
    public static final int TYPE_WEEK_VIEW = 3;
    public int mWeekViewType = TYPE_THREE_DAY_VIEW;
    private WeekView mWeekView;

    private ArrayList<WeekViewEvent> list=new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View scheduleFragment = inflater.inflate(R.layout.activity_schedule,container,false);

        mWeekView=(WeekView)getActivity().findViewById(R.id.weekView);
      //  mWeekView=new WeekView();
      // this.getActivity().setContentView(mWeekView);
     //   System.out.println(mWeekView);


        return scheduleFragment;
    }

    public ArrayList<String> getActivityContent(){

        ArrayList<String> l=new ArrayList<>();
        int length=list.size();
        for (int i=0;i<length;i++){
            WeekViewEvent weekViewEvent=list.get(i);
            Calendar c1= weekViewEvent.getStartTime();
            Calendar c2= weekViewEvent.getEndTime();
            System.out.println("b");
            Date date2=c2.getTime();
            Date date1=c1.getTime();
            System.out.println("a");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
            System.out.println("as");
            String content= weekViewEvent.getName();


            //toDoListFragment.update(drawable,content+" "+simpleDateFormat.format(c1)+" 到 "+simpleDateFormat.format(c2));
            l.add(content+" "+simpleDateFormat.format(date1)+" 到 "+simpleDateFormat.format(date2));
            System.out.println("activity content:"+content+" "+simpleDateFormat.format(date1)+" 到 "+simpleDateFormat.format(date2));
        }
        return l;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mWeekView=(WeekView)getActivity().findViewById(R.id.weekView);
        //  mWeekView=new WeekView();
        // this.getActivity().setContentView(mWeekView);

        mWeekView.setOnEventClickListener(this);

        // The week draglayout has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week draglayout.
        mWeekView.setMonthChangeListener(this);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(this);

        //Set emptyView click-listener
        mWeekView.setEmptyViewClickListener(this);
        mWeekView.setEmptyViewLongPressListener(this);

        // Set up a date time interpreter to interpret how the date and time will be formatted in
        // the week draglayout. This is optional.
        setupDateTimeInterpreter(false);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        setupDateTimeInterpreter(id == R.string.action_week_view);
        switch (id){
            case R.string.action_today:
                mWeekView.goToToday();
                return true;
            case R.string.action_day_view:
                if (mWeekViewType != TYPE_DAY_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(1);

                    // Lets change some dimensions to best fit the draglayout.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
                return true;
            case R.string.action_three_day_view:
                if (mWeekViewType != TYPE_THREE_DAY_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_THREE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(3);

                    // Lets change some dimensions to best fit the draglayout.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
                return true;
            case R.string.action_week_view:
                if (mWeekViewType != TYPE_WEEK_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_WEEK_VIEW;
                    mWeekView.setNumberOfVisibleDays(7);

                    // Lets change some dimensions to best fit the draglayout.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Set up a date time interpreter which will show short date values when in week draglayout and long
     * date values otherwise.
     * @param shortDate True if the date values should be short.
     */
    private void setupDateTimeInterpreter(final boolean shortDate) {
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());

                // All android api level do not have a standard way of getting the first letter of
                // the week day name. Hence we get the first char programmatically.
                // Details: http://stackoverflow.com/questions/16959502/get-one-letter-abbreviation-of-week-day-of-a-date-in-java#answer-16959657
                if (shortDate)
                    weekday = String.valueOf(weekday.charAt(0));
                return weekday.toUpperCase() + format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour) {
                return hour > 11 ? (hour - 12) + " PM" : (hour == 0 ? "12 AM" : hour + " AM");
            }
        });
    }

    @Override
    public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        // Populate the week draglayout with some events.
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, newMonth-1);
        WeekViewEvent event = new WeekViewEvent(1,"activity1", startTime, endTime);
//        System.out.println("starttime normal : "+startTime.getTime());
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);





        return list;
    }

    private String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH)+1, time.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {
        Toast.makeText(getActivity(), "Clicked " + event.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
       Toast.makeText(getActivity(), "Long pressed event: " + event.getName(), Toast.LENGTH_SHORT).show();
    }
    public void addEvent(ArrayList<WeekViewEvent> weekViewEvent){

        int length=weekViewEvent.size();
        for(int i=0;i<length;i++){
            list.add(weekViewEvent.get(i));
          //  System.out.println("list add event "+weekViewEvent.get(i).getName());
        }
        mWeekView.notifyDatasetChanged();

    }
    public void add(WeekViewEvent w){
        list.add(w);
      //  System.out.println("add w "+w.getName()+"size "+list.size());
      //  System.out.println(mWeekView);
        mWeekView.notifyDatasetChanged();

//        System.out.println("重绘之后 size"+mWeekView.size());
    }
    public void remove(int index){
        list.remove(index);
        mWeekView.notifyDatasetChanged();
    }

    public void resetActivity(ArrayList<WeekViewEvent> list){
        this.list=list;
        mWeekView.notifyDatasetChanged();

    }


    public static int getTypeWeekView() {
        return TYPE_WEEK_VIEW;
    }

    public int getmWeekViewType() {
        return mWeekViewType;
    }

    public void setmWeekViewType(int mWeekViewType) {
        this.mWeekViewType = mWeekViewType;
    }

    public WeekView getmWeekView() {
        return mWeekView;
    }


    @Override
    public void onEmptyViewLongPress(Calendar time) {
        Toast.makeText(getActivity(),"emptyView LoingClicked"+time.getTime().toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onEmptyViewClicked(Calendar time) {
        Toast.makeText(getActivity(),"emptyView clicked"+time.getTime().toString(),Toast.LENGTH_LONG).show();
    }
}




