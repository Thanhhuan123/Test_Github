package com.example.test_github.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.test_github.DAO.CategoryDAO;
import com.example.test_github.DAO.OrderDAO;
import com.example.test_github.DAO.OrderDetailDAO;
import com.example.test_github.DAO.ProductsDAO;
import com.example.test_github.DAO.UserDAO;
import com.example.test_github.Model.categorys;
import com.example.test_github.Model.order;
import com.example.test_github.Model.order_detail;
import com.example.test_github.Model.products;
import com.example.test_github.Model.user;


@Database(entities = {categorys.class, order.class, products.class, order_detail.class, user.class}, exportSchema = false , version = 2)
public abstract class DbRoom extends RoomDatabase {
    private static final String DB_NAME = "DA1";
    private static DbRoom instance;
    public static synchronized DbRoom getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),DbRoom.class,DB_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract ProductsDAO productsDAO();
    public abstract UserDAO userDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderDetailDAO orderDetailDAO();
    public abstract CategoryDAO categoryDAO();
}
