package matchBL;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/3/13.
 */
public class MatchChooseContactsActivity extends Activity implements AdapterView.OnItemClickListener{
    private ListView lvContact;
    private HorizontalListView checkedContact;
    private CheckedContactAdapter adapter;
    private CheckedIconAdapter checkedAdapter;
    private Button ensureButton;
    private ArrayList<CheckedImg> checkedList;

    private void initCheckedList(){
        CheckedImg img = new CheckedImg();
        img.setId("default");
        img.setName("default");
        img.setImg("none");
        checkedList.add(img);
    }

    //移除水平图片
    private void removeByName(String name){
        checkedList.remove(findCheckedPositionByName(name));
        if (checkedList.size() == 4) {
            if (findCheckedPositionByName("default") == -1) {
                initCheckedList();
            }
        }
        ensureButton.setText("确定(" + --countChecked + ")");
    }


    //选择checkbox，添加水平图片
    private void addToCheckedList(String name,String id,String icon){
        CheckedImg img = new CheckedImg();
        img.setName(name);
        img.setId(id);
        img.setImg(icon);
        if(checkedList.size()<maxCount){
            checkedList.add(checkedList.size()-1,img);
        }
        else{
            checkedList.add(img);
        }
        if (checkedList.size() == maxCount+1){
            if(findCheckedPositionByName("default")!=-1){
                checkedList.remove(findCheckedPositionByName("default"));
            }
        }
        else if (checkedList.size() == maxCount - 1){
            if(findCheckedPositionByName("default") == -1){
                initCheckedList();
            }
        }
        ensureButton.setText("确定("+countChecked+")");
    }

    private boolean hasMeasured = false;
    private int maxCount = 5;//这里要是可以根据屏幕计算出最多容纳多少item就好了，没有找到合适的方法
    private int countChecked = 0;//得到选中的数量

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_select_contact);
        lvContact = (ListView)findViewById(R.id.lv_select_search_contact);
        adapter = new CheckedContactAdapter(matchBL.MatchChooseContactsActivity.this);
        lvContact.setAdapter(adapter);
        lvContact.setOnItemClickListener(this);

        checkedContact = (HorizontalListView)findViewById(R.id.imgList);
        checkedList = new ArrayList<CheckedImg>();
        initCheckedList();
        checkedAdapter = new CheckedIconAdapter(MatchChooseContactsActivity.this,checkedList);
        checkedContact.setAdapter(checkedAdapter);
        checkedContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {//添加项目单击事件，待完善
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedImg img = checkedList.get(position);
                Map<Integer,Boolean> checkedMap = adapter.getCheckedMap();
                if(!img.getId().equals("default")){
                    checkedMap.put(Integer.parseInt(img.getId()),false);
                    adapter.notifyDataSetChanged();
                    removeByName(img.getName());
                }
                checkedAdapter.notifyDataSetChanged();
            }
        });
        ensureButton = (Button)findViewById(R.id.makesureBtn);
    }

    //根据item查询对应的索引
    private int findCheckedPositionByName(String name){
        int i = -1;
        for (CheckedImg m : checkedList) {
            i++;
            if (name.equals(m.getName())) {
                return i;
            }
        }
        return -1;
    }

    public void onItemClick(AdapterView<?> parent,View view,int position,long id){
        ArrayList<HashMap<String,Object>> list = adapter.getData();
        Map<Integer,Boolean> checkedMap = adapter.getCheckedMap();
        HashMap<String, Object> map = list.get(position);
        RelativeLayout layout = (RelativeLayout) view;
        LinearLayout layout2 = (LinearLayout) layout.getChildAt(1);
        String _id = "" + map.get("id");
        String name = "" + map.get("name");
        String icon = "" + map.get("icon");

        CheckBox ckb = (CheckBox)layout2.getChildAt(0);
        if (ckb.isChecked()) {
            checkedMap.put(Integer.parseInt(_id), false);
            removeByName(name);
            checkedAdapter.notifyDataSetChanged();
        } else {
            checkedContact.setSelection(adapter.getCount()-1);
            checkedMap.put(Integer.parseInt(_id), true);
            addToCheckedList(name, _id, icon);
            checkedAdapter.notifyDataSetChanged();
            checkedContact.setSelection(checkedAdapter.getCount()-1);
        }
        adapter.notifyDataSetChanged();
    }
}
