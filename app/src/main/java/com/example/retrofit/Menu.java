package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    ImageView map,home,favourite,menu,chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
