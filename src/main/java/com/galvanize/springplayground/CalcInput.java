package com.galvanize.springplayground;

public class CalcInput {
    private String operation;
    private String opString;
    private int solution;
    private int x;
    private int y;
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
