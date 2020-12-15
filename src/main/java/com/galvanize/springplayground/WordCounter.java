package com.galvanize.springplayground;

import java.util.HashMap;
import java.util.Map;


public class WordCounter {
//    Takes a String
//    Splits on spaces and counts the words
//    Returns a Map<String, Integer> of the word counts
    public Map<String, Integer> count(String inputString){
        Map<String, Integer> wordCounter = new HashMap<>();
        //String[] inputWordArray = inputString.split(" ");
        String[] inputWordArray = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for(int i = 0; i < inputWordArray.length; i++){
            String currentWord = inputWordArray[i];
            if(wordCounter.containsKey(currentWord)){
                int increment = wordCounter.get(inputWordArray[i]) + 1;
                wordCounter.put(currentWord,increment);
            } else {
                wordCounter.put(currentWord, 1);
            }
        }
        return wordCounter;

    }
}
