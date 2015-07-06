package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;
import java.util.List;

import po.ContactPO;
import tools.GetIconByLetter;
import tools.SortContactPO;
import turingmachine.com.sharetime20.R;

/**
 * Created by gaoyang on 15/4/1.
 */
public class ContactsListAdapter extends BaseAdapter implements SectionIndexer {
    private List<ContactPO> lists=new ArrayList<>();
    private Context context;

    public ContactsListAdapter(List<ContactPO> lists, Context context){

        lists.addAll(lists);

        this.context=context;

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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //即使数据量非常庞大也不会卡顿
        ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.contacts_view_cell,null);
            holder=new ViewHolder();

            holder.tv_catalog= (TextView) convertView.findViewById(R.id.contacts_view_cell_tv_catalog);
            holder.tv_name= (TextView) convertView.findViewById(R.id.contacts_view_cell_tv_name);
            holder.tv_name.setText(lists.get(position).getName());
            holder.imv_icon= (ImageView) convertView.findViewById(R.id.contacts_view_cell_imv_icon);
            holder.tv_isadded= (TextView) convertView.findViewById(R.id.contacts_view_cell_tv_isadded);
            //TODO 判断从哪个界面进入从而判断是否显示本textview
            holder.tv_isadded.setVisibility(View.INVISIBLE);
            //TODO 后期从服务器加载头像
//            if(!lists.get(position).getImageurl().contains("http"))
                holder.imv_icon.setImageDrawable(new GetIconByLetter().getIcon(convertView,new SortContactPO().getFirstLetter(holder.tv_name.getText().toString())));
//            if(lists.get(position).getImageurl().contains("http")){
//                try {
//                    //本地做法
////                    FileInputStream fileInputStream=new FileInputStream(lists.get(position).getImageurl());
////                    Bitmap bitmap= BitmapFactory.decodeStream(fileInputStream);
////                    holder.imv_icon.setImageBitmap(bitmap);
//                    //网络做法
//                    FinalBitmap finalBitMap=FinalBitmap.create(context);
//                    finalBitMap.display(holder.imv_icon, lists.get(position).getImageurl());
//                }catch (Exception e){
//                    holder.imv_icon.setImageDrawable(new GetIconByLetter().getIcon(convertView,new SortContactPO().getFirstLetter(holder.tv_name.getText().toString())));
//                    e.printStackTrace();
//                }
//            }

            convertView.setTag(holder);

        }else{
            holder= (ViewHolder) convertView.getTag();
            holder.tv_name.setText(lists.get(position).getName());
        }

        //根据position获取分类的首字母的char ascii值
        int section = getSectionForPosition(position);

        //如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if(position == getPositionForSection(section)){
            holder.tv_catalog.setVisibility(View.VISIBLE);
            holder.tv_catalog.setText(lists.get(position).getSortLetters());
        }else{
            holder.tv_catalog.setVisibility(View.GONE);
        }

        return convertView;
    }


    public void updateListView(List<ContactPO> list){
        this.lists.clear();
        this.lists.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(List<ContactPO> data){
        this.lists.addAll(data);
        notifyDataSetChanged();
    }

    public void clear(){
        lists.clear();
        notifyDataSetChanged();
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    //根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
    @Override
    public int getPositionForSection(int sectionIndex) {
        if(lists==null){
            return -1;
        }

        for (int i = 0; i < getCount(); i++) {
            if(lists.get(i)==null){
                return -1;
            }

            if(lists.get(i).getSortLetters()==null){
                return -1;
            }
            String sortStr = lists.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == sectionIndex) {
                return i;
            }
        }

        return -1;
    }
    //TODO 查找联系人是闪退
    //根据ListView的当前位置获取分类的首字母的char ascii值
    @Override
    public int getSectionForPosition(int position) {
        if(lists==null){
            return -1;
        }
        if(lists.get(position)==null){
            return -1;
        }
        if(lists.get(position).getSortLetters()!=null){
            return lists.get(position).getSortLetters().charAt(0);
        }else
            return -1;
    }

    public List<ContactPO> getLists() {
        return lists;
    }

    private static class ViewHolder{
        ImageView imv_icon;
        TextView tv_catalog;
        TextView tv_name;
        //是否已添加，已添加则显示
        TextView tv_isadded;
    }
}

