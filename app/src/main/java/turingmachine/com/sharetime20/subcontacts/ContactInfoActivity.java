package turingmachine.com.sharetime20.subcontacts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.tsz.afinal.FinalDb;

import po.ContactPO;
import turingmachine.com.sharetime20.R;

public class ContactInfoActivity extends ActionBarActivity {

    private ImageView icon;
    private TextView name,account,tip;
    private FinalDb db;
    private Button deleteBtn;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        //初始化
        icon= (ImageView) findViewById(R.id.contact_info_img);
        name= (TextView) findViewById(R.id.contact_info_name);
        account= (TextView) findViewById(R.id.contact_info_account);
        tip= (TextView) findViewById(R.id.contact_info_tv_tip);
        deleteBtn= (Button) findViewById(R.id.contact_info_btn_delete);

        id=getIntent().getIntExtra("id",-1);

        if(id==-1){
            ContactPO contact=contactController.getContact(id);
            Bitmap bitmap= BitmapFactory.decodeFile(contact.getImageurl());
            icon.setImageBitmap(bitmap);
            name.setText(contact.getName());
            account.setText(contact.getAccount());
            tip.setText(contact.getTip());
        }


        //左上角返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
}
