package com.example.test_github.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.test_github.Model.products;

import java.util.List;
@Dao
public interface ProductsDAO {
    @Query("select * from products")
    List<products> getAll();
    @Insert
    void insert(products products);
    @Update
    void update(products products);
    @Delete
    void delete(products products);
}
