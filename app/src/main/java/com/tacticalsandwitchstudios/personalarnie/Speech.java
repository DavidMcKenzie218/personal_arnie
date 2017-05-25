package com.tacticalsandwitchstudios.personalarnie;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by DavidMcKenzie1 on 25/05/2017.
 */
public class Speech {

    public void start(TextView output){

        Log.d("Speech:", "start is called");

        //This is the operation in charge of speech recognition
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        //Gets the extra key used in voice recognition
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());

        //Puts a hint in the text box for the user.
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, output.getText().toString());

        //Tells the speech recogniser how long the phrase is expected to be, free form being short.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    }

}
