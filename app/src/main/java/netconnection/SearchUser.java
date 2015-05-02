package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import adapter.ContactsListAdapter;
import po.ContactPO;
import tools.CharacterParser;

/**
 * Created by gaoyang on 15/5/2.
 */
public class SearchUser {


    public SearchUser(String user_id,String key_words,final ContactsListAdapter adapter,final List<ContactPO> list){
        final AjaxParams params = new AjaxParams();
        params.put(Config.KEY_ACTION,Config.ACTION_SEARCH_USER);
        params.put(Config.KEY_USER_ID,user_id);
        params.put(Config.KEY_KEYWORDS,key_words);
        FinalHttp fh = new FinalHttp();
        fh.post(Config.URL, params, new AjaxCallBack<String>() {
            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public void onSuccess(String o) {
                System.out.println("----->>>>>success"+o);
                try {
                    JSONObject jsonObject=new JSONObject(o);
                    JSONArray users=jsonObject.getJSONArray(Config.KEY_USERS);
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user=users.getJSONObject(i);
                        ContactPO contact=new ContactPO(user.getString(Config.KEY_NAME));
                        contact.setId(user.getInt(Config.KEY_ID));
                        //TODO 此时存储的为服务器地址，后期需要下载到本地
                        contact.setImageurl(user.getString(Config.KEY_IMG));
                        contact.setPhone(user.getString(Config.KEY_PHONE));
                        //设置首字母
                        String pinyin = new CharacterParser().getSelling(contact.getName());
                        String sortString = pinyin.substring(0, 1).toUpperCase();
                        // 正则表达式，判断首字母是否是英文字母
                        if(sortString.matches("[A-Z]")){
                            contact.setSortLetters(sortString.toUpperCase());
                        }else{
                            contact.setSortLetters("#");
                        }

                        list.add(contact);
                        adapter.getLists().add(contact);
                        if(list.size()!=0)
                            adapter.notifyDataSetChanged();
                    }
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
