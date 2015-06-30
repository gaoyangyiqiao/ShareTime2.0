package turingmachine.com.sharetime20.match_activity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import po.ContactPO;
import turingmachine.com.sharetime20.ContactsFragment;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapButton;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapEditText;


public class MatchDetailFragment extends Fragment {
    //MySearchVIew
    private EditText mEtSearch = null;
    private Button mBtnClearSearchText = null;
    private LinearLayout mLayoutClearSearchText = null;
    private ListView lv_contacts;
    private MatchChooseContactAdapter matchChooseContactAdapter;
    private List<ContactPO> list;
    public static List<ContactPO> selectedList=new ArrayList<>();
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    private BootstrapButton chooseEndDate;
    private BootstrapButton chooseBeginDate;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        selectedList.clear();
        return inflater.inflate(R.layout.fragment_match_detail, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        lv_contacts.setAdapter(matchChooseContactAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        selectedList.clear();
    }

    public void initViews(){

        //TODO 此处如果没有打开过联系人界面可能还不存在联系人
        list=new ArrayList<>();
        list.addAll(ContactsFragment.contacts);

        matchChooseContactAdapter=new MatchChooseContactAdapter(list,getActivity());
        lv_contacts= (ListView) getActivity().findViewById(R.id.lv_contacts_in_matchdetailfragment);
        mEtSearch = (EditText) getActivity().findViewById(R.id.et_search);
        mBtnClearSearchText = (Button) getActivity().findViewById(R.id.btn_clear_search_text);
        mLayoutClearSearchText = (LinearLayout) getActivity().findViewById(R.id.layout_clear_search_text);
        mEtSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int textLength = mEtSearch.getText().length();
                if (textLength > 0) {
                    matchChooseContactAdapter.updateListView(searchItem(mEtSearch.getText().toString()));
                    mLayoutClearSearchText.setVisibility(View.VISIBLE);
                } else {
                    matchChooseContactAdapter.updateListView(list);
                    mLayoutClearSearchText.setVisibility(View.GONE);
                }
            }
        });

        mBtnClearSearchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtSearch.setText("");
                mLayoutClearSearchText.setVisibility(View.GONE);
            }
        });
        mEtSearch.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(getActivity(),
                            mEtSearch.getText().toString().trim(),
                            Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        int hoursofday= Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute=Calendar.getInstance().get(Calendar.MINUTE);
        int year=Calendar.getInstance().get(Calendar.YEAR);
        int month=Calendar.getInstance().get(Calendar.MONTH);
        int day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        chooseBeginDate=(BootstrapButton)getActivity().findViewById(R.id.btn_begintime_in_matchdetail);
        chooseEndDate=(BootstrapButton)getActivity().findViewById(R.id.btn_endtime_in_matchdetail);

        datePickerDialog=new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                chooseBeginDate.setText("开始时间："+(year)+ "/"+(monthOfYear+1)+"/"+ dayOfMonth);
//                cdate=new java.util.Date(year - 1900, monthOfYear, dayOfMonth);
//                starttime=new java.util.Date(year - 1900, monthOfYear, dayOfMonth);
//                endtime=new java.util.Date(year - 1900, monthOfYear, dayOfMonth);
            }
        },year,month,day);

        final BootstrapButton button=(BootstrapButton)getActivity().findViewById(R.id.confirm);
        chooseBeginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });
        chooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });


    }
    //搜索
    public List<ContactPO> searchItem(String name) {
        ArrayList<ContactPO> mSearchList = new ArrayList<>();
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
    public void onDestroyView() {
        super.onDestroyView();
        selectedList.clear();
    }
}
