package messageBL;

import po.InvitationPO;

/**
 * Created by admin on 2015/4/13.
 */
public class GetInvitationDetail {//运用单例模式

    private static InvitationPO invitation;

    public static void setInvitation(InvitationPO po){
        invitation = po;
    }

    public static InvitationPO getInvitation(){
        return invitation;
    }
}
