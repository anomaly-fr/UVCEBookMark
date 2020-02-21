package com.example.uvcebookmark;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentTransaction;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDate;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    EditText enterName, enterContact, enterRegNo, enterPassword;

    Button registeredButton,arrowButton;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    DocumentReference reference ;// database.collection("Users");
    CollectionReference collectionReference = database.collection("Users");
    String newName, newContact, newRegNo, newPassword,message;






    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_fragment, container, false);
        enterName = view.findViewById(R.id.name_ET);

        enterContact = view.findViewById(R.id.contact_ET);
       // enterContact.setTextColor(getResources().getColor(R.color.White));


        enterRegNo = view.findViewById(R.id.regNo_ET);
        //enterRegNo.setTextColor(getResources().getColor(R.color.White));
        enterPassword = view.findViewById(R.id.setPassword_ET);

        registeredButton = view.findViewById(R.id.registered_button);





        registeredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newName = enterName.getText().toString().trim();
                newContact = enterContact.getText().toString().trim();
                newRegNo = enterRegNo.getText().toString().trim();
                newPassword = enterPassword.getText().toString().trim();


                if (newName.isEmpty() || newContact.isEmpty()|| newRegNo.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(getContext(), "All fields are compulsory", 2500).show();

                } else {

                    message = "Successfully registered with ";

                    message = message.concat(figureBranchYear(newRegNo));
                    Toast.makeText(getContext(), message, 3000).show();
                    addUser();

                }
            }
            });




        // Inflate the layout for this fragment

    return view;
    }

    private String figureBranchYear(String newRegNo) {
        String b="",yearString;
        int year,currentYear;

        if(newRegNo.toUpperCase().contains("GAEC"))
            b = "Computer Science Engineering; ";
        else if(newRegNo.toUpperCase().contains("GAEE80"))
            b = "Electrical Engineering; ";
        else if(newRegNo.toUpperCase().contains("GAEE70"))
            b = "Electrical and Electronics Engineering; ";
        else if(newRegNo.toUpperCase().contains("gais"))
            b = "Information Science Engineering; ";
        else if(newRegNo.toUpperCase().contains("GAEM"))
            b = "Mechanical Engineering; ";

       yearString = newRegNo.substring(0,2);
       year = Integer.parseInt(yearString);
      currentYear = LocalDate.now().getYear(); //Get year a better way Idk
       // currentYear = 2020;
       year = currentYear-2000-year;
       b = b.concat("Year: ");
       yearString  = Integer.toString(year);
       b = b.concat(yearString);
        b = b.concat(".");

       return b;









    }

    private void addUser(){


        User user = new User();
        user.setName(newName);
        user.setContact(newContact);
        user.setRegisterNumber(newRegNo);
        user.setPassword(newPassword);

                reference=collectionReference.document(newRegNo);
                reference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
              //          Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                        Fragment loginFragment = new LoginFragment();

                        FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame,loginFragment);
                        fragmentTransaction1.addToBackStack(null);
                        fragmentTransaction1.commit();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"Connect to the Internet",3000).show();
                    }
                });

            }


        }





