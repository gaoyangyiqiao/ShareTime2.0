package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import po.ContactPO;

/**
 * Created by gaoyang on 15/4/16.
 */
public class AddContact {

    public AddContact(String user_id,String contact_id){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_FRIEND_ID,contact_id);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                try {
                    JSONObject object=new JSONObject(o);
                    JSONObject contactinfo=object.getJSONObject(Config.KEY_USER_INFO);

                    int id=contactinfo.getInt(Config.KEY_ID);
                    String name=contactinfo.getString(Config.KEY_NAME);
                    String tip=contactinfo.getString(Config.KEY_TIP);
                    int root=contactinfo.getInt(Config.KEY_ROOT);
                    ContactPO contactPO=new ContactPO(name);
                    contactPO.setId(id);
                    contactPO.setTip(tip);
                    contactPO.setRoot(root);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                super.onFailure(t, strMsg);
            }
        });
    }
}
