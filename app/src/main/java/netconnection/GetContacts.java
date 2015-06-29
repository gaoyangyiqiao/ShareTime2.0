package netconnection;


import android.widget.BaseAdapter;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

import adapter.ContactsListAdapter;
import po.ContactPO;
import tools.CharacterParser;
import tools.PinyinComparator;
import tools.SortContactPO;
import turingmachine.com.sharetime20.ContactsFragment;

/**
 * Created by gaoyang on 15/4/1.
 */
public class GetContacts {

    private CharacterParser parser;

    public GetContacts(){
        parser=CharacterParser.getInstance();
    }

    public void getContacts(String user_id, final ContactsListAdapter adapter,final List list){

        final AjaxParams params = new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_GET_CONTACTS);
        params.put("user_id",user_id);
        FinalHttp fh = new FinalHttp();
        fh.post(Config.URL, params, new AjaxCallBack<String>(){
            @Override
            public void onLoading(long count, long current) {
            }

            @Override
            public void onSuccess(String t) {

                try {
//                    System.out.println(t);

                    JSONObject return_info=new JSONObject(t);
                    JSONArray json_contacts=return_info.getJSONArray(Config.KEY_CONTACTS);
                    for (int i=0;i<json_contacts.length();i++){
                        JSONObject obj=json_contacts.getJSONObject(i);
                        ContactPO contact=new ContactPO(obj.getString(Config.KEY_NAME));
                        contact.setId(obj.getInt(Config.KEY_ID));
                        //TODO 此时存储的为服务器地址，后期需要下载到本地
                        contact.setImageurl(obj.getString(Config.KEY_PHOTO_PATH));
                        contact.setPhone(obj.getString(Config.KEY_PHONE));
                        //初始化id_list
                        ContactsFragment.id_list.add(contact.getId());
                        list.add(contact);
//                        adapter.getLists().add(contact);
                    }
                    new SortContactPO().sort(list);
                    if(list.size()!=0)
                        adapter.addAll(list);
                        adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                System.out.println("---->>>"+"net.error in getting Contacts from client");
                super.onFailure(t, strMsg);
            }
        });
    }


}
