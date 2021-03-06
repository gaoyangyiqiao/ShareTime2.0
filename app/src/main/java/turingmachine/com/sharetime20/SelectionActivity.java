package turingmachine.com.sharetime20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import com.thinkland.sdk.util.CommonFun;

import cn.smssdk.SMSSDK;
import netconnection.Config;
import turingmachine.com.sharetime20.captcha.RegisterActivity;
import turingmachine.com.sharetime20.subcontacts.ContactInfoActivity;


public class SelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String token = Config.getCachedToken(this);
        String id = Config.getCachedId(this);
       if (token!=null&&id!=null) {
            Intent i =new Intent(this, MainActivity.class);
            i.putExtra(Config.KEY_TOKEN, token);
            i.putExtra(Config.KEY_PHONE_NUM, id);
            startActivity(i);
        }else{
            startActivity(new Intent(this, RegisterActivity.class));
        }

        finish();
    }
}
