package turingmachine.com.sharetime20;

import android.content.Context;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

import turingmachine.com.sharetime20.subcontacts.AddContactActivity;
import turingmachine.com.sharetime20.subcontacts.PhoneContactsActivity;

//联系人列表加号弹出菜单
public class ContactsActionPlusProvider extends ActionProvider {
    private Context mContext;

    public ContactsActionPlusProvider(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public boolean hasSubMenu() {
        // 返回true说明有子menu，之后会到onPrepareSubMenu中查找
        return true;

    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        // 添加子menu
        subMenu.add("发起群聊")
                .setIcon(
                        mContext.getResources().getDrawable(
                                R.drawable.tab_contacts))
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
        subMenu.add("添加朋友")
                .setIcon(
                        mContext.getResources().getDrawable(
                                R.drawable.tab_match_pressed))
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent i =new Intent(mContext, AddContactActivity.class);
                        mContext.startActivity(i);
                        return true;
                    }
                });
        subMenu.add("朋友推介")
                .setIcon(
                        mContext.getResources().getDrawable(
                                R.drawable.tab_match_pressed))
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent i =new Intent(mContext,PhoneContactsActivity.class);
                        mContext.startActivity(i);
                        return true;
                    }
                });

        subMenu.add("个人设置")
                .setIcon(
                        mContext.getResources().getDrawable(
                                R.drawable.tab_setting))
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });

    }
}
