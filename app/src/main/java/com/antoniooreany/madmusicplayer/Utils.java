package com.antoniooreany.madmusicplayer;

import java.util.HashMap;

public class Utils {

    public static HashMap<Integer, AudioTrack> getCompositions() {
        HashMap<Integer, AudioTrack> audioTrackHashMap = new HashMap<>();
        int audioTrackNumber = 0;
        audioTrackHashMap.put(audioTrackNumber++, new AudioTrack(R.raw.a_memory_remains_acoustic, "a memory remains acoustic"));
        audioTrackHashMap.put(audioTrackNumber++, new AudioTrack(R.raw.frozen_hope, "frozen hope"));
        audioTrackHashMap.put(audioTrackNumber++, new AudioTrack(R.raw.i_want_the_wind_to_carry_me_acoustic, "i want the wind to carry me acoustic"));
        audioTrackHashMap.put(audioTrackNumber++, new AudioTrack(R.raw.into_silence, "into silence"));
        audioTrackHashMap.put(audioTrackNumber++, new AudioTrack(R.raw.particles, "particles"));
        audioTrackHashMap.put(audioTrackNumber++, new AudioTrack(R.raw.winters_past_acoustic, "winters past acoustic"));
        return audioTrackHashMap;
    }

}

