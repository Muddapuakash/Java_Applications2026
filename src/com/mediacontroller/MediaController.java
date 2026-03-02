package com.mediacontroller;

public class MediaController {

    public void controlPlayback(Playable device) {
        device.play();
        device.pause();
        device.stop();
        System.out.println("Duration: " + device.getDuration() + " seconds");
    }

    public void controlRecording(Recordable device, int seconds) {
        device.startRecording();
        
        if (device instanceof VoiceRecorder) {
            VoiceRecorder vr = (VoiceRecorder) device;
            vr.addRecordingTime(seconds);
        }

        device.stopRecording();
        device.saveRecording("output_audio.wav");
    }
}
