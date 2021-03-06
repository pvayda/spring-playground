package com.galvanize.springplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WordCounterController.class)
public class WordCounterControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    WordCounter wc;

    @BeforeEach
    public void setup(){
        Map<String, Integer> expected = new HashMap<>();
        expected.put("world", 1);
        expected.put("hello", 3);
        when(wc.count("hello hello world hello")).thenReturn(expected);
    }

    @Test
    public void testCountWords() throws Exception {
        this.mvc.perform(post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content("hello hello world hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hello", equalTo(3)));
    }
}
