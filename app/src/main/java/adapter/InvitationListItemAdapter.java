package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import po.InvitationPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/24.
 */
public class InvitationListItemAdapter extends BaseAdapter{

    private List<InvitationPO> data;
    private Context context;
    private LinearLayout layout;
    public InvitationListItemAdapter(List<InvitationPO> list,Context ct){
        this.data.addAll(list);
        this.context = ct;
    }
    public List<InvitationPO> getData(){
        return data;
    }
    public Context getContext(){
        return context;
    }
    public LinearLayout getLayout(){
        return layout;
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
    static class ViewHolder{
        TextView tv_name;
        TextView tv_time;
        ImageView iv_icon;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.message_invitation_item,null);
            holder = new ViewHolder();

            holder.tv_name = (TextView)convertView.findViewById(R.id.invitation_item_friend_name);
            holder.tv_time = (TextView)convertView.findViewById(R.id.invitation_item_time);
            holder.iv_icon = (ImageView)convertView.findViewById(R.id.invitation_item_friend_img);
            if(data.get(position).getSenderIconUrl() != null){
                try{
                    FileInputStream fileInputStream = new FileInputStream(data.get(position).getSenderIconUrl());
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    holder.iv_icon.setImageBitmap(bitmap);
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            holder.tv_name.setText(data.get(position).getSender().getName());
            holder.tv_time.setText(data.get(position).getTimeStr());
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
            holder.tv_name = (TextView)convertView.findViewById(R.id.invitation_item_friend_name);
            holder.tv_time = (TextView)convertView.findViewById(R.id.invitation_item_time);
            holder.iv_icon = (ImageView)convertView.findViewById(R.id.invitation_item_friend_img);
            if(data.get(position).getSenderIconUrl() != null){
                try{
                    FileInputStream fileInputStream = new FileInputStream(data.get(position).getSenderIconUrl());
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    holder.iv_icon.setImageBitmap(bitmap);
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
            holder.tv_name.setText(data.get(position).getSender().getName());
            holder.tv_time.setText(data.get(position).getTimeStr());
            convertView.setTag(holder);
        }
        return convertView;
    }
    public void updateListView(List<InvitationPO> list){
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }
    public void addAll(List<InvitationPO> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }
    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }
}
