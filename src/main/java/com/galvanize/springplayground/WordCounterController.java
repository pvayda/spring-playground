package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/words")
public class WordCounterController {
    private WordCounter wc;
    public WordCounterController(WordCounter wc){
        this.wc = wc;
    }
    @PostMapping("/count")
    public Map<String, Integer> countWords(@RequestBody String string){
        return this.wc.count(string);
    }
}
