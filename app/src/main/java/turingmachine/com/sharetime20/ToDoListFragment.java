package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.ApplicationInfo;

import java.util.List;

import turingmachine.com.sharetime20.swipeview.SwipeMenu;
import turingmachine.com.sharetime20.swipeview.SwipeMenuCreator;
import turingmachine.com.sharetime20.swipeview.SwipeMenuItem;
import turingmachine.com.sharetime20.swipeview.SwipeMenuListView;
import turingmachine.com.sharetime20.swipeview.SwipeMenuListView.OnMenuItemClickListener;


/**
 * Created by hello on 2015/5/31.
 */
public class ToDoListFragment extends Fragment{
    private List<ApplicationInfo> mAppList;
    private AppAdapter mAdapter;
    private Context context;
    SwipeMenuListView listView;
    private Button button;
    private SwipeMenuListView swipeMenuListView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View matchFragment = inflater.inflate(R.layout.activity_todolist,container,false);




    mAppList = getActivity().getPackageManager().getInstalledApplications(0);

   listView= (SwipeMenuListView) getActivity().findViewById(R.id.listView);
    mAdapter = new AppAdapter();

        return matchFragment;
    }
    public void newEvent(){

        LayoutInflater li = LayoutInflater.from(this.getActivity());
        View view = li.inflate(R.layout.activity_add_event, null);
        new AlertDialog.Builder(this.getActivity()).setView(
                view).setPositiveButton("确定", null)
                .setNegativeButton("取消", null).show();
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView = (SwipeMenuListView) getActivity().findViewById(R.id.listView);
        listView.setAdapter(mAdapter);
       // newEvent();

        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // Create different menus depending on the view type
                switch (menu.getViewType()) {
                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu2(menu);
                        break;
                    case 2:
                        createMenu3(menu);
                        break;
                }
            }

            private void createMenu1(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(
                        getActivity().getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0x18,
                        0x5E)));
                item1.setWidth(dp2px(90));
                item1.setIcon(R.drawable.ic_action_favorite);
                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(
                        getActivity().getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                item2.setWidth(dp2px(90));
                item2.setIcon(R.drawable.ic_action_good);
                menu.addMenuItem(item2);
            }
            public int dp2px( float dp) {
                final float scale = getActivity().getResources().getDisplayMetrics().density;
                return (int) (dp * scale + 0.5f);
            }

            private void createMenu2(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(
                        getActivity().getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0xE0,
                        0x3F)));
                item1.setWidth(dp2px(90));
                item1.setIcon(R.drawable.ic_action_important);
                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(
                        getActivity().getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                item2.setWidth(dp2px(90));
                item2.setIcon(R.drawable.ic_action_discard);
                menu.addMenuItem(item2);
            }

            private void createMenu3(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(
                        getActivity().getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0x30, 0xB1,
                        0xF5)));
                item1.setWidth(dp2px(90));
                item1.setIcon(R.drawable.ic_action_about);
                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(
                        getActivity().getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                item2.setWidth(dp2px(90));
                item2.setIcon(R.drawable.ic_action_share);
                menu.addMenuItem(item2);
            }
        };
        // set creator
        listView.setMenuCreator(creator);

        // step 2. listener item click event
        listView.setOnMenuItemClickListener(new OnMenuItemClickListener() {

            public boolean onMenuItemClick(int position, SwipeMenu  menu, int index){

                ApplicationInfo item = mAppList.get(position);
                switch (index) {
                    case 0:
                        // open
                        break;
                    case 1:
                        // delete
//					delete(item);
                        mAppList.remove(position);
                        mAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
    }
class AppAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return mAppList.size();
    }

    @Override
    public ApplicationInfo getItem(int position) {
        return mAppList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        // menu type count
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        // current menu type
        return position % 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getActivity().getApplicationContext(),
                    R.layout.item_list_app, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        ApplicationInfo item = getItem(position);
        holder.iv_icon.setImageDrawable(item.loadIcon(getActivity().getPackageManager()));
        holder.tv_name.setText(item.loadLabel(getActivity().getPackageManager()));
        return convertView;
    }

    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;

        public ViewHolder(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(this);
        }
    }
}

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}


