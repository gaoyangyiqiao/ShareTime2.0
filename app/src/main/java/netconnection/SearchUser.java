package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactsListAdapter;
import po.ContactPO;
import tools.CharacterParser;
import tools.SortContactPO;

/**
 * Created by gaoyang on 15/5/2.
 */
public class SearchUser {


    public SearchUser(String user_id, final String key_words,final ContactsListAdapter adapter){
        final AjaxParams params = new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_SEARCH_USER);
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_KEYWORDS, key_words);
        FinalHttp fh = new FinalHttp();
        fh.post(Config.URL, params, new AjaxCallBack<String>() {
            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public void onSuccess(String o) {
//                System.out.println(o);
                List<ContactPO> list=new ArrayList<>();
                try {
                    list.clear();
                    JSONObject jsonObject=new JSONObject(o);
                    JSONArray users=jsonObject.getJSONArray(Config.KEY_USERS);
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user=users.getJSONObject(i);
                        ContactPO contact=new ContactPO(user.getString(Config.KEY_NAME));
                        contact.setId(user.getInt(Config.KEY_ID));
                        //TODO 此时存储的为服务器地址，后期需要下载到本地
                        contact.setImageurl(user.getString(Config.KEY_PHOTO_PATH));
                        contact.setPhone(user.getString(Config.KEY_PHONE));
                        list.add(contact);
                    }
                    new SortContactPO().sort(list);
                    if(key_words==""||key_words==null)
                        list.clear();
                    adapter.updateListView(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                System.out.println("---->>>net.error in SearchUser");
            }
        });
    }
}
