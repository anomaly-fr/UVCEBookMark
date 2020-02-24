package com.example.uvcebookmark;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.uvcebookmark.Snakey.BoardActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class BookDetails extends AppCompatActivity {

    FirebaseFirestore fireStore= FirebaseFirestore.getInstance();
    CollectionReference collectionReference=fireStore.collection("Books");
    DocumentReference bookreference;
    EditText name;
    EditText desc;
    String location;
    Button locate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        String barcode=getIntent().getStringExtra("barcode");
        name=findViewById(R.id.name);
        desc=findViewById(R.id.desc);
        locate=findViewById(R.id.locate);
        collectionReference.document(barcode).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                try{
                    Map<String,Object> map=documentSnapshot.getData();
                    name.setText(map.get("name").toString());
                    desc.setText(map.get("desc").toString());
                    location=map.get("location").toString();
                }
                catch (Exception eee){}


            }
        });
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookDetails.this, BoardActivity.class).putExtra("location",location));
            }
        });



    }
}
