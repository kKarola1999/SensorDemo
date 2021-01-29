package com.example.sensordemo;


import android.media.SoundPool;

public class SoundEffect extends SoundPool {
    /**
     * Constructor. Constructs a SoundPool object with the following
     * characteristics:
     *
     * @param maxStreams the maximum number of simultaneous streams for this
     *                   SoundPool object
     * @param streamType the audio stream type as described in AudioManager
     *                   For example, game applications will normally use
     *                   {@link AudioManager#STREAM_MUSIC}.
     * @param srcQuality the sample-rate converter quality. Currently has no
     *                   effect. Use 0 for the default.
     * @return a SoundPool object, or null if creation failed
     * @deprecated use {@link Builder} instead to create and configure a
     * SoundPool instance
     */
    public SoundEffect(int maxStreams, int streamType, int srcQuality) {
        super(maxStreams, streamType, srcQuality);
    }


}
