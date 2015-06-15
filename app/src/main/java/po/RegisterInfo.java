package po;

public class RegisterInfo {
	private String name;
	private String phoneNumber;
	public RegisterInfo(String name,String phoneNumber){
		this.name=name;
		this.phoneNumber=phoneNumber;
	}
	public String getName(){
		return name;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
    public String toString() {
        return "#RegisterInfo,name," + name +",phoneNumber," + phoneNumber;
    }
}
