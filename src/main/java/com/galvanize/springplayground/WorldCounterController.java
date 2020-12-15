package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static java.util.Calendar.APRIL;

@RestController
@RequestMapping("/words")
public class WorldCounterController {
    private WordCounter wc;
    WorldCounterController(WordCounter wc){
        this.wc = wc;
    }
    @PostMapping("/count")
    public Map<String, Integer> countWords(@RequestBody String string){
        return this.wc.count(string);
    }
}
