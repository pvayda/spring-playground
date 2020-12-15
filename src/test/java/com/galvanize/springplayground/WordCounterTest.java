package com.galvanize.springplayground;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testCount(){
        WordCounter wc = new WordCounter();
        Map<String, Integer> result = wc.count("hello world hello hello");
        assertEquals(result.get("hello"), 3);
    }
}
