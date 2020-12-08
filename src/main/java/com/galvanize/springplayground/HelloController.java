package com.galvanize.springplayground;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
    @GetMapping("/math/pi")
    public String getPi(){
        return "3.141592653589793";
    }
    @GetMapping("/math/calculate")
    public String runCalculation(MathService ms){
        return String.format("%d %s %d = %d", ms.getX(), ms.getOpString(), ms.getY(), ms.getSolution());
    }
    //math/sum?n=4&n=5&n=6 should render the string 4 + 5 + 6 = 15
    @PostMapping("/math/sum")
    public String postSum(@RequestParam MultiValueMap<String, String> querystring){
        MathService ms = new MathService(querystring);
        return ms.calcSum();
//
    }

}
