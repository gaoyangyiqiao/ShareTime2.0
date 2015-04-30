package netconnection;

import android.content.Context;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gaoyang on 15/4/30.
 */
public class Register {

    public Register(String phone,final Context context){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_REGISTER);
        params.put(Config.KEY_PHONE,phone);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public boolean isProgress() {
                return super.isProgress();
            }

            @Override
            public void onSuccess(String o) {
                try {
                    JSONObject obj=new JSONObject(o);
                    String user_id=obj.getString(Config.KEY_USER_ID);
                    Config.cacheId(context,user_id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                super.onFailure(t, strMsg);
                System.out.println("-->>>>>net.error in Register");
            }
        });
    }

}
