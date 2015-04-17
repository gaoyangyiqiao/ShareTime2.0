package turingmachine.com.sharetime20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import netconnection.Config;
import turingmachine.com.sharetime20.captcha.RegisterActivity;


public class SelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String token = Config.getCachedToken(this);
        String phone_num = Config.getCachedPhoneNum(this);

        if (token!=null&&phone_num!=null) {
            Intent i =new Intent(this, MainActivity.class);
            i.putExtra(Config.KEY_TOKEN, token);
            i.putExtra(Config.KEY_PHONE_NUM, phone_num);
            startActivity(i);
        }else{
            startActivity(new Intent(this, RegisterActivity.class));
        }

        finish();
    }
}
