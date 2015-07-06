package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.ActivityPO;
import po.SchedulePO;

/**
 * Created by gaoyang on 15/4/16.
 */
public class Match {

    public Match(String user_id,String user_id_array,String begin_time,String end_time,final SchedulePO schedule){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_MATCH);
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_USER_ID_ARRAY,user_id_array);
        params.put(Config.KEY_BEGIN_TIME,begin_time);
        params.put(Config.KEY_END_TIME,end_time);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCllBack<String>() {
            @Override
            public boolean isProgress() {
                return super.isProgress();
            }

            @Override
            public void onSuccess(String result) {
                try {
//                    System.out.println(result);

                    JSONObject jsonObject=new JSONObject(result);
                    JSONObject userSchedule=jsonObject.getJSONObject(Config.KEY_COMMON_FREE_SCHEDULE);
                    JSONArray activities=userSchedule.getJSONArray(Config.KEY_ACTIVITY);
                    for(int i=0;i<activities.length();i++){
                        JSONObject json_activity=activities.getJSONObject(i);
                        String theme=json_activity.getString(Config.KEY_THEME);
                        String founder=json_activity.getString(Config.KEY_FOUNDER_ID);
                        String content=json_activity.getString(Config.KEY_CONTENT);
                        String id=json_activity.getString(Config.KEY_ID);
                        String contacts_id=json_activity.getString(Config.KEY_CONTACTS_ID);
                        String receive_time_str=json_activity.getString(Config.KEY_RECEIVE_TIME);
                        String start_time_str=json_activity.getString(Config.KEY_START_TIME);
                        String end_time_str=json_activity.getString(Config.KEY_END_TIME);
                        SimpleDateFormat sdf=new SimpleDateFormat(Config.DATE_PATTERN);
                        Date receive_time=sdf.parse(receive_time_str);
                        Date start_time=sdf.parse(start_time_str);
                        Date end_time=sdf.parse(end_time_str);
                        int right=json_activity.getInt(Config.KEY_RIGHT);

                        ActivityPO activity=new ActivityPO(id,theme,content,founder,
                                start_time,end_time,contacts_id,right);
                        schedule.getActivityList().add(activity);
                    }

                    SimpleDateFormat dateFormat=new SimpleDateFormat(Config.DATE_PATTERN);
                    schedule.setStartTime(dateFormat.parse(userSchedule.getString(Config.KEY_BEGIN_TIME)));
                    schedule.setLength(userSchedule.getInt(Config.KEY_SIZE));

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                System.out.println("---->>>>>>net.error in match");
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }
        });
    }

}
