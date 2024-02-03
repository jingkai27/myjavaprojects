// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit TestTriangle.java
// 
// GeometricObject.class: 
// -- This is a Java bytecode file
// -- just leave it alone, you should not click on it and type in it 
// -- Reset the assignment (Actions --> Reset Assignment) if you encounter issues after clicking this file
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.util.Date;

class GeometricObject {
    public String color = "white";
    public boolean filled = false;
    public Date dateCreated = new Date();

    public GeometricObject() {
    }

    public GeometricObject(String var1, boolean var2) {
        this.color = var1;
        this.filled = var2;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String var1) {
        this.color = var1;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean var1) {
        this.filled = var1;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public String toString() {
        return "color: " + this.color + "\\nfilled: " + this.filled;
    }
}


class Triangle extends GeometricObject {
    //attributes
    public double side1;
    public double side2;
    public double side3;

    // constructor
    public Triangle(double val1, double val2, double val3){
        this.side1 = val1;
        this.side2 = val2;
        this.side3 = val3;
    }

    public Triangle(){
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public double getArea(){
        double s = (this.side1 + this.side2 + this.side3)/2;
        return Math.sqrt(s * (s-this.side1) * (s - this.side2) * (s - this.side3));
    }
    public double getPerimeter(){
        return (this.side1 + this.side2 + this.side3);
    }
    public static void main(String[] args){
        Triangle tri1 = new Triangle (3.4, 5, 6);
        System.out.println(tri1.side1);
        Triangle tri2 = new Triangle();
        System.out.println(tri2.side1);
        System.out.println(tri2.getPerimeter());
        System.out.println(tri2.getArea());
        System.out.println(tri2.toString());
        System.out.println(tri2.getColor());
        Triangle tri3 = new Triangle(3,4,5);

    }

    public String toString(){
        return ("Triangle: side1 = " + this.side1 + " side 2 = " + this.side2 + " side3 = " + this.side3);
    }
}

/* 2. [10 points] Design a class named Triangle that extends GeometricObject. The class contains:

[OK] Three double data fields named side1, side2, side3 with default value 1.0 to denote three sides of the triangle.
[OK] A no-arg constructor to create a default triangle
[OK] A constructor that creates a triangle with the specified side1, side2, and side3
[OK] A method named getArea() that returns the area
[ok] A method named getPerimeter() that returns the perimeter
[OK] A method named toString() that returns description of the triangle

Triangle: side1 = 1.0 side2 = 2.0 side3 = 3.0

Write a test program to test the code. The program should create the Triangle object with these sides and color and filled properties set.*/
