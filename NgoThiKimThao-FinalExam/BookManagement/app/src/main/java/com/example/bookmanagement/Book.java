package com.example.bookmanagement;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "releaseYear")
    public String releaseYear;

    public Book(String name, String releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }
    public String getnName(){
        return this.name;
    }
    public String getnReleaseYear(){
        return this.releaseYear;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

}