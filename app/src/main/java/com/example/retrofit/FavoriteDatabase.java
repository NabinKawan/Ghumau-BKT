package com.example.retrofit;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={FavoriteList.class},version = 1,exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();


}