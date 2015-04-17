package turingmachine.com.sharetime20.captcha;

import com.thinkland.sdk.util.CommonFun;

import android.app.Application;

public class SharetimeApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		CommonFun.initialize(getApplicationContext(), false);
	}

}
