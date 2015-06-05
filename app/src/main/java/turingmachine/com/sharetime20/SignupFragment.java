package turingmachine.com.sharetime20;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by hello on 2015/6/5.
 */
public class SignupFragment extends Fragment {
    private Button choosedate;
    private TextView choosetime1;
    private TextView choosetime2;
    private  TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
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
        choosetime1=(TextView)getActivity().findViewById(R.id.choosetime1);
        choosetime2=(TextView)getActivity().findViewById(R.id.choosetime2);
        timePickerDialog=new TimePickerDialog(getActivity(),null, hoursofday,minute, true);
        datePickerDialog=new DatePickerDialog(getActivity(),null,year,month,day);
        choosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        choosetime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
        choosetime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePickerDialog.show();

            }
        });
    }
}
