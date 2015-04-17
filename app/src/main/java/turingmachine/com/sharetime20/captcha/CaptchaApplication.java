package turingmachine.com.sharetime20.captcha;

import com.thinkland.sdk.util.CommonFun;

import android.app.Application;

public class CaptchaApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		CommonFun.initialize(getApplicationContext(), false);
	}

}
