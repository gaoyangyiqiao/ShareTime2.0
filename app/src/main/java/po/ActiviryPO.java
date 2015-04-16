package po;

/**
 * Created by gaoyang on 15/3/25.
 */
public class ActiviryPO {
    private String content;
    private String id;
    private String contacts_id;

    public ActiviryPO(){

    }

    public ActiviryPO(String content,String id,String contacts_id){
        this.content=content;
        this.id=id;
        this.contacts_id=contacts_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContacts_id() {
        return contacts_id;
    }

    public void setContacts_id(String contacts_id) {
        this.contacts_id = contacts_id;
    }
}
