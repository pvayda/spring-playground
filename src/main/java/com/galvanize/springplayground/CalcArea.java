package com.galvanize.springplayground;

public class CalcArea {
    String type;
    double radius;
    double width;
    double height;
    double area;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public double getRadius() {
        return radius;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }





    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double calcArea(){
        if(this.type.equals("rectangle")){
            if(this.height > 0 && this.width > 0){
                return this.height * this.width;
            } else {
                return -1;
            }
        } else if(this.type.equals("circle")){
            if(this.radius > 0){
                return Math.PI * Math.pow(this.radius, 2);
            } else {
                return -1;
            }

        } else {
            return -1;
        }
    }
    public String printArea(){
        this.area = calcArea();
        if(this.area == -1){
            return "Invalid";
        } else {
            if(this.type.equals("rectangle")){
                return String.format("Area of a %.0fx%.0f rectangle is %.0f", this.width, this.height, this.area);
            } else if(this.type.equals("circle")){
                return String.format("Area of a circle with a radius of %.0f is %.5f", this.radius, this.area);
            } else{
              return "Something went wrong";
            }
        }

    }

}
