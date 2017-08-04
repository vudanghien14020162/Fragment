package com.example.hien.fragmentlogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hien on 8/4/17.
 */

public class FragmentIntroduction extends Fragment {

    private TextView tvUser;
    private TextView tvPassWord;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_introduction, container, false);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        findViewByIds(view);
        initComponents();
    }

    private void initComponents() {

        Bundle bundle = getArguments();

        if(bundle != null){

            String user = bundle.getString("user");
            String pass = bundle.getString("pass");
            tvUser.setText("UserName: " + user);
            tvPassWord.setText("Pass: " + pass);
        }
    }

    private void findViewByIds(View view) {
        tvUser = view.findViewById(R.id.tv_info_user);
        tvPassWord = view.findViewById(R.id.tv_info_pass);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
