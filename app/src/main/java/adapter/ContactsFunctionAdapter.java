package adapter;

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
import java.util.List;

import turingmachine.com.sharetime20.R;

/**
 * Created by gaoyang on 15/4/1.
 */
public class ContactsFunctionAdapter extends BaseAdapter {
    private Context context;
    private List<String> functions;

    public ContactsFunctionAdapter(List<String> titles,Context context){
        this.context=context;
        this.functions=titles;
    }

    @Override
    public int getCount() {
        return functions.size();
    }

    @Override
    public Object getItem(int position) {
        return functions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.contacts_function_view_cell, null);
            holder = new ViewHolder();

            holder.tv_func_name = (TextView) convertView.findViewById(R.id.contacts_view_cell_tv_name);
            holder.tv_func_name.setText(functions.get(position));
            holder.imv_icon = (ImageView) convertView.findViewById(R.id.contacts_view_cell_imv_icon);
            holder.imv_icon.setImageDrawable(convertView.getResources().getDrawable(R.drawable.default_icon));

            convertView.setTag(holder);
        }
            return convertView;
    }

    private static class ViewHolder{
        ImageView imv_icon;
        TextView tv_func_name;
    }
}
