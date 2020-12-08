package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    MockMvc mvc;
    @Test
    public void testHelloEndpoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }
    @Test
    public void testGetPiEndpoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }
    @Test
    public void testCalcEndpointAdd() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=4&y=6");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }
    @Test
    public void testCalcEndpointSubtract() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=4&y=6");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }
    @Test
    public void testCalcEndpointMultiply() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }
    @Test
    public void testCalcEndpointDivide() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
    }
    @Test
    public void testSumEndpoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

}
