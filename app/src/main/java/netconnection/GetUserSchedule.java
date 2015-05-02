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
public class GetUserSchedule {

    public GetUserSchedule(String userId,String contactId,final SchedulePO schedule){
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

            @Override
            public void onSuccess(String result) {
                try {
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
                        String receive_time_str=json_activity.getString(Config.KEY_RECEIVE_TIME);
                        String start_time_str=json_activity.getString(Config.KEY_START_TIME);
                        String end_time_str=json_activity.getString(Config.KEY_END_TIME);
                        SimpleDateFormat sdf=new SimpleDateFormat(Config.DATE_PATTERN);
                        Date receive_time=sdf.parse(receive_time_str);
                        Date start_time=sdf.parse(start_time_str);
                        Date end_time=sdf.parse(end_time_str);
                        int right=json_activity.getInt(Config.KEY_RIGHT);

                        ActivityPO activity=new ActivityPO(id,theme,content,founder,receive_time,
                                start_time,end_time,contacts_id,right);
                        schedule.getActivityList().add(activity);
                    }

                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
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
                System.out.println("---->>>>>>net.error in getUserSchedule");
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }
        });
    }
}
