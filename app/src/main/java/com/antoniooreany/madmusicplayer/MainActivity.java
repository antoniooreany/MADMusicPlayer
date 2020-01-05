package com.antoniooreany.madmusicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private boolean isPlaying = false;
    private MediaPlayer mediaPlayer;
    private Integer audioTrackNumber = 0;
    private HashMap<Integer, AudioTrack> audioTrackHashMap;
    private TextView textViewAudioTrackNumber;
    private TextView textViewAudioTrackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioTrackHashMap = Utils.getCompositions();
        mediaPlayer = MediaPlayer.create(this, audioTrackHashMap.get(audioTrackNumber).getId());

        textViewAudioTrackNumber = findViewById(R.id.textView_audio_track_number);
        textViewAudioTrackName = findViewById(R.id.textView_audio_track_name);

        fillAudioTrackData();
    }

    private void fillAudioTrackData() {
        textViewAudioTrackNumber.setText("audioTrackNumber: " + audioTrackNumber.toString());
        textViewAudioTrackName.setText(audioTrackHashMap.get(audioTrackNumber).getName());
    }

    private void continuePreviousActivity() {
        if (isPlaying) mediaPlayer.start();
        else mediaPlayer.pause();
    }

    public void playButtonOnClick(View view) {
        if (!isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
        }
    }

    public void stopButtonOnClick(View view) {
        if (isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
        }
    }

    public void prevButtonOnClick(View view) {
        if (isPlaying) mediaPlayer.stop();
        if (audioTrackNumber > 0) {
            mediaPlayer = MediaPlayer.create(this, audioTrackHashMap.get(--audioTrackNumber).getId());

        } else {
            audioTrackNumber = Utils.getCompositions().size() - 1;
            mediaPlayer = MediaPlayer.create(this, audioTrackHashMap.get(audioTrackNumber).getId());
        }
        fillAudioTrackData();
        continuePreviousActivity();
        Log.e("****prevButtonOnClick: ", audioTrackNumber.toString());

    }

    public void nextButtonOnClick(View view) {
        if (isPlaying) mediaPlayer.stop();
        if (audioTrackNumber < Utils.getCompositions().size() - 1) {
            mediaPlayer = MediaPlayer.create(this, audioTrackHashMap.get(++audioTrackNumber).getId());
        } else {
            audioTrackNumber = 0;
            mediaPlayer = MediaPlayer.create(this, audioTrackHashMap.get(audioTrackNumber).getId());
        }
        fillAudioTrackData();
        continuePreviousActivity();
        Log.e("****nextButtonOnClick: ", audioTrackNumber.toString());
    }

    /**
     * Called when the media file is ready for playback.
     *
     * @param mp the MediaPlayer that is ready for playback
     */
    @Override
    public void onPrepared(MediaPlayer mp) {

    }


    /**
     * Called when pointer capture is enabled or disabled for the current window.
     *
     * @param hasCapture True if the window has pointer capture.
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
