package turingmachine.com.sharetime20;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import messageBL.AllMessageFragment;
import messageBL.FriendInvitationFragment;
import messageBL.SystemRecommendFragment;

/**
 * Created by admin on 2015/3/28.
 */
public class MessageFragment extends Fragment {

    private AllMessageFragment alllMessageFragment;
    private FriendInvitationFragment friendInvitationFragment;
    private SystemRecommendFragment systemRecommendFragment;
    private View allLayout;
    private View friendLayout;
    private View systemLayout;
    private FragmentManager fragmentManager;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    private void initViews(){

    }

    public void onClick(View v){

    }

    private void setTabSelection(int index){

    }

    private void clearSelection(){

    }

    private void hideFragments(FragmentTransaction fragmentTransaction){

    }
}
