package com.tacticalsandwitchstudios.personalarnie;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

/**
 * Created by DavidMcKenzie1 on 05/09/2017.
 */

//ON HOLD UNTIL SOUNDCLOUD BEGINS ACCEPTING DEVS AGAIN
public class Audio {

    public void Play(String responseUrl){

        MediaPlayer mediaPlayer = new MediaPlayer();    //Creates a Media Player that can play the audio to the user
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); //Sets the type of audio for the stream to play
        try {                                           //Need to set up a try catch in case of IOExceptions
            Log.d("AudioClass", "receiving URL");
            mediaPlayer.setDataSource(responseUrl);     //Pass the url of the audio into the media player
            Log.d("AudioClass", "Audio is preparing");
            mediaPlayer.prepare();                      //Buffer the audio
            Log.d("AudioClass", "Audio is about to start");
            mediaPlayer.start();                        //Play the audio
            Log.d("AudioClass", "Audio has played");
        }catch(IOException e){
            Log.d("IOException", e.toString());         //Log the IOException
        }

    }
}
