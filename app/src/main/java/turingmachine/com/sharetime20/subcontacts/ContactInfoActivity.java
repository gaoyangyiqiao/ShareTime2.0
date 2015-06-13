package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import businesslogic.contactbl.ContactsInfoController;
import turingmachine.com.sharetime20.R;

public class ContactInfoActivity extends Activity {

    private ImageView icon;
    private TextView tv_name, tv_account;
    private Button deleteBtn;
    private String id;
    private String name;
    private String imgurl;
    private TextView tv_back;
    private ContactsInfoController contactsInfoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        contactsInfoController=new ContactsInfoController();
        initViews();
        id=getIntent().getStringExtra("id");
        imgurl=getIntent().getStringExtra("img");
        name=getIntent().getStringExtra("tv_name");

        //左上角返回按钮
    }

    public void initViews(){
        //初始化
        icon= (ImageView) findViewById(R.id.contact_info_img);
        tv_name = (TextView) findViewById(R.id.contact_info_name);
        tv_account = (TextView) findViewById(R.id.contact_info_account);
//        tip= (TextView) findViewById(R.id.contact_info_tv_tip);
        deleteBtn= (Button) findViewById(R.id.contact_info_btn_delete);
        tv_back= (TextView) findViewById(R.id.tv_back_in_contactinfo);

        tv_name.setText(name);
        tv_account.setText(id);
        //TODO 获取网络头像


        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
