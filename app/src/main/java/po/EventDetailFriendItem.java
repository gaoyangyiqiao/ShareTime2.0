package po;

/**
 * Created by admin on 2015/4/13.
 */
public class EventDetailFriendItem {

    private String name;
    private String phone;
    private String pic_path;

    public EventDetailFriendItem(String name,String phone,String pic_path){
        this.name = name;
        this.phone = phone;
        this.pic_path = pic_path;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getPic_path(){
        return pic_path;
    }
}
