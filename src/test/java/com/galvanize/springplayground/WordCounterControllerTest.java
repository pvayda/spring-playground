package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WorldCounterController.class)
public class WordCounterControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testCountWords() throws Exception {
        this.mvc.perform(post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content("hello hello world hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hello", equalTo(3)));
    }
}
