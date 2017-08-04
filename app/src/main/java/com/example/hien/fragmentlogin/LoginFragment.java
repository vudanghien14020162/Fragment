package com.example.hien.fragmentlogin;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hien on 8/4/17.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    private TextView tvUserName;
    private TextView tvPassWork;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewByIds(view);
        initComponents();
        setEvents(view);
    }

    private void initComponents() {
        Bundle bundle = getArguments();
        if(bundle != null){
            String user = bundle.getString("user");
            String pass = bundle.getString("pass");

            tvUserName.setText("User: " + user);
            tvPassWork.setText("Pass: " + pass);
        }




    }

    private void findViewByIds(View view) {
        tvUserName = view.findViewById(R.id.tv_user_login);
        tvPassWork = view.findViewById(R.id.tv_pass_login);
    }


    public void setEvents(View view) {
        view.findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Message");

        builder.setMessage("Dang nhap thanh cong!!!");

        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();


    }
}
