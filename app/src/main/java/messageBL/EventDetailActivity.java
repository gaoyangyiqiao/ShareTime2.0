package messageBL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import po.ActivityDetailPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/11.
 */
public class EventDetailActivity extends Activity {

    private EditText et_event_Id;
    private EditText et_event_theme;
    private EditText et_event_founder;
    private EditText et_event_time;
    private EditText et_event_content;
    private ListView lv_event_members;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_event_detail);
        initView();

        ActivityDetailPO po = GetEventDetail.getActivityDetail();
        et_event_Id.setText(po.getId());
        et_event_content.setText(po.getEvent());
        et_event_time.setText(po.getTimeStr());
        et_event_theme.setText(po.getTheme());
        et_event_founder.setText((String)po.getUser().getInf("name"));
        lv_event_members.setAdapter(new EventDetailFriendItemAdapter(this,po.getMembersListInfo()));
    }

    private void initView(){
        et_event_Id = (EditText) findViewById(R.id.et_event_detail_id);
        et_event_theme = (EditText) findViewById(R.id.et_event_detail_theme);
        et_event_founder = (EditText) findViewById(R.id.et_event_detail_founder);
        et_event_content = (EditText) findViewById(R.id.et_event_detail_content);
        lv_event_members = (ListView) findViewById(R.id.lv_event_detail_friend_list);
        et_event_time = (EditText) findViewById(R.id.et_event_detail_time);
    }
}
