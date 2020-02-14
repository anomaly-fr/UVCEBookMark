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
        login_fragment l_fragment = new login_fragment();
        register_fragment r_fragment=new register_fragment();
        fragmentTransaction.replace(R.id.frame,l_fragment).commit();//replace by rfragmnet here

    }
}
