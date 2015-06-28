package netconnection;

import android.app.Dialog;
import android.app.Fragment;
import android.view.View;
import android.widget.Toast;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import po.ContactPO;
import tools.CharacterParser;
import turingmachine.com.sharetime20.ContactsFragment;
import turingmachine.com.sharetime20.subcontacts.ContactInfoFragment;

/**
 * Created by gaoyang on 15/4/16.
 */
public class AddContact {

    public AddContact(String user_id,String contact_id, final Fragment fragment){
        final AjaxParams params=new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_ADD_CONTACT);
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_FRIEND_ID,contact_id);

        FinalHttp finalHttp=new FinalHttp();
        finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                try {

                    JSONObject object=new JSONObject(o);
                    JSONArray contact=object.getJSONArray(Config.KEY_USER_INFO);
                    JSONObject contactinfo=contact.getJSONObject(0);

                    int id=contactinfo.getInt(Config.KEY_ID);
                    String name=contactinfo.getString(Config.KEY_NAME);
                   //TODO 未添加联系人的备注
//                    String tip=contactinfo.getString(Config.KEY_TIP);
//                    int root=contactinfo.getInt(Config.KEY_ROOT);
                    ContactPO contactPO=new ContactPO(name);
                    contactPO.setId(id);
//                    contactPO.setTip(tip);
//                    contactPO.setRoot(root);
                    //添加联系人
                    Toast.makeText(fragment.getActivity(),"添加成功",Toast.LENGTH_SHORT).show();
                    ((ContactInfoFragment)fragment).btn_add_friend.setVisibility(View.INVISIBLE);
                    //设置首字母
                    CharacterParser parser=new CharacterParser();
                    String pinyin = parser.getSelling(contactPO.getName());
                    String sortString = pinyin.substring(0, 1).toUpperCase();
                    // 正则表达式，判断首字母是否是英文字母
                    if(sortString.matches("[A-Z]")){
                        contactPO.setSortLetters(sortString.toUpperCase());
                    }else{
                        contactPO.setSortLetters("#");
                    }

                    ContactsFragment.contacts.add(contactPO);

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
