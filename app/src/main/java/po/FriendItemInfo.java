package po;

/**
 * Created by admin on 2015/3/7.
 */
public class FriendItemInfo {

    private String id;
    private String name;
    private String pic_path;

    public FriendItemInfo(){

        this.id = null;
        this.name = null;
        this.pic_path = null;

    }

    public FriendItemInfo(String id,String name,String pic_path){

        this.name = name;
        this.pic_path = pic_path;
        this.id = id;

    }

    public void setName(String newName){

        this.name = newName;

    }

    public void setPic_path(String newPath){

        this.pic_path = newPath;

    }

    public void setId(String newID){

        this.id = newID;

    }

    public String getName(){

        return  name;

    }

    public String getPic_path(){

        return pic_path;

    }

    public String getId(){

        return id;

    }

    public String  toString(){

        return this.getId()+","+this.getName()+","+this.getPic_path();

    }
}
