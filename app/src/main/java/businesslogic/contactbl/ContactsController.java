package businesslogic.contactbl;

import android.widget.Adapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import netconnection.GetContacts;
import po.ContactPO;

/**
 * Created by gaoyang on 15/4/5.
 */
public class ContactsController implements ContactsService {

    @Override
    public void getContacts(String user_id,BaseAdapter adapter,List list) {
        new GetContacts().getContacts(user_id,adapter,list);
    }
}
