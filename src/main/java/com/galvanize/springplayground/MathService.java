package com.galvanize.springplayground;

import org.springframework.util.MultiValueMap;

import java.util.List;

public class MathService {
    MultiValueMap<String, String> querystring;
    private String operation;
    private String opString;
    private int solution;
    private int x;
    private int y;
    MathService(){

    }
    MathService(MultiValueMap<String, String> querystring){
        this.querystring = querystring;
    }
    public String calcSum(){
        int sum = 0;
        String result = "";
        List<String> values = querystring.get("n");
        for (int i = 0; i < values.size(); i++){
            if(i == values.size() - 1){
                sum += Integer.parseInt(values.get(i));
                result += values.get(i) + " = ";
            } else {
                sum += Integer.parseInt(values.get(i));
                result += values.get(i) + " + ";
            }
        }
        result += Integer.toString(sum);
        return result;
    }
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOpString() {
        if(this.operation.equals("add")){
            return "+";
        } else if (this.operation.equals("subtract")){
            return "-";
        } else if (this.operation.equals("multiply")){
            return "*";
        } else if (this.operation.equals("divide")){
            return "/";
        } else {
            return "+";
        }
    }

    public int getSolution() {
        if(this.operation.equals("add")){
            return x + y;
        } else if (this.operation.equals("subtract")){
            return x - y;
        } else if (this.operation.equals("multiply")){
            return x * y;
        } else if (this.operation.equals("divide")){
            return x / y;
        } else {
            return x + y;
        }
    }

}
