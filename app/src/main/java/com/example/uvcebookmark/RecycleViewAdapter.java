package com.example.uvcebookmark;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private ArrayList<ExampleBook> bookList;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView bookImage;
        public TextView bookName;
        public TextView bookDesc;
        public TextView sub;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            bookImage = itemView.findViewById(R.id.book_image);
            bookName = itemView.findViewById(R.id.card_TV1);
            bookDesc = itemView.findViewById(R.id.card_TV2);
            sub = itemView.findViewById(R.id.subject_TV);
        }
    }

    public RecycleViewAdapter(ArrayList<ExampleBook> bookList) {
        this.bookList = bookList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_book,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExampleBook currentBook = bookList.get(position);
        holder.bookImage.setImageResource(currentBook.getImageResource());
        holder.bookName.setText(currentBook.getBookName());
        holder.bookDesc.setText(currentBook.getBookDesc());
        holder.sub.setText(currentBook.getSubject());


    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
