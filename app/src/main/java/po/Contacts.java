package po;

import java.util.ArrayList;
import java.util.List;

public class Contacts implements IContacts{
    private List<ContactInfo> contactsList;
    public Contacts(){
    	contactsList=new ArrayList<ContactInfo>();
    }
	@Override
	public void addContacts(Object user) {
		// TODO Auto-generated method stub
		contactsList.add((ContactInfo) user);
	}

	@Override
	public void delectContacts(Object user) {
		// TODO Auto-generated method stub
		contactsList.remove((ContactInfo) user);
	}

	@Override
	public int theTotalNumOfContacts() {
		// TODO Auto-generated method stub
		return contactsList.size();
	}

    @Override
    public String toString() {
//        String numbers="";
//        for(int i=0;i<contactsList.size();i++){
//            numbers+=("contact_id"+","+contactsList.getValueAt(i))+",";
//        }

//        return "#contacts"+","+numbers.substring(0,numbers.length()-1);
        return "#contacts"+","+contactsList.toString();
    }

    public List<ContactInfo> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<ContactInfo> contactsList) {
        this.contactsList = contactsList;
    }
}
