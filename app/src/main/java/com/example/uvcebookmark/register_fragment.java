package com.example.uvcebookmark;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class register_fragment extends Fragment {
    EditText enterName, enterContact, enterRegNo, enterPassword;

    Button registeredButton;
    FirebaseFirestore database = FirebaseFirestore.getInstance();


    public register_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_fragment, container, false);
        enterName = view.findViewById(R.id.name_ET);

        enterContact = view.findViewById(R.id.contact_ET);
       // enterContact.setTextColor(getResources().getColor(R.color.White));


        enterRegNo = view.findViewById(R.id.reg_ET);
        //enterRegNo.setTextColor(getResources().getColor(R.color.White));
        enterPassword = view.findViewById(R.id.setPassword_ET);
        //enterPassword.setTextColor(getResources().getColor(R.color.White));
        registeredButton = view.findViewById(R.id.registered_button);

        registeredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName,newContact,newRegNo,newPassword;
                newName = enterName.getText().toString().trim();
                newContact = enterContact.getText().toString().trim();
                newRegNo = enterRegNo.getText().toString().trim();
                newPassword = enterPassword.getText().toString().trim();


                Map<String,Object> data = new HashMap<>();
                data.put("NAME",newName);
                data.put("CONTACT",newContact);
                data.put("REGNO",newRegNo);
                data.put("PASSWORD",newPassword);

                database.collection("Users").document("First Users").set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getContext(),"Successful",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(),"Failed",Toast.LENGTH_SHORT).show();
                                Log.d("Register", "onFailure: "+e.toString());

                            }
                        });
            }
        });



        // Inflate the layout for this fragment

    return view;
    }

}
