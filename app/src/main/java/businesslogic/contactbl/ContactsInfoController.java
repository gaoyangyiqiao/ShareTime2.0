package businesslogic.contactbl;

import netconnection.GetContactInfo;
import turingmachine.com.sharetime20.subcontacts.ContactInfoActivity;

/**
 * Created by gaoyang on 15/4/5.
 */
public class ContactsInfoController implements  ContactInfoService{

    @Override
    public void displayContactInfo(String id,ContactInfoActivity contactInfoActivity) {
            new GetContactInfo().displayContactInfo(id,contactInfoActivity);
    }
}
