package turingmachine.com.sharetime20.subcontacts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.util.List;

import po.ContactPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by gaoyang on 15/3/5.
 */
public class PhoneContactsAdapter extends BaseAdapter{

    private List<ContactPO> lists;
    private Context context;
    private LinearLayout layout;

    public PhoneContactsAdapter(List<ContactPO> lists,Context context){
        this.lists=lists;
        this.context=context;

    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
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
            convertView= LayoutInflater.from(context).inflate(R.layout.phonecontacts_view_cell,null);
            holder=new ViewHolder();
            holder.tv_name= (TextView) convertView.findViewById(R.id.phonecontacts_view_cell_tv_name);
            holder.tv_name.setText(lists.get(position).getName());
            holder.imv_icon= (ImageView) convertView.findViewById(R.id.phonecontacts_view_cell_iv);
            holder.btn_add= (Button) convertView.findViewById(R.id.phonecontacts_view_cell_add_btn);
            holder.imv_icon.setImageDrawable(convertView.getResources().getDrawable(R.drawable.o));
            if(lists.get(position).getImageurl()!=null){
                try {
                    FileInputStream fileInputStream=new FileInputStream(lists.get(position).getImageurl());
                    Bitmap bitmap= BitmapFactory.decodeStream(fileInputStream);
                    holder.imv_icon.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            convertView.setTag(holder);

        }else{
            holder= (ViewHolder) convertView.getTag();
            holder.tv_name.setText(lists.get(position).getName());
        }

        return convertView;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     * @param list
     */
    public void updateListView(List<ContactPO> list){
        this.lists = list;
        notifyDataSetChanged();
    }

    private static class ViewHolder{
        ImageView imv_icon;
        TextView tv_name;
        Button btn_add;
    }
}
