package po;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;

/**
 * Created by gaoyang on 15/3/25.
 */
@Table(name="contacts")
public class ContactPO {

    @Id(column="id")
    private int id;
    private String imageurl;
    //备注
    private String tip;
    private int root;
    private String phone;
    private String account;
    private String name;
    //用来排序的名称首字母
    private String sortLetters;

    public ContactPO(String name){
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ContactPO){
            ContactPO contactPO= (ContactPO) o;
            return this.getId()==contactPO.getId();
        }
        return super.equals(o);
    }
}
