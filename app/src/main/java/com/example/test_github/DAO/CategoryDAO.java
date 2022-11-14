package com.example.test_github.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.test_github.Model.categorys;

import java.util.List;

@Dao
public interface CategoryDAO {
      @Query("select * from categorys")
      List<categorys> getAll();
      @Insert
      void insertTLoai(categorys categorys);
      @Update
      void updateTLoai(categorys categorys);
      @Delete
      void deleteTLoai(categorys categorys);
      //huan test

      //fsdfsdf
  }


