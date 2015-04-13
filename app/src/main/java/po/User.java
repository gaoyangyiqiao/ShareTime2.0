package po;

public class User {
	private Contacts contactsList;
	private UserInf userBaseInf;
	private Schedule schedule;
	public User(Contacts contactsList, Schedule schedule,int id,String name,String phoneNumber,String picturePath){
		this.contactsList=contactsList;
		this.schedule=schedule;
		this.userBaseInf=new UserInf(id,name,phoneNumber,picturePath);
		
	}
    public Object getInf(String type){
    	return userBaseInf.getInf(type);
    }
    public void setInf(String type,Object value){
    	userBaseInf.setInf(type,value);
    }
	public void addContacts(User user){
		contactsList.addContacts(user);
	}
	public void delectContacts(User user){
		contactsList.delectContacts(user);
	}
	public Schedule getSchedule(){
		return schedule;
	}

    @Override
    public String toString() {
        return "#user"+","+userBaseInf.toString()+","+schedule.toString()+","+contactsList.toString();
    }
}
