package netconnection;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

import po.ContactPO;

/**
 * Created by gaoyang on 15/4/1.
 */
public class GetContacts {

    public ArrayList<ContactPO> getInfo(String user_id){
        final ArrayList<ContactPO> result=new ArrayList<>();

        AjaxParams params = new AjaxParams();
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
                    JSONArray json_contacts=new JSONArray(t);
                    for (int i=0;i<json_contacts.length();i++){
                        JSONObject obj=json_contacts.getJSONObject(i);
                        ContactPO contact=new ContactPO(obj.getString(Config.KEY_NAME));
                        contact.setId(obj.getInt(Config.KEY_ID));
                        //TODO 此时存储的为服务器地址，后期需要下载到本地
                        contact.setImageurl(obj.getString(Config.KEY_IMG));
                        contact.setPhone(obj.getString(Config.KEY_PHONE));
                        result.add(contact);
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

        return result;
    }


}
