package turingmachine.com.sharetime20.subcontacts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import businesslogic.contactbl.PhoneContactsController;
import po.ContactPO;
import tools.CharacterParser;
import tools.PinyinComparator;
import turingmachine.com.sharetime20.R;

//在推介联系人中推介电话簿中的联系人
public class PhoneContactsActivity extends Activity {

    private ListView lv_contacts;
    private SearchView sv_phonecontacts;
    private PhoneContactsAdapter adapter;
    private List<ContactPO> list;

    private CharacterParser characterParser;

    private PhoneContactsController phoneContactsController;

    private PinyinComparator pinyinComparator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_contacts);

        phoneContactsController=new PhoneContactsController();
        //实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();
        list=filledData(phoneContactsController.getContacts(this));
        lv_contacts= (ListView) findViewById(R.id.lv_phone_contact);

        // 根据a-z进行排序源数据
        Collections.sort(list, pinyinComparator);
        adapter = new PhoneContactsAdapter(list,this);
        lv_contacts.setAdapter(adapter);

        sv_phonecontacts= (SearchView) findViewById(R.id.sv_phone_contact_search);
        sv_phonecontacts.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if(newText!=null){
                        adapter.updateListView(searchItem(newText));
                }
                return true;
            }

        });

    }

    //为ListView填充数据
    private List<ContactPO> filledData(List<ContactPO> list){
        List<ContactPO> mSortList = new ArrayList<ContactPO>();

        for(int i=0; i<list.size(); i++){
            ContactPO sortModel = new ContactPO(list.get(i).getName());
            sortModel.setPhone(list.get(i).getPhone());
            //汉字转换成拼音
            String pinyin = characterParser.getSelling(list.get(i).getName());
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if(sortString.matches("[A-Z]")){
                sortModel.setSortLetters(sortString.toUpperCase());
            }else{
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    public List<ContactPO> searchItem(String name) {
        ArrayList<ContactPO> mSearchList = new ArrayList<ContactPO>();
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i).getName().indexOf(name);
            // 存在匹配的数据
            if (index != -1) {
                mSearchList.add(list.get(i));
            }
        }
        return mSearchList;
    }



    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加本地搜索功能
        getMenuInflater().inflate(R.menu.menu_phone_contacts,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
               default:
                   finish();
                   break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void searchViewBussinesslogic(){
        if(sv_phonecontacts.isFocused()){

        }
    }


}
