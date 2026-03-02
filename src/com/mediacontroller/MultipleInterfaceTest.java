package com.mediacontroller;
public class MultipleInterfaceTest {

    public static void main(String[] args) {

     
        AudioPlayer audioPlayer = new AudioPlayer("Shape of You", 240);
        
        VoiceRecorder voiceRecorder = new VoiceRecorder("Voice Note");

        MediaController controller = new MediaController();

        System.out.println("----- Testing AudioPlayer Playback -----");
        controller.controlPlayback(audioPlayer);

        System.out.println("\n----- Testing VoiceRecorder Playback -----");
        controller.controlPlayback(voiceRecorder);

        System.out.println("\n----- Testing VoiceRecorder Recording -----");
        controller.controlRecording(voiceRecorder, 10);

     
        System.out.println("\n----- Polymorphism Example --------");
        Playable ref = new VoiceRecorder("Meeting Note");
        ref.play();
        ref.stop();
    }
}
