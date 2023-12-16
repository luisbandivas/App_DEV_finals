package com.example.appdevfinals;

public class AnimeList {
    String anime_title;
    int img;

    public AnimeList(String anime_title, int img) {
        this.anime_title = anime_title;
        this.img = img;
    }

    public String getAnime_title() {
        return anime_title;
    }

    public int getImg() {
        return img;
    }
}
