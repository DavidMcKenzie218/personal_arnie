package com.tacticalsandwitchstudios.personalarnie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DavidMcKenzie1 on 30/08/2017.
 */
public class ResponseList {

    protected ArrayList<Map<String, String>> responses = new ArrayList<>();

    public ArrayList<Map<String, String>> Responses(){
        return responses;
    }

    public void AddResponses(String spokenWord, String responseFile, String catagory){
        Map<String, String> newResponse = new HashMap<>();
        newResponse.put("SpokenWord", spokenWord);
        newResponse.put("Response", responseFile);
        newResponse.put("Catagory", catagory);
        responses.add(newResponse);
    }

    public Map<String, String> FindResponse(String searchWord, String searchKey){
        for(Map<String, String> response : responses){
            if(response.get(searchKey).equals(searchWord)){
                return response;
            }

        }
        Map<String, String> nothingFound = new HashMap<>();
        nothingFound.put("SpokenWord", "Nothing Found");
        return nothingFound;
    }

    public ArrayList<Map<String, String>> FindResponse(String searchWord, String searchKey, String howMany){
        ArrayList<Map<String, String>> allResponses = new ArrayList<>();
        for(Map<String, String> response : responses){
            if(response.get(searchKey).equals(searchWord)){
                allResponses.add(response);
            }

        }
        return allResponses;
    }

}
