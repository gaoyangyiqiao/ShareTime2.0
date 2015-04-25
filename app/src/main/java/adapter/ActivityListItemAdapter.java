package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import po.CheckedImgPO;
import po.ContactPO;
import ui_tools.HorizontalListView;
import po.ActivityDetailPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/24.
 */
public class ActivityListItemAdapter extends BaseAdapter {

    private List<ActivityDetailPO> data;
    private Context context;
    private LinearLayout layout;
    public ActivityListItemAdapter(List<ActivityDetailPO> data,Context context){
        this.data = data;
        this.context = context;
    }
    public List<ActivityDetailPO> getData(){
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
    public void updateListView(List<ActivityDetailPO> list){
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }
    public void addAll(List<ActivityDetailPO> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }
    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }
    static class ViewHolder{
        ImageView iv_icon;
        EditText et_time;
        EditText et_theme;
        TextView tv_name;
        TextView tv_time;
        HorizontalListView hlv_member;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.message_event_item,null);
            holder.iv_icon = (ImageView)convertView.findViewById(R.id.iv_event_list_item_friend_icon);
            holder.et_theme = (EditText)convertView.findViewById(R.id.et_event_list_item_theme_edit);
            holder.et_time = (EditText)convertView.findViewById(R.id.et_event_list_item_time_edit);
            holder.hlv_member = (HorizontalListView)convertView.findViewById(R.id.lv_event_list_item_memebers);
            holder.tv_name = (TextView)convertView.findViewById(R.id.tv_event_list_item_friend_name);
            holder.tv_time = (TextView)convertView.findViewById(R.id.tv_event_list_item_receive_time);
            ActivityDetailPO po = data.get(position);
            if(po.getFounderIconStr() != null){
                try{
                    FileInputStream fileInputStream = new FileInputStream(new File(po.getFounderIconStr()));
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    holder.iv_icon.setImageBitmap(bitmap);
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            holder.et_theme.setText(po.getTheme());
            holder.et_time.setText(po.getTimeStr());
            holder.tv_time.setText(po.getReceiveTimeStr());
            holder.tv_name.setText(po.getFounder().getName());
            ArrayList<CheckedImgPO> imgs = new ArrayList<CheckedImgPO>();
            ArrayList<ContactPO> contacts = po.getMembers();
            for(int i = 0;i < contacts.size();i++){
                imgs.add(new CheckedImgPO(contacts.get(i).getImageurl(),contacts.get(i).getName(),String.valueOf(contacts.get(i).getId())));
            }
            CheckedIconAdapter checkedIconAdapter = new CheckedIconAdapter(convertView.getContext(),imgs);
            holder.hlv_member.setAdapter(checkedIconAdapter);
            checkedIconAdapter.notifyDataSetChanged();
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
            ActivityDetailPO po = data.get(position);
            if(po.getFounderIconStr() != null){
                try{
                    FileInputStream fileInputStream = new FileInputStream(new File(po.getFounderIconStr()));
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    holder.iv_icon.setImageBitmap(bitmap);
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            holder.et_theme.setText(po.getTheme());
            holder.et_time.setText(po.getTimeStr());
            holder.tv_time.setText(po.getReceiveTimeStr());
            holder.tv_name.setText(po.getFounder().getName());
            ArrayList<CheckedImgPO> imgs = new ArrayList<CheckedImgPO>();
            ArrayList<ContactPO> contacts = po.getMembers();
            for(int i = 0;i < contacts.size();i++){
                imgs.add(new CheckedImgPO(contacts.get(i).getImageurl(),contacts.get(i).getName(),String.valueOf(contacts.get(i).getId())));
            }
            CheckedIconAdapter checkedIconAdapter = new CheckedIconAdapter(convertView.getContext(),imgs);
            holder.hlv_member.setAdapter(checkedIconAdapter);
            checkedIconAdapter.notifyDataSetChanged();
            convertView.setTag(holder);
        }
        return convertView;
    }
}
