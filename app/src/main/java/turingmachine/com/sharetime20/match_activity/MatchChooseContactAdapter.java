package turingmachine.com.sharetime20.match_activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import po.ContactPO;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.touchCheckBox.TouchCheckBox;

/**
 * Created by gaoyang on 15/6/14.
 */
public class MatchChooseContactAdapter extends BaseAdapter{

    private List<ContactPO> lists;
    private Context context;
    private HashMap<Integer,Boolean> checker;
    public MatchChooseContactAdapter(List<ContactPO> lists,Context context){
        this.lists=lists;
        this.context=context;
        checker=new HashMap<>();

    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public ContactPO getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lists.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
          //TODO 不能解决listview记录选择位置的缺点
        //即使数据量非常庞大也不会卡顿
        final ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.match_choose_contact_listview_cell,null);
            holder=new ViewHolder();

            holder.tv_name= (TextView) convertView.findViewById(R.id.matchdetal_view_cell_tv_name);
            holder.tv_name.setText(lists.get(position).getName());
            holder.imv_icon= (ImageView) convertView.findViewById(R.id.matchdetal_view_cell_iv);
            holder.cb_add= (TouchCheckBox) convertView.findViewById(R.id.matchdetail_view_cell_checkbox);
            //如果已经选中
//            System.out.println(getItem(position).getName()+" "+MatchDetailFragment.selectedList.contains(getItem(position)));
            if(MatchDetailFragment.selectedList.contains(getItem(position))){
                System.out.println(getItem(position).getName());
                holder.cb_add.setChecked(true);
            }else{
                holder.cb_add.setChecked(false);
            }
            holder.imv_icon.setImageDrawable(convertView.getResources().getDrawable(R.drawable.o));
//            if(lists.get(position).getImageurl()!=null){
//                try {
//                    FileInputStream fileInputStream=new FileInputStream(lists.get(position).getImageurl());
//                    Bitmap bitmap= BitmapFactory.decodeStream(fileInputStream);
//                    holder.imv_icon.setImageBitmap(bitmap);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
            convertView.setTag(holder);

        }else{
            holder= (ViewHolder) convertView.getTag();
            if(MatchDetailFragment.selectedList.contains(getItem(position))){
                holder.cb_add.setChecked(true);
            }else{
                holder.cb_add.setChecked(false);
            }
            holder.tv_name.setText(lists.get(position).getName());
        }

//        holder.cb_add.setOnCheckedChangeListener(new TouchCheckBox.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(View buttonView, boolean isChecked) {
//                if(isChecked){
//                    MatchDetailFragment.selectedList.add(getItem(position));
//                }else{
//                    MatchDetailFragment.selectedList.remove(getItem(position));
//                }
//                System.out.println(MatchDetailFragment.selectedList.size());
//            }
//        });

        holder.cb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cb_add.isChecked()){
                    holder.cb_add.setChecked(false);
                    MatchDetailFragment.selectedList.remove(getItem(position));
                }else{
                    holder.cb_add.setChecked(true);
                    MatchDetailFragment.selectedList.add(getItem(position));
                }
                System.out.println(MatchDetailFragment.selectedList.size());
            }
        });

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
        TouchCheckBox cb_add;
    }
}
