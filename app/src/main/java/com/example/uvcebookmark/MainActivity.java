package com.example.uvcebookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment l_fragment = new LoginFragment();
        RegisterFragment r_fragment=new RegisterFragment();
        fragmentTransaction.replace(R.id.frame,l_fragment).commit();//replace by rfragmnet here

    }
}
