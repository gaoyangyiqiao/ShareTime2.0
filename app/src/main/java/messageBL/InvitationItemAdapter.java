package messageBL;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import po.Invitation;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/11.
 */
public class InvitationItemAdapter extends BaseAdapter{
    private List<Invitation> list;
    private Context context;

    public InvitationItemAdapter(List<Invitation> list,Context context){

        this.list = list;
        this.context = context;

    }

    public int getCount(){

        return list.size();

    }

    public Object getItem(int position) {

        return list.get(position);

    }

    public long getItemId(int position) {

        return position;

    }

    private static class ViewHolder{

        ImageView img;
        TextView tv_name;
        TextView tv_time;
        TextView tv_start_time;

    }

    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder holder;
        if(convertView==null){

            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.message_invitation_item,null);
            holder.img = (ImageView)convertView.findViewById(R.id.invitation_item_friend_img);
            holder.tv_name = (TextView)convertView.findViewById(R.id.invitation_item_friend_name);
            holder.tv_time = (TextView)convertView.findViewById(R.id.invitation_item_time);
            holder.tv_start_time = (TextView)convertView.findViewById(R.id.invitation_item_start_time);

            holder.img.setImageURI(Uri.parse((String) list.get(position).getUser().getInf("picture path")));
            holder.tv_name.setText((String)list.get(position).getUser().getInf("name"));
            holder.tv_time.setText(getCurrentTime());
            holder.tv_start_time.setText(getDateString(list.get(position).getStartTime()));

            convertView.setTag(holder);

        }
        else{

            holder = (ViewHolder)convertView.getTag();
            holder.img.setImageURI(Uri.parse((String)list.get(position).getUser().getInf("picture path")));
            holder.tv_name.setText((String)list.get(position).getUser().getInf("name"));
            holder.tv_time.setText(getCurrentTime());
            holder.tv_start_time.setText(getDateString(list.get(position).getStartTime()));

        }

        return convertView;
    }

    private String getDateString(Date date){

        String str = new Integer(date.getYear()).toString();
        str += "年";
        str += new Integer(date.getMonth()).toString();
        str += "月";
        str += new Integer(date.getDate()).toString();
        str += "日";
        str += new Integer(date.getHours()).toString();
        str += ":";
        str += new Integer(date.getMinutes()).toString();
        str += ":";
        str += new Integer(date.getSeconds()).toString();
        return str;

    }

    private String getCurrentTime(){

        Date date = new Date();
        String str = new Integer(date.getHours()).toString();
        str += ":";
        str += new Integer(date.getMinutes()).toString();
        return str;

    }
}
