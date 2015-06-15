package businesslogic.contactbl;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import po.ContactPO;

/**
 * Created by gaoyang on 15/4/5.
 */
public class PhoneContactsController implements PhoneContactsService {
    private List<ContactPO> list;

    public PhoneContactsController(){
        list=new ArrayList<>();
    }
    @Override
    public List<ContactPO> getContacts(Context context) {
        Cursor cursor;
        cursor = context.getContentResolver()
                .query(ContactsContract
                        .CommonDataKinds
                        .Phone.CONTENT_URI,null,null,null,null);
        String phoneNumber,phoneName;
        while(cursor.moveToNext()){
            phoneNumber=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            phoneName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            ContactPO contact=new ContactPO(phoneName);
            contact.setPhone(phoneNumber);
            list.add(contact);
        }
        return list;
    }
}
