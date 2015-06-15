package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gaoyang on 15/5/5.
 */
public class AddActivity {

    public AddActivity(String user_id,String theme,String content,String begin_time,String end_time,int a){
        final AjaxParams params = new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_ADD_ACTIVITY);
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_THEME,theme);
        params.put(Config.KEY_CONTENT,content);
        params.put(Config.KEY_BEGIN_TIME,begin_time);
        params.put(Config.KEY_END_TIME,end_time);

        FinalHttp fh = new FinalHttp();
        fh.post(Config.URL, params, new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                try {
//                    System.out.println("---->>>>"+o);
                    JSONObject result=new JSONObject(o);
                    String activity_id=result.getString(Config.KEY_ACTIVITY_ID);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                System.out.println("---->>>>"+"net.error in addActivity");
            }
        });
        System.out.println("add activity :"+user_id+"  "+begin_time);

    }
}
