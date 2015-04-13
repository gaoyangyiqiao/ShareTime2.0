package messageBL;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import po.ActivityItem;
import po.LinkList;
import po.TimeNode;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/11.
 */
public class EventItemAdapter extends BaseAdapter {
    private List<ActivityItem> list;
    private Context context;

    public EventItemAdapter(List<ActivityItem> list,Context context){

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

        ImageView founder_icon;
        TextView tv_name;
        TextView tv_theme;
        TextView tv_time;

    }
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder holder;
        if(convertView==null){

            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.message_event_item,null);
            holder.founder_icon = (ImageView) convertView.findViewById(R.id.iv_event_list_item_friend_icon);
            holder.tv_name = (TextView)convertView.findViewById(R.id.tv_event_list_item_friend_name);
            holder.tv_theme = (EditText)convertView.findViewById(R.id.et_event_list_item_theme_edit);
            holder.tv_time = (EditText)convertView.findViewById(R.id.et_event_list_item_time_edit);

            holder.founder_icon.setImageURI(Uri.parse((String) list.get(position).getUser().getInf("picture path")));
            holder.tv_name.setText((String)list.get(position).getUser().getInf("name"));
            holder.tv_theme.setText(list.get(position).getTheme());

            LinkList<TimeNode> timeNodeLinkList = list.get(position).getTimeList();
            TimeNode head = timeNodeLinkList.getHead();
            TimeNode tail = timeNodeLinkList.getTail();
            Date startTime = head.getStartTime();
            Date endTime = tail.getEndTime();
            String timeStr = getTimeStr(startTime,endTime);
            holder.tv_time.setText(timeStr);

            convertView.setTag(holder);

        }
        else{

            holder = (ViewHolder)convertView.getTag();
            holder.founder_icon.setImageURI(Uri.parse((String)list.get(position).getUser().getInf("picture path")));
            holder.tv_name.setText((String)list.get(position).getUser().getInf("name"));
            holder.tv_theme.setText(list.get(position).getTheme());

            LinkList<TimeNode> timeNodeLinkList = list.get(position).getTimeList();
            TimeNode head = timeNodeLinkList.getHead();
            TimeNode tail = timeNodeLinkList.getTail();
            Date startTime = head.getStartTime();
            Date endTime = tail.getEndTime();
            String timeStr = getTimeStr(startTime,endTime);
            holder.tv_time.setText(timeStr);

        }

        return convertView;
    }

    private String getTimeStr(Date start,Date end){

        String str = new Integer(start.getYear()).toString();
        str += "/";
        str += new Integer(start.getMonth()).toString();
        str += "/";
        str += new Integer(start.getDate()).toString();
        str += "/";
        str += new Integer(start.getHours()).toString();
        str += ":";
        str += new Integer(start.getMinutes()).toString();
        str += "--";
        str = new Integer(end.getYear()).toString();
        str += "/";
        str += new Integer(end.getMonth()).toString();
        str += "/";
        str += new Integer(end.getDate()).toString();
        str += "/";
        str += new Integer(end.getHours()).toString();
        str += ":";
        str += new Integer(end.getMinutes()).toString();

        return str;

    }
}
