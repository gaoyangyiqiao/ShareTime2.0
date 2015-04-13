package matchBL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import turingmachine.com.sharetime20.R;

/**
 * Created by admin on 2015/3/15.
 */
public class MatchDetailActivity extends Activity {
    private ArrayList<TextView> listForTV;
    private ArrayList<Integer> listForStateForTV;
    private ImageButton imageButtonLeft;
    private ImageButton imageButtonRight;
    private ListView lvContacts;
    private TextView[] tlist;
    public void init(){
        this.tlist = new TextView[3];
        tlist[0] = (TextView)findViewById(R.id.tv_match_detail_day_1);
        tlist[1] = (TextView)findViewById(R.id.tv_match_detail_day_2);
        tlist[2] = (TextView)findViewById(R.id.tv_match_detail_day_3);
        lvContacts = (ListView)findViewById(R.id.lv_match_detail_friends);
        imageButtonLeft = (ImageButton)findViewById(R.id.ib_match_detail_1);
        imageButtonRight = (ImageButton)findViewById(R.id.ib_match_detail_2);
        listForTV = new ArrayList<TextView>();
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_11));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_12));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_13));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_14));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_15));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_16));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_17));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_18));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_21));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_22));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_23));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_24));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_25));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_26));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_27));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_28));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_31));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_32));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_33));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_34));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_35));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_36));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_37));
        listForTV.add((TextView)findViewById(R.id.tv_match_detail_38));
    }

    public void onCreate(Bundle savedInstanceState){

    }
}

