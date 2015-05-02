package businesslogic.contactbl;

import java.util.List;

import adapter.ContactsListAdapter;
import netconnection.SearchUser;
import po.ContactPO;

/**
 * Created by gaoyang on 15/4/5.
 */
public class SearchContactController {

    public SearchContactController(){}

    public void searchUser(String user_id,String keywords, final ContactsListAdapter adapter,final List<ContactPO> list){
        new SearchUser(user_id,keywords,adapter,list);

    }
}
