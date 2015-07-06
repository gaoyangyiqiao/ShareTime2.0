package turingmachine.com.sharetime20.subcontacts;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import netconnection.AddContact;
import netconnection.Config;
import po.ContactPO;
import tools.GetIconByLetter;
import tools.SortContactPO;
import turingmachine.com.sharetime20.ContactsFragment;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapButton;


public class ContactInfoFragment extends Fragment {

    public static final int IS_FROM_PHONE=1;
    public static final int NOT_FROM_PHONE=0;

    private BootstrapButton schedule;
    private ImageView icon;
    private TextView tv_name;
    private TextView tv_account;
    private ContactInfoFragment contactInfoFragment;
    //如果存在该联系人则不显示
    public BootstrapButton btn_add_friend;
    private BootstrapButton btn_match;

    public ContactsFragment contactsFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    public void initViews(){
        final int id=getActivity().getIntent().getIntExtra("id",0);
        String name=getActivity().getIntent().getStringExtra("name");
        String img=getActivity().getIntent().getStringExtra("img");
        int isFromPhone=getActivity().getIntent().getIntExtra("isFromPhone",NOT_FROM_PHONE);

        btn_match= (BootstrapButton) getActivity().findViewById(R.id.btn_match_in_contactinfo);
        tv_name= (TextView) getActivity().findViewById(R.id.tv_name_in_contactinfo);
        tv_account= (TextView) getActivity().findViewById(R.id.tv_account_in_contactinfo);
        schedule= (BootstrapButton) getActivity().findViewById(R.id.btn_schedule_in_contactinfo);
        icon= (ImageView) getActivity().findViewById(R.id.iv_icon_in_contactinfo);
        icon.setImageDrawable(new GetIconByLetter().getIcon(getActivity(),new SortContactPO().getFirstLetter(name)));

        btn_add_friend= (BootstrapButton) getActivity().findViewById(R.id.btn_add_friend_in_contactinfo);
        if(ContactsFragment.id_list.size()>0&&ContactsFragment.id_list.contains(id)){
            btn_add_friend.setVisibility(View.INVISIBLE);
        }else{
            btn_add_friend.setVisibility(View.VISIBLE);
            btn_add_friend.setOnClickListener(new View.OnClickListener() {
                //TODO 添加好友事件
                @Override
                public void onClick(View v) {
                      btn_add_friend.setBootstrapButtonEnabled(false);
                      new AddContact(Config.getCachedId(getActivity()),id+"",contactInfoFragment);
                }
            });
        }
        //TODO 未处理头像
        tv_account.setText(id+"");
        tv_name.setText(name);

        contactInfoFragment=this;
    }
}
