package turingmachine.com.sharetime20.message_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import adapter.EventDetailFriendItemAdapter;
import messageBL.GetInvitationDetail;
import messageBL.MessageBL;
import po.InvitationPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/11.
 */
public class InvitationDetailActivity extends Activity{

    private EditText et_invitation_sender;
    private EditText et_invitation_event_id;
    private EditText et_invitation_event_theme;
    private EditText et_invitation_event_founder;
    private EditText et_invitation_event_time;
    private EditText et_invitation_event_content;
    private ListView lv_members;
    private Button btn_accept;
    private Button btn_refuse;
    private final InvitationPO invitation = GetInvitationDetail.getInvitation();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_invitation_detail);
        initViews();
        et_invitation_sender.setText(invitation.getSender().getName());
        et_invitation_event_id.setText(invitation.getDetail().getId());
        et_invitation_event_theme.setText(invitation.getDetail().getTheme());
        et_invitation_event_founder.setText((String)invitation.getDetail().getFounder().getName());
        et_invitation_event_content.setText(invitation.getDetail().getContent());
        et_invitation_event_time.setText(invitation.getDetail().getTimeStr());
        lv_members.setAdapter(new EventDetailFriendItemAdapter(this,invitation.getDetail().getMembers()));
        ButtonClickListener listener = new ButtonClickListener();
        btn_accept.setOnClickListener(listener);
        btn_refuse.setOnClickListener(listener);
    }

    private void initViews(){
        et_invitation_sender = (EditText) findViewById(R.id.et_invitation_detail_sender);
        et_invitation_event_id = (EditText) findViewById(R.id.et_invitation_detail_id);
        et_invitation_event_theme = (EditText) findViewById(R.id.et_invitation_detail_theme);
        et_invitation_event_time = (EditText) findViewById(R.id.et_invitation_detail_time);
        et_invitation_event_content = (EditText) findViewById(R.id.et_event_detail_content);
        et_invitation_event_founder = (EditText) findViewById(R.id.et_invitation_detail_founder);
        lv_members = (ListView) findViewById(R.id.lv_event_detail_friend_list);
        btn_accept = (Button) findViewById(R.id.btn_invitation_accept);
        btn_refuse = (Button) findViewById(R.id.btn_invitation_reject);
    }

    private class ButtonClickListener implements OnClickListener{

        public void onClick(View view){
            switch(view.getId()){
                case R.id.btn_invitation_accept:
                    MessageBL.ensureAcceptInvitation(invitation);
                    break;
                case R.id.btn_invitation_reject:
                    MessageBL.ensureRefuseInvitation(invitation);
                    break;
            }
        }
    }
}
