package com.example.uvcebookmark;

import android.widget.TextView;

public class ExampleBook {
    private int imageResource;
    private String bookName;
    private String bookDesc;
    private String subject;

    public ExampleBook(int imageResource, String bookName, String bookDesc,String subject) {
        this.imageResource = imageResource;
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.subject = subject;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
