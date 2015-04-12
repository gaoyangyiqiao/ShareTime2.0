package businesslogic.contactbl;


import java.util.List;

import adapter.ContactsListAdapter;

/**
 * Created by gaoyang on 15/4/5.
 */
public interface ContactsService {

    public void getContacts(String user_id, ContactsListAdapter adapter,List list);
}
