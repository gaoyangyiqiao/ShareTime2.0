package matchBL;


/**
 * Created by admin on 2015/3/7.
 */
public class CheckedImg {
    private String img;
    private String name;
    private String id;
    public  CheckedImg(){
        this.img = null;
        this.name = null;
        this.id = null;
    }
    public CheckedImg(String img,String name,String id){
        this.id = id;
        this.name = name;
        this.img = img;
    }
    public void setImg(String img){
        this.img = img;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getImg(){
        return this.img;
    }
    public String getName(){
        return this.name;
    }
    public String getId(){
        return id;
    }
}
