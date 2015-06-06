package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import businesslogic.contactbl.ContactsInfoController;
import turingmachine.com.sharetime20.R;

public class ContactInfoActivity extends Activity {

    private ImageView icon;
    private TextView name,account,tip;
    private Button deleteBtn;
    private int id;
    private ContactsInfoController contactsInfoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        contactsInfoController=new ContactsInfoController();
        //初始化
        icon= (ImageView) findViewById(R.id.contact_info_img);
        name= (TextView) findViewById(R.id.contact_info_name);
        account= (TextView) findViewById(R.id.contact_info_account);
        tip= (TextView) findViewById(R.id.contact_info_tv_tip);
        deleteBtn= (Button) findViewById(R.id.contact_info_btn_delete);

        id=getIntent().getIntExtra("id",-1);

        if(id!=-1){
            contactsInfoController.displayContactInfo(id+"",this);
        }


        //左上角返回按钮
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_settings:
                break;
            //这里的id是主activity的id
            case R.id.home:
                finish();
                break;
            default:
                finish();
                break;
        }
            return super.onOptionsItemSelected(item);
    }

    public ImageView getIcon() {
        return icon;
    }

    public TextView getTip() {
        return tip;
    }

    public TextView getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }

    public TextView getName() {
        return name;

    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public void setAccount(TextView account) {
        this.account = account;
    }

    public void setTip(TextView tip) {
        this.tip = tip;
    }

    public void setId(int id) {
        this.id = id;
    }
}
