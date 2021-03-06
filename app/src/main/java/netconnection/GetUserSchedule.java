package netconnection;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import po.ActivityPO;
import po.SchedulePO;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.ScheduleFragment;
import turingmachine.com.sharetime20.ToDoListFragment;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;

/**
 * Created by gaoyang on 15/4/16.
 */
public class GetUserSchedule {

    public GetUserSchedule(String userId,String contactId, final ScheduleFragment fragment,final ToDoListFragment toDoListFragment){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_GET_USER_SCHEDULE);
        params.put(Config.KEY_USER_ID,userId);
        params.put(Config.KEY_CONTACT_ID,contactId);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public boolean isProgress() {
                return super.isProgress();
            }
           ArrayList<WeekViewEvent> eventlist=new ArrayList<WeekViewEvent>();
            int[] colors={Color.BLUE,Color.GREEN,Color.YELLOW};
            @Override
            public void onSuccess(String result) {
                int l=colors.length;
                SchedulePO schedule=new SchedulePO();
                try {
//                    System.out.println(result);

                    JSONObject jsonObject=new JSONObject(result);
                    JSONObject userSchedule=jsonObject.getJSONObject(Config.KEY_USER_SCHEDULE);
                    JSONArray activities=userSchedule.getJSONArray(Config.KEY_ACTIVITY);
                    for(int i=0;i<activities.length();i++){
                        JSONObject json_activity=activities.getJSONObject(i);
                        String theme=json_activity.getString(Config.KEY_THEME);
                        String founder=json_activity.getString(Config.KEY_FOUNDER_ID);
                        String content=json_activity.getString(Config.KEY_CONTENT);
                        String id=json_activity.getString(Config.KEY_ID);
                        String contacts_id=json_activity.getString(Config.KEY_CONTACTS_ID);
                        String start_time_str=json_activity.getString(Config.KEY_START_TIME);
                        String end_time_str=json_activity.getString(Config.KEY_END_TIME);
                        SimpleDateFormat sdf=new SimpleDateFormat(Config.DATE_PATTERN);
                        Date start_time=sdf.parse(start_time_str);
                        Date end_time=sdf.parse(end_time_str);
                        int right=json_activity.getInt(Config.KEY_RIGHT);
                        Calendar c1=Calendar.getInstance();
                        Calendar c2=Calendar.getInstance();
                        c1.setTime(start_time);
                        c2.setTime(end_time);
                        ActivityPO activity=new ActivityPO(id,theme,content,founder,
                                start_time,end_time,contacts_id,right);
                        schedule.getActivityList().add(activity);
                        Date date2=c2.getTime();
                        Date date1=c1.getTime();
//                        System.out.println("a");
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
//                        System.out.println("as");
                        Resources resources=fragment.getActivity().getResources();
                        Drawable drawable=resources.getDrawable(R.drawable.logo);
                        if(toDoListFragment!=null);
                           toDoListFragment.update(drawable,content+" "+simpleDateFormat.format(start_time)+" "+simpleDateFormat.format(end_time));
                        WeekViewEvent w=new WeekViewEvent(Integer.parseInt(id), content, c1, c2);
                        if (i%4==0)
                            w.setColor(fragment.getActivity().getResources().getColor(R.color.event_color_01));
                        if (i%4==1)
                            w.setColor(fragment.getActivity().getResources().getColor(R.color.event_color_02));
                        if (i%4==2)
                            w.setColor(fragment.getActivity().getResources().getColor(R.color.event_color_03));
                        if (i%4==3)
                            w.setColor(fragment.getActivity().getResources().getColor(R.color.event_color_04));
                        eventlist.add(w);
                    }
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    schedule.setStartTime(dateFormat.parse(userSchedule.getString(Config.KEY_BEGIN_TIME)));
                    schedule.setLength(userSchedule.getInt(Config.KEY_SIZE));
//                    System.out.println("start addEvent!");
                    fragment.addEvent(eventlist);
//                    SchedulePre schedulePre=new SchedulePre(schedule);
//                    scheduleView.activityInfo=schedulePre.getActivityPre();

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                System.out.println("---->>>>>>net.error in getUserSchedule");
            }


            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }
        });
    }
    public GetUserSchedule(String userId,String contactId, final ScheduleFragment fragment){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_GET_USER_SCHEDULE);
        params.put(Config.KEY_USER_ID,userId);
        params.put(Config.KEY_CONTACT_ID,contactId);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public boolean isProgress() {
                return super.isProgress();
            }
            ArrayList<WeekViewEvent> eventlist=new ArrayList<WeekViewEvent>();
            int[] colors={Color.BLUE,Color.GREEN,Color.YELLOW};
            @Override
            public void onSuccess(String result) {
                int l=colors.length;
                SchedulePO schedule=new SchedulePO();
                try {
//                    System.out.println(result);

                    JSONObject jsonObject=new JSONObject(result);
                    JSONObject userSchedule=jsonObject.getJSONObject(Config.KEY_USER_SCHEDULE);
                    JSONArray activities=userSchedule.getJSONArray(Config.KEY_ACTIVITY);
                    for(int i=0;i<activities.length();i++){
                        JSONObject json_activity=activities.getJSONObject(i);
                        String theme=json_activity.getString(Config.KEY_THEME);
                        String founder=json_activity.getString(Config.KEY_FOUNDER_ID);
                        String content=json_activity.getString(Config.KEY_CONTENT);
                        String id=json_activity.getString(Config.KEY_ID);
                        String contacts_id=json_activity.getString(Config.KEY_CONTACTS_ID);
                        String start_time_str=json_activity.getString(Config.KEY_START_TIME);
                        String end_time_str=json_activity.getString(Config.KEY_END_TIME);
                        SimpleDateFormat sdf=new SimpleDateFormat(Config.DATE_PATTERN);
                        Date start_time=sdf.parse(start_time_str);
                        Date end_time=sdf.parse(end_time_str);
                        int right=json_activity.getInt(Config.KEY_RIGHT);
                        Calendar c1=Calendar.getInstance();
                        Calendar c2=Calendar.getInstance();
                        c1.setTime(start_time);
                        c2.setTime(end_time);
                        ActivityPO activity=new ActivityPO(id,theme,content,founder,
                                start_time,end_time,contacts_id,right);
                        schedule.getActivityList().add(activity);
                        Date date2=c2.getTime();
                        Date date1=c1.getTime();
                        System.out.println("a");
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                        System.out.println("as");


                        WeekViewEvent w=new WeekViewEvent(Integer.parseInt(id), content, c1, c2);

                        w.setColor(colors[i%l]);

                        eventlist.add(w);
                    }
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    schedule.setStartTime(dateFormat.parse(userSchedule.getString(Config.KEY_BEGIN_TIME)));
                    schedule.setLength(userSchedule.getInt(Config.KEY_SIZE));
//                    System.out.println("start addEvent!");

                    fragment.addEvent(eventlist);


//                    SchedulePre schedulePre=new SchedulePre(schedule);
//                    scheduleView.activityInfo=schedulePre.getActivityPre();

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                System.out.println("---->>>>>>net.error in getUserSchedule");
            }


            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }
        });
    }
}
