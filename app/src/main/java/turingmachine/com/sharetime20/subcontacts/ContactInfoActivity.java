package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import businesslogic.contactbl.ContactsInfoController;
import turingmachine.com.sharetime20.R;

public class ContactInfoActivity extends Activity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ContactInfoFragment contactInfoFragment;
    private TextView tv_back;
    private ContactsInfoController contactsInfoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        fragmentManager=getFragmentManager();
        contactsInfoController=new ContactsInfoController();
        initViews();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_in_contactinfo,contactInfoFragment);
        fragmentTransaction.commit();
    }

    public void initViews(){
        contactInfoFragment=new ContactInfoFragment();

        tv_back= (TextView) findViewById(R.id.tv_back_in_contactinfo);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
