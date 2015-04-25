package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.MatchListItemAdapter;
import matchBL.GetMatchInfoList;
import matchBL.MatchBL;
import turingmachine.com.sharetime20.match_activity.MatchChooseContactsActivity;
import turingmachine.com.sharetime20.match_activity.MatchDetailActivity;
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
        MatchListItemAdapter adapter = new MatchListItemAdapter(data,getActivity().getBaseContext());
        System.out.println(data.size());
        lv_match_info.setAdapter(adapter);
        lv_match_info.setOnItemClickListener(new ListItemClickListener());
        lv_match_info.setOnItemLongClickListener(new ListItemLongClickListener());

        btn_new_match = (ImageButton) view.findViewById(R.id.btn_match);
        btn_new_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MatchChooseContactsActivity.class);
                startActivity(i);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchFragment = inflater.inflate(R.layout.activity_match,container,false);
        return matchFragment;
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
            });
            return true;
        }

        public void build(){
            Intent i = new Intent(getActivity(),MatchChooseContactsActivity.class);
            startActivity(i);
        }

        public void delete(int position){
            GetMatchInfoList.getData().remove(position);
        }
    }
}
