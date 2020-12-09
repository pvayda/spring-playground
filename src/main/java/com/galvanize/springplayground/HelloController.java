package com.galvanize.springplayground;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PostMapping("/math/sum")
    public String postSum(@RequestParam MultiValueMap<String, String> querystring){
        MathService ms = new MathService(querystring);
        return ms.calcSum();
    }
    //POST /math/volume/3/4/5 should render the result The volume of a 3x4x5 rectangle is 60
    @RequestMapping("/math/volume/{height}/{width}/{length}")
    public String calcVolume(@PathVariable Map<String,String> pathVariables){
        int h = Integer.parseInt(pathVariables.get("height"));
        int w = Integer.parseInt(pathVariables.get("width"));
        int l = Integer.parseInt(pathVariables.get("length"));
        int volume = h*w*l;
        String volumeString = String.format("The volume of a %sx%sx%s rectangle is %d", pathVariables.get("height"),pathVariables.get("width"), pathVariables.get("length"), volume);
        return volumeString;
    }
    //POST requests to /math/area
    //type=circle&radius=4
    //Area of a circle with a radius of 4 is 50.26548

    //type=rectangle&width=4&height=7
    //Area of a 4x7 rectangle is 28
    @PostMapping(path = "/math/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String calcArea(CalcArea calcArea){
        String type = calcArea.getType();
        return calcArea.printArea();
    }

}
