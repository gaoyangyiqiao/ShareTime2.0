package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactsFunctionAdapter;
import adapter.ContactsListAdapter;
import netconnection.Config;
import netconnection.GetContacts;
import po.ContactPO;
import po.UserPO;

/**
 * Created by admin on 2015/3/28.
 */
public class ContactsFragment extends Fragment {
    private View contactsFragment;
    private SearchView searchView;
    private ListView lv_contactList;
    private ContactsListAdapter contactsListAdapter;
    private ListView lv_functions;
    private ContactsFunctionAdapter contactsFunctionAdapter;
    private Button btn_contacts_promotion;
    private Button btn_createGroup;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contactsFragment = inflater.inflate(R.layout.activity_contacts,container,false);
        return contactsFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initFunctionLv();
        initContactListLv();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void initViews(){
        searchView= (SearchView) getActivity().findViewById(R.id.sv_contacts);
        lv_functions= (ListView) getActivity().findViewById(R.id.contacts_lv_functions);
        lv_contactList = (ListView) getActivity().findViewById(R.id.contacts_lv_contactlist);

    }

    public void initFunctionLv(){
        List<String> functions=new ArrayList<String>();
        functions.add("创建群组");
        functions.add("新的朋友");
        contactsFunctionAdapter=new ContactsFunctionAdapter(functions,getActivity());
        lv_functions.setAdapter(contactsFunctionAdapter);
    }
    //TODO
    public void initContactListLv(){
        List<ContactPO> contacts=new GetContacts().getInfo(Config.getCachedId(getActivity()));
        contactsListAdapter=new ContactsListAdapter(contacts,getActivity());
        lv_contactList.setAdapter(contactsListAdapter);
    }

    public void setListViewItemListener(){
        lv_functions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        lv_contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }



    }


