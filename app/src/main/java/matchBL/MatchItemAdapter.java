package matchBL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import po.MatchInfoPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/13.
 */
public class MatchItemAdapter extends BaseAdapter {

    private ArrayList<MatchInfoPO> data;
    private Context context;

    public MatchItemAdapter(ArrayList<MatchInfoPO> data,Context context){
        this.data = data;
        this.context = context;
    }

    public int getCount(){

        return data.size();

    }

    public Object getItem(int position) {

        return data.get(position);

    }

    public long getItemId(int position) {

        return position;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        MatchInfoPO po = (MatchInfoPO)getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.match_list_item,null);
            holder = new ViewHolder();
            holder.et_members = (EditText)convertView.findViewById(R.id.match_item_friends);
            holder.et_time = (EditText)convertView.findViewById(R.id.match_item_match_time);
            holder.tv_happen_time = (TextView)convertView.findViewById(R.id.match_item_get_time);
            holder.tv_happen_time.setText(po.getHappenTimeStr());
            holder.et_time.setText(po.getMatchTimeStr());
            holder.et_members.setText(po.getMemberStr());
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            holder.tv_happen_time.setText(po.getHappenTimeStr());
            holder.et_time.setText(po.getMatchTimeStr());
            holder.et_members.setText(po.getMemberStr());
            convertView.setTag(holder);
        }
        System.out.println("heheheda");
        return convertView;
    }

    static class ViewHolder{
        TextView tv_happen_time;
        EditText et_time;
        EditText et_members;
    }
}
