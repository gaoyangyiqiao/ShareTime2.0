package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import matchBL.GetMatchInfoList;
import matchBL.MatchBL;
import matchBL.MatchChooseContactsActivity;
import matchBL.MatchDetailActivity;
import matchBL.MatchItemAdapter;
import po.MatchInfoPO;

/**
 * Created by admin on 2015/3/28.
 */
public class MatchFragment extends Fragment{

    private ImageButton btn_new_match;
    private ListView lv_match_info;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getActivity().getBaseContext()).inflate(R.layout.activity_match,null);

        lv_match_info = (ListView) view.findViewById(R.id.lv_match_record);
        ArrayList<MatchInfoPO> data = MatchBL.getMatchInfoList();
        GetMatchInfoList.setMatchInfoList(data);
        MatchItemAdapter adapter = new MatchItemAdapter(data,getActivity());
        lv_match_info.setAdapter(adapter);
        lv_match_info.setOnItemClickListener(new ListItemClickListener());
        lv_match_info.setOnItemLongClickListener(new ListItemLongClickListener());

        btn_new_match = (ImageButton) view.findViewById(R.id.btn_match);
        btn_new_match.setOnClickListener(new ButtonClickListener());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchFragment = inflater.inflate(R.layout.activity_match,container,false);
        return matchFragment;
    }

    private class ButtonClickListener implements OnClickListener{
        public void onClick(View view){
            Intent i = new Intent(getActivity(), MatchChooseContactsActivity.class);
            startActivity(i);
        }
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        public void onItemClick(AdapterView<?> parent,View view,int position,long id){
            Intent i = new Intent(getActivity(), MatchDetailActivity.class);
            i.putExtra("index",position);
            startActivity(i);
        }
    }

    private class ListItemLongClickListener implements AdapterView.OnItemLongClickListener{
        public boolean onItemLongClick(AdapterView<?> parent,View view,final int position,long id) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setItems(new String[]{"删除","新建"},new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){
                    switch(which){
                        case 0:
                            delete(position);
                            break;
                        case 1:
                            build();
                            break;
                    }
                }
            })
            return true;
        }

        public void build(){

        }

        public void delete(int position){

        }
//        public boolean onItemLongClick(final AdapterView v,final View w,int a,long b){
//            AlertDialog.Builder builder = new AlertDialog.Builder(ScheduleActivity.this);
//
//
//            builder.setItems(new String[]{"删除","新建","邀请"},new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    switch(which){
//                        case 0://dialog.dismiss();
//                            w.getId();
//                            delectForList((ArrayAdapter)v.getAdapter(),w.getId(),getData());
//                            break;
//                        case 1:newActivity();break;
//                        case 2:contacts();break;
//                    }
//                }
//            });
//            builder.show();
//
//            return true;}
//        public void build( AlertDialog.Builder builder){
//            builder = new AlertDialog.Builder(ScheduleActivity.this);
//        }
//        public void contacts(){
//            userController u=new userController();
//            String[] namel=u.getContacts(scheduleConfig.user);
//            AlertDialog.Builder buildContacts = new AlertDialog.Builder(ScheduleActivity.this);
//            buildContacts.setTitle("选择联系人");
//            buildContacts.setMultiChoiceItems(namel,null,null);
//            buildContacts.setPositiveButton("确定",null);
//            buildContacts.setNegativeButton("取消",null);
//            buildContacts.show();
//        }
//        public void newActivity(){
//            AlertDialog.Builder buildActivitys = new AlertDialog.Builder(ScheduleActivity.this);
//            buildActivitys.setTitle("新建日程");
//            buildActivitys.setView(new EditText(null));
//            buildActivitys.setPositiveButton("确定",null);
//            buildActivitys.setNegativeButton("取消",null);
//            buildActivitys.show();
//        }

    }
}
