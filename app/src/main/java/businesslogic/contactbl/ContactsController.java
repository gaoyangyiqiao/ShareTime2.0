package businesslogic.contactbl;

import android.widget.Adapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import po.ContactPO;

/**
 * Created by gaoyang on 15/4/5.
 */
public class ContactsController implements ContactsService {

    @Override
    public ArrayList<ContactPO> getContacts(String user_id,BaseAdapter adapter,List list) {
        return null;
    }
}
