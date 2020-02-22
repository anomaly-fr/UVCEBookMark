package com.example.uvcebookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ArrayList<ExampleBook> bookArrayList = new ArrayList<>();
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Software Engineering","Ian Sommerville","SE"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Operating System Concepts","Silberschatz/Galvin/Gagne","OS"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Finite Automata and Formal Languages: A Simple Approach","A.M Padma Reddy","FAFL"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 4","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 5","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 6","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 7","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 8","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 9","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 10","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 11","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 12","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 13","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 14","Description","SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn,"Name of book 15","Description","SUB"));

        recyclerView = findViewById(R.id.recycler_view);

        adapter = new RecycleViewAdapter(bookArrayList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
