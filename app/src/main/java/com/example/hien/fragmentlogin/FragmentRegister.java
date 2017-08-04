package com.example.hien.fragmentlogin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hien on 8/4/17.
 */

public class FragmentRegister extends Fragment implements View.OnClickListener {


    private EditText edtUser;
    private EditText edtPass;
    private EditText edtConfirm;
    private String mUser;
    private String mPass;
    private String mConfirm;

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
        View view = inflater.inflate(R.layout.fragment_register, container, false);

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


    }

    private void setEvents(View view) {
        view.findViewById(R.id.btn_introduction).setOnClickListener(this);
        view.findViewById(R.id.btn_register).setOnClickListener(this);

    }

    private void findViewByIds(View view) {

        edtUser = view.findViewById(R.id.edt_username);

        edtPass = view.findViewById(R.id.edt_password);

        edtConfirm = view.findViewById(R.id.edt_confirm_password);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View view) {

        mUser = edtUser.getText().toString();
        mPass = edtPass.getText().toString();
        mConfirm = edtConfirm.getText().toString();

        switch (view.getId()){

            case R.id.btn_register:

                if(mUser.equals("") || mPass.equals("") || mConfirm.equals("")){

                    showMsg("Ban can nhap du thong tin!!");

                    return;

                }

                if(!mPass.equals(mConfirm)){

                    showMsg("Co su sai lech ve mat khau yeu cau nhap lai!!");
                    return;
                }

                MainActivity main = (MainActivity) getActivity();

                FragmentManager manager = main.getSupportFragmentManager();

                FragmentTransaction tran = manager.beginTransaction();

                LoginFragment fragment = new LoginFragment();

                tran.addToBackStack(fragment.getTag());

                Bundle bundle = new Bundle();

                bundle.putString("user", mUser);

                bundle.putString("pass", mPass);

                tran.setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right,
                        R.anim.enter_right_to_left, R.anim.exit_right_to_left);

                fragment.setArguments(bundle);

                tran.replace(R.id.frame_layout, fragment, fragment.getTag());

                tran.commit();
                break;
            case R.id.btn_introduction:

                if(mUser.equals("") || mPass.equals("") || mConfirm.equals("")){
                    showMsg("Ban can nhap du thong tin!!");
                    return;
                }
                if(!mPass.equals(mConfirm)){
                    showMsg("Co su sai lech ve mat khau yeu cau nhap lai");
                    edtConfirm.setText("");
                    break;
                }

                main = (MainActivity) getActivity();
                manager = main.getSupportFragmentManager();
                tran = manager.beginTransaction();
                FragmentIntroduction intro = new FragmentIntroduction();

                bundle = new Bundle();

                bundle.putString("user", mUser);

                bundle.putString("pass", mPass);

                tran.setCustomAnimations(
                        R.anim.enter_right_to_left, R.anim.exit_right_to_left,
                        R.anim.enter_left_to_right, R.anim.exit_left_to_right);

                intro.setArguments(bundle);

                tran.addToBackStack(intro.getTag());

                tran.replace(R.id.frame_layout, intro, intro.getTag());

                tran.commit();


                break;
            default: break;
        }

    }

    private void showMsg(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
