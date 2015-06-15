package netconnection;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONException;
import org.json.JSONObject;

import po.ContactPO;
import turingmachine.com.sharetime20.subcontacts.ContactInfoActivity;

/**
 * Created by gaoyang on 15/4/5.
 */
public class GetContactInfo {


       public void displayContactInfo(String id,String contact_id,final ContactInfoActivity contactInfoActivity){
           FinalHttp finalHttp=new FinalHttp();
           final FinalBitmap finalBitmap=FinalBitmap.create(contactInfoActivity);
           final AjaxParams params = new AjaxParams();
           params.put(Config.KEY_ACTION,Config.ACTION_GET_CONTACT_INFO);
           params.put(Config.KEY_USER_ID,id);
           params.put(Config.KEY_CONTACT_ID,contact_id);
           finalHttp.post(Config.URL,params,new AjaxCallBack<String>() {
               @Override
               public void onSuccess(String result) {
                   try {
//                       System.out.println(result);

                       JSONObject json_result=new JSONObject(result);
                       JSONObject info=json_result.getJSONObject(Config.KEY_INFO);
                       ContactPO contactPO=new ContactPO(info.getString(Config.KEY_NAME));
                       contactPO.setAccount(info.getString(Config.KEY_ACCOUNT));
                       contactPO.setImageurl(info.getString(Config.KEY_IMG));

//                       contactInfoActivity.getName().setText(contactPO.getName());
//                       contactInfoActivity.getAccount().setText(contactPO.getAccount());
//                       finalBitmap.display(contactInfoActivity.getIcon(),contactPO.getImageurl());

                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }

               @Override
               public void onFailure(Throwable t, String strMsg) {
                   System.out.println("---->>>>net.error in get contactInfo");
                   super.onFailure(t, strMsg);
               }
           });

       }
}
