package com.tacticalsandwitchstudios.personalarnie;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DavidMcKenzie1 on 29/04/2017.
 */
public class Home extends AppCompatActivity{

    private ImageButton arniesFace;      //Voice recognition button
    private TextView output;        //Output for the user
    private Speech speechRecognizer;
    private Boolean recognizerAvailible =true;
    private Intent speech = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    private final int REQ_SPEECH_INTENT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        Log.d("Home:", "onCreate called");
        arniesFace = (ImageButton) findViewById(R.id.Arnold);
        output = (TextView) findViewById(R.id.Output);
        speechRecognizer = new Speech();
        voiceRecognitionCheck();    //Check to see if Voice Recognition is available
        talkWithArnie(arniesFace);
    }

    public void voiceRecognitionCheck() {
        //Check the device to see if voice recognition is supported
        PackageManager packageManager = getPackageManager(); //Get the package manager
        //Make a list of intents that can use speech recognition
        List<ResolveInfo> activities = packageManager.queryIntentActivities(
                    new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        //If the list is greater than 0 then the device can use voice recognition
        //so in order to deactivate the functionality if it cannot
        //disable the button if the list is 0
        if(activities.size() == 0){
            //Deactivate the button
            arniesFace.setEnabled(false);
            //Alert the users
            Toast.makeText(this, "No Voice Recognition Available on this Device", Toast.LENGTH_SHORT).show();
            recognizerAvailible = false;
        }
    }

    public void talkWithArnie(ImageButton face){
        face.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(recognizerAvailible){
                            speechRecognizer.start(output);
                            //starts the voice recognition
                            startActivityForResult(speech, REQ_SPEECH_INTENT_CODE);
                        }


                    }
                }
        );
    }

    //This handles the data that is given by the speech recognition
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        //Checks to make sure the code is Ok and is not null
        if(resultCode == RESULT_OK && data != null){
            //Places all of the data returned into an array, by converting the results to strings
            ArrayList <String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Log.d("Home", result.get(0));
            //Sets the text in the textbox to the word that the recogniser thinks was said.
            output.setText(result.get(0));
        }
    }

}
