package com.tacticalsandwitchstudios.personalarnie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by DavidMcKenzie1 on 29/08/2017.
 */
public class responseTest {

    ResponseList testResponses;

    @Before
    public void before(){

        testResponses = new ResponseList();

    }

    @Test
    public void responseListCanStoreAllResponses(){
        ArrayList<Map<String, String>> actual= testResponses.Responses();
        ArrayList<Map<String, String>> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    public void responseListCanAddAResponse(){
        testResponses.AddResponses("hello", "soundcloud.com/hello", "greeting");
        ArrayList<Map<String, String>> actual= testResponses.Responses();
        Map<String, String> expected = new HashMap<>();
        expected.put("SpokenWord", "hello");
        expected.put("Response", "soundcloud.com/hello");
        expected.put("Catagory", "greeting");
        assertEquals(expected, actual.get(0));
    }

    @Test
    public void responseListCanFindASpecificResponse(){
        testResponses.AddResponses("hello", "soundcloud.com/hello", "greeting");
        testResponses.AddResponses("goodbye", "soundcloud.com/goodbye", "farewell");
        testResponses.AddResponses("talk to the hand", "soundcloud.com/talk_to_the_hand", "speak");
        Map<String, String> response = testResponses.FindResponse("hello", "SpokenWord");
        Map<String, String> expected = new HashMap<>();
        expected.put("SpokenWord", "hello");
        expected.put("Response", "soundcloud.com/hello");
        expected.put("Catagory", "greeting");
        assertEquals(expected, response);
    }

    @Test
    public void responseCouldNotBeFound(){
        Map<String, String> response = testResponses.FindResponse("nothing to be found", "SpokenWord");
        Map<String, String> expected = new HashMap<>();
        expected.put("SpokenWord", "Nothing Found");
        assertEquals(expected, response);
    }

    @Test
    public void responseListCanFindAllOfAResponse(){
        testResponses.AddResponses("hello", "soundcloud.com/hello", "greeting");
        testResponses.AddResponses("goodbye", "soundcloud.com/goodbye", "farewell");
        testResponses.AddResponses("talk to the hand", "soundcloud.com/talk_to_the_hand", "speak");
        testResponses.AddResponses("hello", "soundcloud.com/hi", "greeting");
        ArrayList<Map<String, String>> response = testResponses.FindResponse("hello", "SpokenWord", "all");
        Map<String, String> exampleOne = new HashMap<>();
        exampleOne.put("SpokenWord", "hello");
        exampleOne.put("Response", "soundcloud.com/hello");
        exampleOne.put("Catagory", "greeting");
        Map<String, String> exampleTwo = new HashMap<>();
        exampleTwo.put("SpokenWord", "hello");
        exampleTwo.put("Response", "soundcloud.com/hi");
        exampleTwo.put("Catagory", "greeting");
        ArrayList<Map<String, String>> expected = new ArrayList<>();
        expected.add(exampleOne);
        expected.add(exampleTwo);
        assertEquals(expected, response);
    }

    @Test
    public void noResponsesCouldBeFound(){
        ArrayList<Map<String, String>> response = testResponses.FindResponse("hello", "SpokenWord", "all");
        ArrayList<Map<String, String>> expected = new ArrayList<>();
        assertEquals(expected, response);
    }

}