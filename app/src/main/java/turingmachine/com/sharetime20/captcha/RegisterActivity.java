package turingmachine.com.sharetime20.captcha;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import netconnection.Config;
import netconnection.Register;
import turingmachine.com.sharetime20.MainActivity;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapButton;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapEditText;

public class RegisterActivity extends BaseActivity implements OnClickListener,
		TextWatcher {

	private EditText etPhoneNum;
	private TextView tvCountryNum;
	private ImageView ivClear;
	private Button btnNext;
    private BootstrapButton getIdentifyCode;
    private EditText username;
    private EditText student_id;
    private EditText student_password;
    private BootstrapEditText identifyCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initView();

        SMSSDK.initSDK(this,Config.APP_SMS_KEY,Config.APP_SMS_SECRET);
        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }

        };
        SMSSDK.registerEventHandler(eh);

	}

	private void initView() {
//		TextView tv = (TextView) findViewById(R.id.tv_title);
//		tv.setText(R.string.smssdk_regist);
		btnNext = (Button) findViewById(R.id.btn_next);
		tvCountryNum = (TextView) findViewById(R.id.tv_country_num);
		ivClear = (ImageView) findViewById(R.id.iv_clear);
        username= (EditText) findViewById(R.id.et_username);
        student_id= (EditText) findViewById(R.id.et_student_id);
        student_password= (EditText) findViewById(R.id.et_student_password);
		etPhoneNum = (EditText) findViewById(R.id.et_write_phone);
        identifyCode= (BootstrapEditText) findViewById(R.id.et_identify);
		etPhoneNum.addTextChangedListener(this);
		etPhoneNum.setText("");

		username.requestFocus();

		if (etPhoneNum.getText().length() > 0) {
			btnNext.setEnabled(true);
			ivClear.setVisibility(View.VISIBLE);
			btnNext.setBackgroundResource(R.drawable.smssdk_btn_enable);
		}

		btnNext.setOnClickListener(this);
		ivClear.setOnClickListener(this);

        getIdentifyCode=(BootstrapButton)findViewById(R.id.bt_get_identifycode);
        getIdentifyCode.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!TextUtils.isEmpty(etPhoneNum.getText().toString())){
                   SMSSDK.getVerificationCode("86",etPhoneNum.getText().toString().trim()
                           .replaceAll("\\s*", ""));
               }else{
                   Toast.makeText(getApplicationContext(),"请填写手机号",Toast.LENGTH_SHORT).show();
               }
            }
        });
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_next:
			String phone = etPhoneNum.getText().toString().trim()
					.replaceAll("\\s*", "");
			String code = identifyCode.getText().toString().trim();
            SMSSDK.submitVerificationCode("86",phone,code);
            checkPhoneNum(phone, code);
			break;
		case R.id.iv_clear:
			etPhoneNum.getText().clear();
			break;
		default:
			break;
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		if (s.length() > 0) {
			btnNext.setEnabled(true);
			ivClear.setVisibility(View.VISIBLE);
			btnNext.setBackgroundResource(R.drawable.smssdk_btn_enable);
		} else {
			btnNext.setEnabled(false);
			ivClear.setVisibility(View.GONE);
			btnNext.setBackgroundResource(R.drawable.smssdk_btn_disenable);
		}
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	private void checkPhoneNum(String phone, String code) {

		if (TextUtils.isEmpty(phone)) {
			Toast.makeText(this, R.string.smssdk_write_mobile_phone,
					Toast.LENGTH_SHORT).show();
			return;
		}
//		showDialog(phone, code);
	}

//	public void showDialog(final String phone, String code) {
//		String phoneNum = code + " " + splitPhoneNum(phone);
//		String strContent = getResources().getString(
//				R.string.smssdk_make_sure_mobile_detail)
//				+ phoneNum;
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//		builder.setTitle("Captcha")
//				.setIcon(R.drawable.ic_launcher)
//				.setCancelable(false)
//				.setMessage(strContent)
//				.setPositiveButton(R.string.smssdk_ok,
//						new DialogInterface.OnClickListener() {
//
//							@Override
//							public void onClick(DialogInterface dialog,
//									int which) {
//								// TODO Auto-generated method stub
//								showDialog(getResources()
//										.getString(
//												R.string.smssdk_get_verification_code_content));
//								captcha.sendCaptcha(phone,
//										new ResultCallBack() {
//
//											@Override
//											public void onResult(int arg0,
//													String arg1, String arg2) {
//												// TODO Auto-generated method
////                                                System.out.println(arg0);
////                                                System.out.println(arg1);
////                                                System.out.println(arg2);
//												// stub
//												closeDialog();
//												if (arg0 == 0) {
//													afterCaptchaRequested();
//												}
//
//											}
//										});
//
//							}
//						})
//				.setNegativeButton(R.string.smssdk_cancel,
//						new DialogInterface.OnClickListener() {
//
//							@Override
//							public void onClick(DialogInterface dialog,
//									int which) {
//								// TODO Auto-generated method stub
//								dialog.dismiss();
//							}
//						});
//
//		AlertDialog dlg = builder.create();
//		dlg.show();
//
//	}

	private void afterViryfied() {
		String phone = etPhoneNum.getText().toString().trim()
				.replaceAll("\\s*", "");
		String code = tvCountryNum.getText().toString().trim();
		String fomatedPhone = code + " " + splitPhoneNum(phone);

		Toast.makeText(this, "成功!", Toast.LENGTH_SHORT).show();
        //缓存个人信息
        String token = identifyCode.getText().toString();
        String name=username.getText().toString();
        String id=student_id.getText().toString();
        String password=student_password.getText().toString();
        Config.cacheToken(this,token);
        Config.cacheName(this,name);
        Config.cacheStudentId(this,id);
        Config.cacheStudentPassword(this,password);
        new Register(phone,name,id,password,this);

		Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
		intent.putExtra("formatedPhone", fomatedPhone);
		intent.putExtra("phone", phone);
		startActivity(intent);
        finish();
	}

	private String splitPhoneNum(String phone) {
		StringBuilder builder = new StringBuilder(phone);
		builder.reverse();
		for (int i = 4, len = builder.length(); i < len; i += 5) {
			builder.insert(i, ' ');
		}

		builder.reverse();
		return builder.toString();

	}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }

    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            Log.e("event", "event=" + event);
            System.out.println(result+"  "+event);
            if (result == SMSSDK.RESULT_COMPLETE) {
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功
                    Toast.makeText(getApplicationContext(), "提交验证码成功", Toast.LENGTH_SHORT).show();
                    afterViryfied();
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                    Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
                }
            } else {
                ((Throwable) data).printStackTrace();
                Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();

            }

        }

    };
}
