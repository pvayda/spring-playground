package com.galvanize.springplayground;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
    private WordCounter wc;
    public WordCounterTest(WordCounter wc){
        this.wc = wc;
    }
    @Test
    public void testCount(){
        Map<String, Integer> result = this.wc.count("hello world hello hello");
        assertEquals(result.get("hello"), 3);
    }
}
