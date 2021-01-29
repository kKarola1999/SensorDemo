package com.example.sensordemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundEffect {

    private static SoundPool soundPool;
    private static int hitSound;

    public SoundEffect(Context context) {

        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        hitSound = soundPool.load(context, R.raw.another, 1);
    }

    public void playHitSound(){
        soundPool.play(hitSound,1.0f,1.0f,1,0,1.0f);


    }

}
