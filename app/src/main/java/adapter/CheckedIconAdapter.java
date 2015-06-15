package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import po.CheckedImgPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/4/24.
 */
public class CheckedIconAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CheckedImgPO> data;
    private static class ViewHolder{
        ImageView icon;
        String id;
    }
    public CheckedIconAdapter(Context context,ArrayList<CheckedImgPO> data){
        this.context = context;
        this.data = data;
    }
    public ArrayList<CheckedImgPO> getData(){
        return data;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return data.get(position);
    }
    public long getItemId(int position) {
        return 0;
    }
    public void addImg(String img,String name,String id){
        CheckedImgPO icon = new CheckedImgPO();
        icon.setId(id);
        icon.setImg(img);
        icon.setName(name);
        data.add(icon);
        notifyDataSetChanged();
    }
    public View getView(int position, View convertView, ViewGroup parent){
        CheckedImgPO map = data.get(position);
        final String img = map.getImg();

        ViewHolder holder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.checked_img_item,null);
            holder = new ViewHolder();
            holder.icon = (ImageView)convertView.findViewById(R.id.contactitem_touxiang);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        if(map.getId().equals("default")){
            holder.icon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
        }
        else{
            holder.icon.setImageDrawable(getImage(img));
        }
        holder.id = map.getId();

        return convertView;
    }
    public Drawable getImage(String img){
        return context.getResources().getDrawable(R.drawable.ic_launcher);
    }
}
