package turingmachine.com.sharetime20;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactsListAdapter;
import businesslogic.contactbl.ContactsController;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.ContactsPage;
import netconnection.Config;
import po.ContactPO;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapButton;
import turingmachine.com.sharetime20.subcontacts.AddContactActivity;
import turingmachine.com.sharetime20.subcontacts.ContactInfoActivity;
import turingmachine.com.sharetime20.subcontacts.ContactInfoFragment;

/**
 * Created by admin on 2015/3/28.
 */
public class ContactsFragment extends Fragment {
//  public static List<ContactPO> contacts =new ArrayList<>();

    private View contactsFragment;
    private SearchView searchView;
    private ListView lv_contactList;
    private ContactsListAdapter contactsListAdapter;
    //包含所有联系人
    public static List<ContactPO> contacts;
    //保存所有联系人的id
    public static final ArrayList<Integer> id_list=new ArrayList<>();

    private ContactsController contactsController;

    private BootstrapButton btn_contacts_promotion;
    private BootstrapButton btn_add_friend;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contactsFragment = inflater.inflate(R.layout.activity_contacts,container,false);
        return contactsFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
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
        lv_contactList = (ListView) getActivity().findViewById(R.id.contacts_lv_contactlist);
        btn_add_friend= (BootstrapButton) getActivity().findViewById(R.id.btn_add_friend);
        btn_contacts_promotion= (BootstrapButton) getActivity().findViewById(R.id.btn_contact_promotion);
        setListViewItemListener();
        setSearchViewListener();

        btn_contacts_promotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMSSDK.initSDK(getActivity(),Config.APP_SMS_KEY,Config.APP_SMS_SECRET);
                ContactsPage contactsPage=new ContactsPage();
                contactsPage.show(getActivity());
//
//                Intent i=new Intent(getActivity(),PhoneContactsActivity.class);
//                startActivity(i);
            }
        });
        btn_add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), AddContactActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
//        System.out.println("---->>>"+contacts.size());
        contactsListAdapter.updateListView(contacts);
        super.onResume();
    }


    //TODO
    public void initContactListLv(){
        contacts=new ArrayList<>();
        contactsListAdapter=new ContactsListAdapter(contacts,getActivity());
        contactsController=new ContactsController();
        contactsController.getContacts(Config.getCachedId(getActivity()), contactsListAdapter, contacts);
        lv_contactList.setAdapter(contactsListAdapter);
    }

    public void setSearchViewListener() {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //选择联系人界面的list内容
                if (newText.length()==0) {
                    contactsListAdapter.updateListView(contacts);
                }
                else {
                    contactsListAdapter.updateListView(contactsController.searchContacts(newText, contacts));
//                    System.out.println("---->>>>>size is "+contacts.size());
                }
                return true;
            }
        });
    }

    public void setListViewItemListener(){

        lv_contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(),ContactInfoActivity.class);
                i.putExtra("id",(contactsListAdapter.getItem(position)).getId());
                i.putExtra("isFromPhone", ContactInfoFragment.NOT_FROM_PHONE);
                i.putExtra("name",contactsListAdapter.getItem(position).getName());
                i.putExtra("img",contactsListAdapter.getItem(position).getImageurl());
                startActivity(i);
            }
        });
    }

    public ContactsListAdapter getContactsListAdapter() {
        return contactsListAdapter;
    }

}


