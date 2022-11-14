package com.example.test_github.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.test_github.Model.user;

import java.util.List;
@Dao
public interface UserDAO {
    @Query("select * from user")
    List<user> getAll();
    @Insert
    void insert(user user);
    @Update
    void update(user user);
    @Delete
    void delete(user user);
}
