package com.tacticalsandwitchstudios.personalarnie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by DavidMcKenzie1 on 29/04/2017.
 */
public class Home extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        Log.d("Home:", "onCreate called");
    }

}
