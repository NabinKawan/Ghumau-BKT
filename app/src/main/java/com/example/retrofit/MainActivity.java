package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String JSON_URL = "http://www.kawannabin.com.np/conn.php";
    ImageView home,favourite,map,chat,menu,imageView;
    GridView gridView;
    List<Hero> heroList;
    CarouselView carouselView;
    AutoCompleteTextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        carouselView=findViewById(R.id.carousel);
        gridView = findViewById(R.id.gridview);
        heroList = new ArrayList<>();
        map=findViewById(R.id.mapp);
        home=findViewById(R.id.home1);
        favourite=findViewById(R.id.fav);
        chat=findViewById(R.id.chat);
        menu=findViewById(R.id.menu);
        favourite.setOnClickListener(this);
        chat.setOnClickListener(this);
        map.setOnClickListener(this);
        menu.setOnClickListener(this);
        home.setOnClickListener(this);
        loadHeroList();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position==0){
                Intent intent=new Intent(MainActivity.this,Temples.class);
                startActivity(intent);
            }
        }
    });
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

    private void loadHeroList() {
        final ProgressBar progressBar =findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);


                        try {
                            JSONArray ja= new JSONArray(response);
                            for (int i = 0; i < ja.length(); i++) {
                                JSONObject heroObject = ja.getJSONObject(i);
                                Hero hero = new Hero(heroObject.getInt("id"),
                                                     heroObject.getString("menuname"),
                                                     heroObject.getString("menuimage"));
                                heroList.add(hero);
                            }
                            GridAdapter adapter = new GridAdapter(heroList, getApplicationContext());
                            gridView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}