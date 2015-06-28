package netconnection;

import android.app.Dialog;
import android.app.Fragment;
import android.view.View;
import android.widget.Toast;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import po.ContactPO;
import turingmachine.com.sharetime20.subcontacts.ContactInfoFragment;

/**
 * Created by gaoyang on 15/4/16.
 */
public class AddContact {

    public AddContact(String user_id,String contact_id, final Fragment fragment){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_FRIEND_ID,contact_id);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                try {
//                    System.out.println(o);

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

                    Toast.makeText(fragment.getActivity(),"添加成功",Toast.LENGTH_SHORT).show();
                    ((ContactInfoFragment)fragment).btn_add_friend.setVisibility(View.INVISIBLE);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                Toast.makeText(fragment.getActivity(),"添加失败，请稍候再试",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
