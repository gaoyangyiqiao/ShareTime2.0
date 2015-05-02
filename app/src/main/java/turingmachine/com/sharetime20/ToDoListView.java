package turingmachine.com.sharetime20;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hello on 2015/5/2.
 */
public class ToDoListView extends ListView {
    private ArrayList<ActivityPre> list;
    private ArrayList<TextView> textViews;
    public void setActivity(ArrayList<ActivityPre> list){
        this.list=list;
    }
    public ToDoListView(Context context){
        super(context);
        initList();
    }
    public void initList(){
        int length=textViews.size();
        for(int i=0;i<length;i++){
            this.addView(textViews.get(i));
        }
    }
    public ToDoListView(Context context, AttributeSet set) {
        super(context, set);
    }
    public class addListener implements OnClickListener{
        public void onClick(View view){

        }

    }

}
