package com.example.uvcebookmark;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class login_fragment extends Fragment {
   private  TextView registerTextView, passwordTextView;
   private Button loginButton;
   private EditText registerNoEditText, passwordEditText;
 //  CollectionReference refer = database.collection("users");





    public login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragment, container, false);
        registerTextView = view.findViewById(R.id.new_user_TV);
        passwordTextView = view.findViewById(R.id.forgot_password_TV);
        loginButton = view.findViewById(R.id.login_button);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerTextView.setTextColor(getResources().getColor(R.color.Purple));
                // To register_fragment
            }
        });
        passwordTextView = view.findViewById(R.id.forgot_password_TV);
        passwordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordTextView.setTextColor(getResources().getColor(R.color.Purple));
                // To somewhere else
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment registerFragment = new register_fragment();

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,registerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        loginButton = view.findViewById(R.id.login_button);
        registerNoEditText = view.findViewById(R.id.reg_ET);
        passwordEditText = view.findViewById(R.id.password_ET);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(registerNoEditText.getText().toString().trim().equals("") || passwordEditText.getText().toString().trim().equals(""))
                    Toast.makeText(getContext(),"Enter register number and password",Toast.LENGTH_SHORT).show();
                else{


                }


            }
        });

        return view;


    }


    @Override
    public void onResume() {
        super.onResume();
        registerTextView.setTextColor(getResources().getColor(R.color.White));
        passwordTextView.setTextColor(getResources().getColor(R.color.White));

    }
}
