package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class Favourite extends AppCompatActivity implements View.OnClickListener{
    ImageView map,home,favourite,menu,chat;
    private RecyclerView rv;
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        map=findViewById(R.id.mapp);
        home=findViewById(R.id.home1);
        favourite=findViewById(R.id.fav);
        chat=findViewById(R.id.chat);
        menu=findViewById(R.id.menu);
        map.setOnClickListener(this);
        favourite.setOnClickListener(this);
        chat.setOnClickListener(this);
        menu.setOnClickListener(this);
        home.setOnClickListener(this);

        rv=findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        getFavData();
    }
    private void getFavData() {
        List<FavoriteList> favoriteLists=Temples.favoriteDatabase.favoriteDao().getFavoriteData();

        adapter=new FavoriteAdapter(favoriteLists,getApplicationContext());
        rv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.home1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.fav:
                startActivity(new Intent(this,Favourite.class));
                break;
            case R.id.chat:
                startActivity(new Intent(this,Chat.class));
                break;
            case R.id.mapp:
                startActivity(new Intent(this,Map.class));
                break;
            case R.id.menu:
                startActivity(new Intent(this,Menu.class));
                break;

        }

    }
}
