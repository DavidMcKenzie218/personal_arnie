package com.tacticalsandwitchstudios.personalarnie;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by DavidMcKenzie1 on 29/04/2017.
 */
public class Home extends AppCompatActivity{

    private Button arniesFace;      //Voice recognition button
    private TextView output;        //Output for the user

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        Log.d("Home:", "onCreate called");
        arniesFace = (Button) findViewById(R.id.Arnold);
        output = (TextView) findViewById(R.id.Output);
        voiceRecognitionCheck();                //Check to see if Voice Recognition is available
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
            Toast.makeText(this, "No Voice Recognition Availible on this Device", Toast.LENGTH_SHORT).show();
        }
        else{
            output.setText("Talk to the hand");
        }
    }

}
