package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import po.CheckedImgPO;
import po.ContactPO;
import po.MatchInfoPO;
import turingmachine.com.sharetime20.R;
import ui_tools.HorizontalListView;

/**
 * Created by admin on 2015/4/24.
 */
public class MatchListItemAdapter extends BaseAdapter{

    private List<MatchInfoPO> data;
    private Context context;

    public MatchListItemAdapter(List<MatchInfoPO> data,Context context){
        this.data = data;
        this.context = context;
    }
    public List<MatchInfoPO> getData(){
        return data;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return data.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public void updateListView(List<MatchInfoPO> list){
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }
    public void addAll(List<MatchInfoPO> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }
    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }
    static class ViewHolder{
        TextView tv_time;
        EditText et_time;
        HorizontalListView lv_friend;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.match_list_item,null);
            holder.tv_time = (TextView)convertView.findViewById(R.id.match_item_get_time);
            holder.et_time = (EditText)convertView.findViewById(R.id.match_item_match_time);
            holder.lv_friend = (HorizontalListView)convertView.findViewById(R.id.match_item_friends);
            MatchInfoPO po = data.get(position);
            holder.tv_time.setText(po.getReceiveTimeStr());
            holder.et_time.setText(po.getTimeListStr());
            ArrayList<CheckedImgPO> imgs = new ArrayList<CheckedImgPO>();
            ArrayList<ContactPO> contacts = data.get(position).getMembers();
            for(int i = 0;i < contacts.size();i++){
                imgs.add(new CheckedImgPO(contacts.get(i).getImageurl(),contacts.get(i).getName(),String.valueOf(contacts.get(i).getId())));
            }
            CheckedIconAdapter checkedIconAdapter = new CheckedIconAdapter(convertView.getContext(),imgs);
            holder.lv_friend.setAdapter(checkedIconAdapter);
            checkedIconAdapter.notifyDataSetChanged();
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
            MatchInfoPO po = data.get(position);
            holder.tv_time.setText(po.getReceiveTimeStr());
            holder.et_time.setText(po.getTimeListStr());
            ArrayList<CheckedImgPO> imgs = new ArrayList<CheckedImgPO>();
            ArrayList<ContactPO> contacts = data.get(position).getMembers();
            for(int i = 0;i < contacts.size();i++){
                imgs.add(new CheckedImgPO(contacts.get(i).getImageurl(),contacts.get(i).getName(),String.valueOf(contacts.get(i).getId())));
            }
            CheckedIconAdapter checkedIconAdapter = new CheckedIconAdapter(convertView.getContext(),imgs);
            holder.lv_friend.setAdapter(checkedIconAdapter);
            checkedIconAdapter.notifyDataSetChanged();
            convertView.setTag(holder);
        }
        return convertView;
    }
}
