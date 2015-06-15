package turingmachine.com.sharetime20.match_activity;


import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import po.ContactPO;
import turingmachine.com.sharetime20.R;


public class MatchDetailFragment extends Fragment {
    //MySearchVIew
    private EditText mEtSearch = null;
    private Button mBtnClearSearchText = null;
    private LinearLayout mLayoutClearSearchText = null;
    private ListView lv_contacts;
    private MatchChooseContactAdapter matchChooseContactAdapter;
    private List<ContactPO> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_match_detail, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        lv_contacts.setAdapter(matchChooseContactAdapter);
    }

    public void initViews(){
        list=new ArrayList<ContactPO>();

        ContactPO test=new ContactPO("Han");
        test.setId(1);
        test.setPhone("123456");
        list.add(test);

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
                    mLayoutClearSearchText.setVisibility(View.VISIBLE);
                } else {
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
    }
}