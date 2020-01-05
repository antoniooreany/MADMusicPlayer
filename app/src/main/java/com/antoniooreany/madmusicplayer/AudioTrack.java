package com.antoniooreany.madmusicplayer;

public class AudioTrack {
    private int id;
    private String name;

    public AudioTrack(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
