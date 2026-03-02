package com.mediacontroller;

public class VoiceRecorder implements Playable, Recordable {

    private String recordingName;
    private int duration;
    private String playStatus;
    private boolean recording;
    private int recordedDuration;

    public VoiceRecorder(String recordingName) {
        this.recordingName = recordingName;
        this.playStatus = "STOPPED";
        this.recording = false;
        this.recordedDuration = 0;
    }

    // ---------------- Playable Methods ----------------

    @Override
    public void play() {
        playStatus = "PLAYING";
        System.out.println("Playing recording: " + recordingName);
    }

    @Override
    public void pause() {
        if (playStatus.equals("PLAYING")) {
            playStatus = "PAUSED";
            System.out.println("Recording paused.");
        }
    }

    @Override
    public void stop() {
        playStatus = "STOPPED";
        System.out.println("Playback stopped.");
    }

    @Override
    public int getDuration() {
        return recordedDuration;
    }

    // ---------------- Recordable Methods ----------------

    @Override
    public void startRecording() {
        recording = true;
        System.out.println("Recording started...");
    }

    @Override
    public void stopRecording() {
        recording = false;
        System.out.println("Recording stopped.");
    }

    @Override
    public void saveRecording(String filename) {
        System.out.println("Recording saved as: " + filename);
    }

    @Override
    public boolean isRecording() {
        return recording;
    }

    // Extra Method
    public void addRecordingTime(int seconds) {
        if (recording) {
            recordedDuration += seconds;
            System.out.println(seconds + " seconds recorded.");
        } else {
            System.out.println("Start recording first!");
        }
    }
}