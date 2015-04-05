package businesslogic.contactbl;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import po.ContactPO;

/**
 * Created by gaoyang on 15/4/5.
 */
public interface ContactsService {

    public ArrayList<ContactPO> getContacts(String user_id,BaseAdapter adapter,List list);
}
