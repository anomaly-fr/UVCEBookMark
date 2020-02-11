package com.example.uvcebookmark;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class login_fragment extends Fragment {



    public login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragment, container, false);
        final TextView registerTextView = view.findViewById(R.id.new_user_TV);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerTextView.setTextColor(getResources().getColor(R.color.Purple));
                // To register_fragment
            }
        });
        final TextView passwordTextView = view.findViewById(R.id.forgot_password_TV);
        passwordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordTextView.setTextColor(getResources().getColor(R.color.Purple));
                // To somewhere else
            }
        });
        final Button loginButton = view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;


    }

}
