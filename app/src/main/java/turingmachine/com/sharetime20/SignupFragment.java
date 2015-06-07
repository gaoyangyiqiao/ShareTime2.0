package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import netconnection.AddActivity;
import netconnection.Config;
import turingmachine.com.sharetime20.weekview.WeekViewEvent;

/**
 * Created by hello on 2015/6/5.
 */
public class SignupFragment extends Fragment {
    private Button choosedate;
    private Button choosetime1;
    private Button choosetime2;
    private  TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    private EditText editText;
    private Date cdate;
    private Time time1;
    private Time time2;
    private Date starttime;
    private Date endtime;
    int index=1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingFragment = inflater.inflate(R.layout.activity_signup,container,false);
        return settingFragment;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {

        int hoursofday=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute=Calendar.getInstance().get(Calendar.MINUTE);
        int year=Calendar.getInstance().get(Calendar.YEAR);
        int month=Calendar.getInstance().get(Calendar.MONTH);
        int day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        choosedate=(Button)getActivity().findViewById(R.id.choosedate);
        choosetime1=(Button)getActivity().findViewById(R.id.choosetime11);
        choosetime2=(Button)getActivity().findViewById(R.id.choosetime22);
        timePickerDialog=new TimePickerDialog(getActivity(),new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(index==1) {
                    if(starttime!=null) {
                        starttime.setHours(hourOfDay);
                        starttime.setMinutes(minute);
                    }
                 choosetime1.setText(hourOfDay+":"+minute);
                }
                else{
                    if(endtime!=null) {
                        endtime.setHours(hourOfDay);
                        endtime.setMinutes(minute);
                    }
                        choosetime2.setText(hourOfDay + ":" + minute);

                }
            }
        }, hoursofday,minute, true);
        datePickerDialog=new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                choosedate.setText("日期："+(year)+ "/"+(monthOfYear+1)+"/"+ dayOfMonth);
                cdate=new Date(year - 1900, monthOfYear, dayOfMonth);
                starttime=new Date(year - 1900, monthOfYear, dayOfMonth);
                endtime=new Date(year - 1900, monthOfYear, dayOfMonth);
            }
        },year,month,day);
        editText=(EditText)getActivity().findViewById(R.id.activity_get);
        final Button button=(Button)getActivity().findViewById(R.id.confirm);
        choosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });

        choosetime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=1;
                timePickerDialog.show();

            }
        });
        choosetime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=2;
                timePickerDialog.show();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content="";
                content=editText.getText().toString();
                if(starttime!=null&&endtime!=null) {
                    AddActivity addActivity = new AddActivity(Config.getCachedId(getActivity()), content, content, starttime.toString(), endtime.toString(), 0);
                    LayoutInflater li = LayoutInflater.from(getActivity());
                    View view = li.inflate(R.layout.activity_add_event, null);
                    new AlertDialog.Builder(getActivity()).setPositiveButton("确定", null)
                            .setTitle("新建事件完成").show();
                    Calendar c1=Calendar.getInstance();
                    Calendar c2=Calendar.getInstance();
                    c1.setTime(starttime);
                    c2.setTime(endtime);
                   Button b=(Button)getActivity().findViewById(R.id.jump);
                    b.setTag(new WeekViewEvent(0,content,c1,c2));


                }
                else{
                    LayoutInflater li = LayoutInflater.from(getActivity());
                    View view = li.inflate(R.layout.activity_add_event, null);
                    new AlertDialog.Builder(getActivity()).setPositiveButton("确定", null)
                            .setTitle("新建事件未完成").show();
                }



            }
        });

    }
}
