package turingmachine.com.sharetime20.subcontacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import turingmachine.com.sharetime20.R;


public class AddContactActivity extends ActionBarActivity {

    private SearchView sv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        sv= (SearchView) findViewById(R.id.sv_add_contact);
        lv= (ListView) findViewById(R.id.lv_add_contact);
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
