package com.example.bookmanagement;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM book")
    List<Book> getAll();

    @Insert
     void insert(Book book);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);
}