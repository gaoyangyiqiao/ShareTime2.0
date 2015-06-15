package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactsListAdapter;
import businesslogic.contactbl.SearchContactController;
import netconnection.Config;
import po.ContactPO;
import turingmachine.com.sharetime20.R;


public class AddContactActivity extends Activity {

    private SearchView sv;
    private TextView tv_back;
    private ListView lv;
    private List<ContactPO> contactPOList;
    private ContactsListAdapter contactsListAdapter;
    private SearchContactController searchContactController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        searchContactController=new SearchContactController();
        initViews();
        sv= (SearchView) findViewById(R.id.sv_add_contact);
        lv= (ListView) findViewById(R.id.lv_add_contact);

        contactPOList=new ArrayList<>();
        contactsListAdapter=new ContactsListAdapter(contactPOList,this);

        lv.setAdapter(contactsListAdapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()==0||newText==null){
//                    System.out.println("--->>>empty input");
                    contactsListAdapter.clear();
                }
                if(newText.length()!=0){
//                    System.out.println("--->>>>"+newText.length());
                    searchContactController.searchUser(Config.getCachedId(getApplicationContext()),newText,contactsListAdapter);
                }
                return true;
            }

        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(AddContactActivity.this,ContactInfoActivity.class);
                ContactPO contactPO=contactsListAdapter.getItem(position);
                i.putExtra("isFromPhone",ContactInfoFragment.NOT_FROM_PHONE);
                i.putExtra("id",contactPO.getId());
                i.putExtra("name",contactPO.getName());
                i.putExtra("img",contactPO.getImageurl());
                startActivity(i);
            }
        });

    }

    public void initViews(){
        tv_back= (TextView) findViewById(R.id.tv_back_in_addcontact);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
