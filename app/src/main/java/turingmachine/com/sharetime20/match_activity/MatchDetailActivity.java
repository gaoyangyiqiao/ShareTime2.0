package turingmachine.com.sharetime20.match_activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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

    }

    public void onCreate(Bundle savedInstanceState){

    }
}

