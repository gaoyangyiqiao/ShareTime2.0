package businesslogic.contactbl;

import android.content.Context;

import java.util.List;

import po.ContactPO;

/**
 * Created by gaoyang on 15/4/5.
 */
public interface PhoneContactsService {
    public List<ContactPO> getContacts(Context context);
}
