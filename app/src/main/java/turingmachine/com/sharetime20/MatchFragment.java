package turingmachine.com.sharetime20;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.MatchListItemAdapter;
import fileOperator.FileConfig;
import fileOperator.MatchRecordListFileOperator;
import matchBL.GetMatchInfoList;
import matchBL.MatchBL;
import po.MatchRecordListPO;
import turingmachine.com.sharetime20.customswipelistview.CustomSwipeListView;
import turingmachine.com.sharetime20.customswipelistview.CustomSwipeUndoDialog;
import turingmachine.com.sharetime20.match_activity.MatchChooseContactsActivity;
import turingmachine.com.sharetime20.match_activity.MatchDetailActivity;
import po.MatchInfoPO;
import turingmachine.com.sharetime20.match_activity.SampleAdapter;
import turingmachine.com.sharetime20.match_activity.SampleModel;

/**
 * Created by admin on 2015/3/28.
 */
public class MatchFragment extends Fragment implements CustomSwipeListView.RemoveItemCustomSwipeListener{
    //TODO 左滑动更新匹配信息，删减成员，更改时间
    private CustomSwipeListView mSampleListView;
    private SampleAdapter mSampleAdapter;
    private List<SampleModel> mSampleModels = new ArrayList<SampleModel>();
    private CustomSwipeUndoDialog mUndoDialog;
    private MatchRecordListFileOperator matchRecordListFileOperator;
    private MatchRecordListPO matchRecordListPO;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        matchRecordListPO=new MatchRecordListPO();
        matchRecordListFileOperator=new MatchRecordListFileOperator();
        View matchFragment = inflater.inflate(R.layout.activity_match,container,false);
        return matchFragment;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        makeData();

        mSampleListView = (CustomSwipeListView) getActivity().findViewById(R.id.lv_match_record);

        // Use the constructor to initialize the SampleAdapter.
        mSampleAdapter = new SampleAdapter(getActivity(), mSampleModels);
        // create a undoDialog and set listener to it.
        mUndoDialog = new CustomSwipeUndoDialog(getActivity());
        mUndoDialog.setUndoActionListener(mSampleAdapter);

        mSampleListView.setAdapter(mSampleAdapter);
        // set itemClickListener to the CustomSwipeListView.
        mSampleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(
                        getActivity(),
                        "Click item-" + mSampleModels.get(position).getTestDate(),
                        Toast.LENGTH_SHORT).show();
            }

        });

        // set removeItemListener to the CustomSwipeListView.
        mSampleListView.setRemoveItemCustomSwipeListener(this);

        // set some property for the CustomSwipeListView.
        mSampleListView.setSwipeItemLeftEnable(true);
        mSampleListView.setSwipeItemRightEnable(true);
        mSampleListView.setAnimationLeftDuration(300);
        mSampleListView.setAnimationRightDuration(300);
        // mSampleListView.setSwipeItemLeftTriggerDeltaX(50);
        // mSampleListView.setSwipeItemRightTriggerDeltaX(50);
    }

    /**
     * Generate some data that is shown in the CustomSwipeListview.
     */
    private void makeData() {
//        System.out.println("---->>>mackdate");
        SampleModel model = new SampleModel();
        matchRecordListPO=matchRecordListFileOperator.getObject(FileConfig.MATCHRECORD_FILENAME);
            for (int i=0;i<matchRecordListPO.getMatchRecords().size();i++){
                model.setTestDate(matchRecordListPO.getMatchRecords().get(i).getBegin_time());
                model.setTestTitle(matchRecordListPO.getMatchRecords().get(i).getTitle());
            }
            mSampleModels.add(model);

    }

    @Override
    public void onRemoveItemListener(int selectedPostion) {
        // get the object which has been deleted.
        SampleModel model = mSampleAdapter.removeItemByPosition(selectedPostion);
        // set some message and show the undoDialog
        mUndoDialog.setMessage("Delete" + model.getTestTitle() + ".")
                .showUndoDialog();
    }
}
