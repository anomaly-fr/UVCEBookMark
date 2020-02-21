package com.example.uvcebookmark;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
   private  TextView registerTextView, passwordTextView;
   private Button loginButton;
   private EditText registerNoEditText, passwordEditText;
   CollectionReference collectionReference=FirebaseFirestore.getInstance().collection("Users");
 //  CollectionReference refer = database.collection("users");





    public LoginFragment() {
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
                // To RegisterFragment
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
                Fragment registerFragment = new RegisterFragment();

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
                if (!registerNoEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    collectionReference.document(registerNoEditText.getText().toString().trim()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                            try {
                                if (documentSnapshot.get("password").toString().equals(passwordEditText.getText().toString()))
                                    startActivity(new Intent(getContext(), MainPage.class));
                                else
                                    Toast.makeText(getContext(),"Password Incorrect",3000).show();
                            }
                            catch (NullPointerException me){
                                Toast.makeText(getContext(),"Please enter a valid registration number",3000).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(getContext(),"All fields are compulsory",Toast.LENGTH_SHORT).show();
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
