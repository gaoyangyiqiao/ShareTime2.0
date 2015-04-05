package netconnection;


import android.widget.BaseAdapter;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import po.ContactPO;
import tools.CharacterParser;

/**
 * Created by gaoyang on 15/4/1.
 */
public class GetContacts {

    private CharacterParser parser;

    public GetContacts(){
        parser=new CharacterParser();
    }

    public void getContacts(String user_id, final BaseAdapter adapter,final List list){

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
                    JSONObject return_info=new JSONObject(t);
                    JSONArray json_contacts=return_info.getJSONArray(Config.KEY_CONTACTS);
                    for (int i=0;i<json_contacts.length();i++){
                        JSONObject obj=json_contacts.getJSONObject(i);
                        ContactPO contact=new ContactPO(obj.getString(Config.KEY_NAME));
                        contact.setId(obj.getInt(Config.KEY_ID));
                        //TODO 此时存储的为服务器地址，后期需要下载到本地
                        contact.setImageurl(obj.getString(Config.KEY_IMG));
                        contact.setPhone(obj.getString(Config.KEY_PHONE));

                        //设置首字母
                        String pinyin = parser.getSelling(contact.getName());
                        String sortString = pinyin.substring(0, 1).toUpperCase();
                        // 正则表达式，判断首字母是否是英文字母
                        if(sortString.matches("[A-Z]")){
                            contact.setSortLetters(sortString.toUpperCase());
                        }else{
                            contact.setSortLetters("#");
                        }

                        list.add(contact);
                        adapter.notifyDataSetChanged();
                    }
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
