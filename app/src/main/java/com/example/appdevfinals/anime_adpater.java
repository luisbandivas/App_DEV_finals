package com.example.appdevfinals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class anime_adpater extends RecyclerView.Adapter<anime_adpater.MyViewHolder> {

    Context context;
    ArrayList<AnimeList> animeLists;
    public anime_adpater(Context context, ArrayList<AnimeList> animeLists){
        this.context = context;
        this.animeLists = animeLists;
    }
    @NonNull
    @Override
    public anime_adpater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyler_view, parent, false);

        return new anime_adpater.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull anime_adpater.MyViewHolder holder, int position) {
        //assign value
        holder.tvTitle.setText(animeLists.get(position).getAnime_title());
        holder.imgView.setImageResource(animeLists.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        //count of recycle view
        return animeLists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgView;
        TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgAnime);
            tvTitle = itemView.findViewById(R.id.textviewTitle);
        }
    }
}
