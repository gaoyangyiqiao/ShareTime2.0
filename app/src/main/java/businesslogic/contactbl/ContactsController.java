package businesslogic.contactbl;

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
    public void getContacts(String user_id,final BaseAdapter adapter,final List list) {
        new GetContacts().getContacts(user_id,adapter,list);
    }

    public List<ContactPO> searchContacts(String key,final List<ContactPO> all){
        List<ContactPO> result=new ArrayList<>();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getName().contains(key)){
                result.add(all.get(i));
            }
        }
        return result;
    }
}
