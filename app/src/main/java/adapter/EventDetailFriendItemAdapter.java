package adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import po.ContactPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/13.
 */
public class EventDetailFriendItemAdapter extends BaseAdapter {

    private List<ContactPO> data;
    private Context context;
    private ListView listView;

    public EventDetailFriendItemAdapter(Context context,List<ContactPO> data){
        this.data = data;
        this.context = context;
    }

    public boolean hasStableIds(){
        return true;//不知道可不可以这样
    }

    public boolean isEmpty(){
        return data.size() == 0?true:false;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactPO item = (ContactPO)getItem(position);
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.message_event_friend_item,null);
            holder = new ViewHolder();
            holder.iv = (ImageView)convertView.findViewById(R.id.message_event_friend_img);
            holder.tv_name = (TextView) convertView.findViewById(R.id.message_event_friend_name);
            holder.tv_phone = (TextView) convertView.findViewById(R.id.message_event_friend_phone);

            holder.tv_name.setText(item.getName());
            holder.tv_phone.setText(item.getPhone());
            holder.iv.setImageURI(Uri.parse(item.getImageurl()));

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
            holder.tv_name.setText(item.getName());
            holder.tv_phone.setText(item.getPhone());
            holder.iv.setImageURI(Uri.parse(item.getImageurl()));
            convertView.setTag(holder);
        }
        return convertView;
    }

    static class ViewHolder{
        ImageView iv;
        TextView tv_name;
        TextView tv_phone;
    }
}
