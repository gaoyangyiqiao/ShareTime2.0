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

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fileOperator.FileConfig;
import fileOperator.MatchRecordListFileOperator;
import netconnection.Config;
import netconnection.Match;
import po.ContactPO;
import po.MatchRecordListPO;
import po.MatchRecordPO;
import turingmachine.com.sharetime20.ContactsFragment;
import turingmachine.com.sharetime20.R;
import turingmachine.com.sharetime20.ScheduleFragment;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapButton;
import turingmachine.com.sharetime20.androidbootstrap.BootstrapEditText;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;


public class MatchDetailFragment extends Fragment {
    //MySearchVIew
    private EditText mEtSearch = null;
    private Button mBtnClearSearchText = null;
    private LinearLayout mLayoutClearSearchText = null;
    private ListView lv_contacts;
    private MatchChooseContactAdapter matchChooseContactAdapter;
    private List<ContactPO> list;
    private BootstrapEditText et_title;
    public static List<ContactPO> selectedList=new ArrayList<>();
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    private DatePickerDialog datePickerDialog2;
    private BootstrapButton chooseEndDate;
    private BootstrapButton chooseBeginDate;
    int kk=0;
    private Date starttime;
    private Date endtime;
    private ArrayList<WeekViewEvent> li;
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

        et_title= (BootstrapEditText) getActivity().findViewById(R.id.et_title_in_matchdetail);
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
                chooseBeginDate.setText((year)+ "/"+(monthOfYear+1)+"/"+ dayOfMonth);
//                System.out.println("begin time :"+"开始时间："+(year)+ "/"+(monthOfYear+1)+"/"+ dayOfMonth);


              starttime=new java.util.Date(year - 1900, monthOfYear, dayOfMonth);
//               System.out.println(starttime.toString());
            }
        },year,month,day);
        datePickerDialog2=new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    chooseEndDate.setText((year) + "/" + (monthOfYear + 1) + "/" + dayOfMonth);

//                    System.out.println("结束时间：" + (year) + "/" + (monthOfYear + 1) + "/" + dayOfMonth);


                endtime=new java.util.Date(year - 1900, monthOfYear, dayOfMonth);
//                System.out.println(endtime.toString());
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

                datePickerDialog2.show();

            }
        });


    }

    public void setContent(ScheduleFragment scheduleFragment){
        getSchedule(scheduleFragment);
    }
    public void getSchedule(ScheduleFragment scheduleFragment){
        String user_id_array="";
        for (int i=0;i<selectedList.size();i++){
            user_id_array+=selectedList.get(i).getId();
            user_id_array+=",";
        }
        endtime.setHours(23);
        endtime.setMinutes(59);
        endtime.setSeconds(59);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Match match=new Match(Config.getCachedId(getActivity()),user_id_array,simpleDateFormat.format(starttime),simpleDateFormat.format(endtime),scheduleFragment);
//        MatchRecordListPO matchRecordListPO=new MatchRecordListPO();
//        MatchRecordListFileOperator  matchRecordListFileOperator=new MatchRecordListFileOperator();
//        matchRecordListPO=matchRecordListFileOperator.getObject(FileConfig.MATCHRECORD_FILENAME);
//        MatchRecordPO matchRecordPO=new MatchRecordPO(Config.getCachedId(getActivity()),user_id_array,simpleDateFormat.format(starttime),simpleDateFormat.format(endtime),et_title.getText().toString());
//        matchRecordListPO.getMatchRecords().add(matchRecordPO);
//        matchRecordListFileOperator.saveObject(matchRecordListPO,FileConfig.MATCHRECORD_FILENAME);

        System.out.println("match : "+Config.getCachedId(getActivity())+"#"+user_id_array+"#"+simpleDateFormat.format(starttime)+"#"+simpleDateFormat.format(endtime));
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
