package matchBL;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/3/15.
 */
public class CheckedContactAdapter extends BaseAdapter {
    private Context ct;
    private ListView lvContact;
    private ArrayList<HashMap<String, Object>> data;
    public Map<Integer, Boolean> checkedMap;

    public ArrayList<HashMap<String, Object>> getData() {
        return data;
    }
    private Drawable getImage(String touxiang) {
        return ct.getResources().getDrawable(R.drawable.ic_launcher);
    }
    public static ArrayList<HashMap<String, Object>> queryContact(Context ct,
                                                                  String where, String[] args, String orderColumn) {
        ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", i + 1);
            map.put("name", "name" + i);
            map.put("touxiang", (i % 10));
            data.add(map);
        }
        return data;
    }

    private void setData() {
        data = queryContact(ct, null, null, null);
        for (HashMap<String, Object> m : data) {
            checkedMap.put(Integer.parseInt(m.get("id") + ""), false);
        }
    }

    public CheckedContactAdapter(Context ct) {
        this.ct = ct;
        checkedMap = new HashMap<Integer, Boolean>();

        setData();
    }

    public Map<Integer, Boolean> getCheckedMap() {
        return checkedMap;
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
        HashMap<String, Object> map = data.get(position);
        final String name = map.get("name") + "";
        final String touxiang = map.get("touxiang") + "";
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(ct).inflate(
                    R.layout.choose_contact_view_cell, null);

            viewHolder = new ViewHolder();
            viewHolder.checkBox = (CheckBox) convertView
                    .findViewById(R.id.choose_contact_view_cell_cb);
            // 分割栏
            viewHolder.name = (TextView) convertView
                    .findViewById(R.id.choose_contact_view_cell_tv_name);
            viewHolder.touxiang = (ImageView) convertView
                    .findViewById(R.id.choose_contact_view_cell_iv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.checkBox.setChecked(checkedMap.get(Integer.parseInt(""
                + map.get("id"))));
        viewHolder.touxiang.setImageDrawable(getImage(touxiang));
        viewHolder.name.setText(name);
        return convertView;
    }

    static class ViewHolder {
        CheckBox checkBox;
        ImageView touxiang;
        TextView name;

    }
}
