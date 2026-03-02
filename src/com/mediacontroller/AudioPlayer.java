package com.mediacontroller;

public class AudioPlayer implements Playable {

    private String songName;
    private int duration;
    private String status; // PLAYING, PAUSED, STOPPED

    public AudioPlayer(String songName, int duration) {
        this.songName = songName;
        this.duration = duration;
        this.status = "STOPPED";
    }

    @Override
    public void play() {
        status = "PLAYING";
        System.out.println("Playing song: " + songName);
    }

    @Override
    public void pause() {
        if (status.equals("PLAYING")) {
            status = "PAUSED";
            System.out.println("Song paused.");
        }
    }

    @Override
    public void stop() {
        status = "STOPPED";
        System.out.println("Song stopped.");
    }

    @Override
    public int getDuration() {
        return duration;
    }
}
