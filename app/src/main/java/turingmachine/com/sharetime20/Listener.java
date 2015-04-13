package turingmachine.com.sharetime20;

/**
 * Created by hello on 2015/4/13.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by hello on 2015/4/13.
 */
public class Listener  implements AdapterView.OnClickListener{
    private String type;
    private TextView[] list;
    public Listener(String type,TextView[] list){
        this.type=type;
        this.list=list;
    }
    public void onClick(View view) {

        switch(type){
            case "up":
                for(int i=0;i<list.length;i++){
                    dateMove(list[i],"up");
                }
                break;
            case "down":
                for(int i=0;i<list.length;i++){
                    dateMove(list[i],"down");
                }
                break;
        }

    }
    public void dateMove(TextView t,String type){
        String s=(String)t.getText();
        int i=0;
        switch(s){
            case "周一":i=1;break;
            case "周二":i=2;break;
            case "周三":i=3;break;
            case "周四":i=4;break;
            case "周五":i=5;break;
            case "周六":i=6;break;
            case "周日" :i=7;break;
        }
        switch(type){
            case "up":if(i==7){i=1;}
            else i=i+1;
                break;
            case "down":if(i==1){i=7;}
            else i=i-1;
                break;
        }
        switch(i){
            case 1:t.setText("周一");break;

            case 2:t.setText("周二");break;
            case 3:t.setText("周三");break;
            case 4:t.setText("周四");break;
            case 5:t.setText("周五");break;
            case 6:t.setText("周六");break;
            case 7:t.setText("周日");break;

        }

    }


}
