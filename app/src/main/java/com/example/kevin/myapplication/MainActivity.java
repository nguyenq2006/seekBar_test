package com.example.kevin.myapplication;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar volumeSlider;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        volumeSlider = (SeekBar)findViewById(R.id.volume);
        volumeSlider.setMax(15);
        volumeSlider.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        volumeSlider.setProgress(0);
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            volumeSlider.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        }
        else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            volumeSlider.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        }
        return false;
    }

}
