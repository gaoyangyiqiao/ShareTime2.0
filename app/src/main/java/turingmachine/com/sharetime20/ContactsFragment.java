package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

/**
 * Created by admin on 2015/3/28.
 */
public class ContactsFragment extends Fragment {
    private SearchView searchView;
    private ListView listView;
    private Button btn_contacts_promotion;
    private Button btn_createGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contactsFragment = inflater.inflate(R.layout.activity_contacts,container,false);
        initViews();
        return contactsFragment;
    }

    public void initViews(){
        searchView= (SearchView) getActivity().findViewById(R.id.sv_contacts);
        listView= (ListView) getActivity().findViewById(R.id.lv_contacts);
        btn_contacts_promotion= (Button) getActivity().findViewById(R.id.contacts_newfriends_btn);
        btn_createGroup= (Button) getActivity().findViewById(R.id.contacts_creat_group);
    }

    }


