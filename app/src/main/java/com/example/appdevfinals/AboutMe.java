package com.example.appdevfinals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AboutMe extends AppCompatActivity {

    ArrayList<AnimeList> animeTitle = new ArrayList<>();
    int[] animeImg = {R.drawable.deathnote, R.drawable.naruto, R.drawable.pokemon, R.drawable.onepiece, R.drawable.reborn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        RecyclerView recyclerView = findViewById(R.id.aRecyclerView);

        setuptitle();

        anime_adpater adpater = new anime_adpater(this, animeTitle);
        recyclerView.setAdapter(adpater);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toast.makeText(AboutMe.this, "About me", Toast.LENGTH_LONG).show();
    }

    private void setuptitle(){
        String[] anititle = getResources().getStringArray(R.array.anime_title);

        for(int i = 0; i < anititle.length; i++){
            animeTitle.add(new AnimeList(anititle[i], animeImg[i]));
        }
    }
}