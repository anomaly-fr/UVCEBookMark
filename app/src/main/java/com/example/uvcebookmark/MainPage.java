package com.example.uvcebookmark;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DrawerLayout drawerLayout;

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ArrayList<ExampleBook> bookArrayList = new ArrayList<>();
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Software Engineering", "Ian Sommerville", "SE"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Operating System Concepts", "Silberschatz/Galvin/Gagne", "OS"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Finite Automata and Formal Languages: A Simple Approach", "A.M Padma Reddy", "FAFL"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Higher Engineering Mathematics", "B.S Grewal", "M4"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Introduction to Design and Analysis of Algorithms", "Anany Levitin", "DAA"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "The x86 PC Assembly Language Design and Interfacing", "Mazidi/Mazidi/Causey", "MP"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 7", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 8", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 9", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 10", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 11", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 12", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 13", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 14", "Description", "SUB"));
        bookArrayList.add(new ExampleBook(R.drawable.openn, "Name of book 15", "Description", "SUB"));

        recyclerView = findViewById(R.id.recycler_view);

        adapter = new RecycleViewAdapter(bookArrayList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        drawerLayout = findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        setSupportActionBar(toolbar);
//    }
//
//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//        else super.onBackPressed();
//    }

    }

}
