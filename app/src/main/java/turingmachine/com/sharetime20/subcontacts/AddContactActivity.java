package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactsListAdapter;
import businesslogic.contactbl.SearchContactController;
import netconnection.Config;
import po.ContactPO;
import turingmachine.com.sharetime20.R;


public class AddContactActivity extends Activity {

    private SearchView sv;
    private ListView lv;
    private List<ContactPO> contactPOList;
    private ContactsListAdapter contactsListAdapter;
    private SearchContactController searchContactController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        searchContactController=new SearchContactController();

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
                if(newText!=null){
                    searchContactController.searchUser(Config.getCachedId(getApplicationContext()),newText,contactsListAdapter,contactPOList);
                }
                return true;
            }

        });

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                return true;
            default:
                finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
