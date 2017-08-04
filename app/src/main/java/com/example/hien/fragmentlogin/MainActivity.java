package com.example.hien.fragmentlogin;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIds();
        initComponents();
        setEvents();
    }

    private void findViewByIds() {

    }

    private void initComponents() {
        FragmentManager manager = getSupportFragmentManager();

        FragmentRegister register = new FragmentRegister();

        FragmentTransaction tran = manager.beginTransaction();

        tran.setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right,
                R.anim.enter_right_to_left, R.anim.exit_right_to_left);

        tran.replace(R.id.frame_layout, register, register.getTag());

        tran.addToBackStack(register.getTag());

        tran.commit();
    }

    private void setEvents() {


    }


    @Override
    public void onClick(View view) {

    }
}
