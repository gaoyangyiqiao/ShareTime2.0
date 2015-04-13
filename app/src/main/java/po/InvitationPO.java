package po;

/**
 * Created by gaoyang on 15/3/25.
 */
public class InvitationPO {

    private String id;
    private String sender;
    private ActivityDetailPO detail;

    public InvitationPO(String id,String sender, ActivityDetailPO detail){
        this.id = id;
        this.sender = sender;
        this.detail = detail;
    }

    public String getId(){
        return id;
    }

    public String getSender(){
        return sender;
    }

    public ActivityDetailPO getDetail(){
        return detail;
    }
}
