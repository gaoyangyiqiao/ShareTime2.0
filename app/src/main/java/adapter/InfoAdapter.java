package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import po.ContactPO;
import turingmachine.com.sharetime20.R;


//private int id;
//private String imageurl;
////备注
//private String tip;
//private int root;
//private String phone;
//private String account;
//private String name;
////用来排序的名称首字母
//private String sortLetters;
/**
 * Created by gaoyang on 15/5/29.
 */
public class InfoAdapter extends BaseAdapter {
    //姓名，账号，学号，权限
    private ArrayList infolist;
    private Context context;


    public InfoAdapter(ArrayList infolist,Context context){
        this.context=context;
        if(infolist!=null&&infolist.size()!=0)
            this.infolist=infolist;
    }
    @Override
    public int getCount() {
        return infolist.size();
    }

    @Override
    public Object getItem(int position) {
        return infolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //即使数据量非常庞大也不会卡顿
        ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.info_cell,null);
            holder=new ViewHolder();

            holder.info= (TextView) convertView.findViewById(R.id.info_list_info);
            holder.arrow= (ImageView) convertView.findViewById(R.id.info_arrow);
            convertView.setTag(holder);

        }else{
            holder= (ViewHolder) convertView.getTag();
            holder.info.setText(infolist.get(2*position).toString());
            holder.intro.setText(infolist.get(2*position-1).toString());
        }

        return convertView;
    }


    public void updateListView(List<ContactPO> list){
        this.infolist.clear();
        this.infolist.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(List<ContactPO> data){
        this.infolist.addAll(data);
        notifyDataSetChanged();
    }

    public void clear(){
        infolist.clear();
        notifyDataSetChanged();
    }
    private static class ViewHolder{
        ImageView arrow;
        TextView intro;
        TextView info;
    }
}
