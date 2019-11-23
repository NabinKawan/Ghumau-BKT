package com.example.retrofit;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
        List<Hero> product_lists;
        Context ct;

public ProductAdapter(List<Hero> product_lists, Context ct) {
        this.product_lists = product_lists;
        this.ct = ct;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list,viewGroup,false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
final Hero productList=product_lists.get(i);
        String pimg=productList.getImageUrl();
        Picasso.with(ct).load(pimg).into(viewHolder.img);


        viewHolder.tv.setText(productList.getName());
        if (Temples.favoriteDatabase.favoriteDao().isFavorite(productList.getId())==1)
        viewHolder.fav_btn.setImageResource(R.drawable.ic_favorite);
        else
        viewHolder.fav_btn.setImageResource(R.drawable.ic_favorite_border_black_24dp);


        viewHolder.fav_btn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        FavoriteList favoriteList=new FavoriteList();

        int id=productList.getId();
        String image=productList.getImageUrl();
        String name=productList.getName();

        favoriteList.setId(id);
        favoriteList.setImage(image);
        favoriteList.setName(name);

        if (Temples.favoriteDatabase.favoriteDao().isFavorite(id)!=1){
        viewHolder.fav_btn.setImageResource(R.drawable.ic_favorite);
        Temples.favoriteDatabase.favoriteDao().addData(favoriteList);

        }else {
        viewHolder.fav_btn.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        Temples.favoriteDatabase.favoriteDao().delete(favoriteList);

        }


        }
        });
        }


@Override
public int getItemCount() {
        return product_lists.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView img,fav_btn;
    TextView tv;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.img_pr);
        tv=(TextView)itemView.findViewById(R.id.tv_name);
        fav_btn=(ImageView)itemView.findViewById(R.id.fav_btn);

    }
}
}