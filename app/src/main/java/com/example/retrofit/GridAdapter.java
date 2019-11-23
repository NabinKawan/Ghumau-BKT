package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GridAdapter extends ArrayAdapter<Hero> {
    private List<Hero> heroList;
    private Context mCtx;

    public GridAdapter(List<Hero> heroList, Context mCtx) {
        super(mCtx, R.layout.grid_data, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.grid_data, null, true);
        TextView textViewName = view.findViewById(R.id.textview);
        ImageView textViewImageUrl = view.findViewById(R.id.imageview);
        Hero hero = heroList.get(position);
        textViewName.setText(hero.getName());
        Picasso.with(mCtx).load(hero.getImageUrl()).into(textViewImageUrl);
        return view;
    }
}