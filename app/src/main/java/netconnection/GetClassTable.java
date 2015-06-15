package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import po.ClassPO;
import turingmachine.com.sharetime20.ScheduleFragment;
import turingmachine.com.sharetime20.weekview.WeekView;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;

/**
 * Created by gaoyang on 15/6/7.
 */
public class GetClassTable {

    public GetClassTable(String student_id,String student_password, final ScheduleFragment fragment){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_GET_CLASSTABLE);
        params.put(Config.KEY_STUDENT_ID,student_id);
        params.put(Config.KEY_STUDENT_PASSWORD, student_password);
        final ArrayList<WeekViewEvent> listclass=new ArrayList<>();
        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                try {
//                    System.out.println(params);
//                    System.out.println(o);
                    ArrayList<ClassPO> all_classes=new ArrayList<ClassPO>();
                    JSONObject object=new JSONObject(o);
                    JSONArray classes=object.getJSONArray(Config.KEY_CLASSES);
                    for (int i = 0; i <classes.length() ; i++) {
                        JSONObject per_class=classes.getJSONObject(i);
                        String name=per_class.getString(Config.KEY_NAME);
                        String place=per_class.getString(Config.KEY_PLACE);

                        SimpleDateFormat sdf=new SimpleDateFormat(Config.DATE_PATTERN);
                        String start_time_str=per_class.getString(Config.KEY_START_TIME);
                        String end_time_str=per_class.getString(Config.KEY_END_TIME);
                        Date start_time=sdf.parse(start_time_str);
                        Date end_time=sdf.parse(end_time_str);
                        Calendar c1=Calendar.getInstance();
                        Calendar c2=Calendar.getInstance();
                        c1.setTime(start_time);
                        c2.setTime(end_time);
                       listclass.add(new WeekViewEvent(1,name,c1,c2));
                        ClassPO it=new ClassPO(name,place,start_time,end_time);
                        all_classes.add(it);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                fragment.addEvent(listclass);

            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                super.onFailure(t, strMsg);
                System.out.println("----->>>>Net.Error in getClassTable");
            }
        });
    }
}
