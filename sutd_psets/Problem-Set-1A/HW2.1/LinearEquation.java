// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit TestLinearEquation.java  

import java.util.Scanner;
class LinearEquation {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;


    public int getA(){return a;}
    public int getB(){return b;}
    public int getC(){return c;}
    public int getD(){return d;}
    public int getE(){return e;}
    public int getF(){return f;}

    public LinearEquation(int a, int b, int c, int d, int e, int f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public static void main(String[] args){
        LinearEquation linEq1 = new LinearEquation(1,2,11,2,1,10);
        System.out.println(linEq1.getA());
        System.out.println(linEq1.isSolvable());
        System.out.println(linEq1.getX());
        System.out.println(linEq1.getY());
        linEq1.testProgram();
    }

    public boolean isSolvable(){
        if ((this.a * this.d - this.b * this.c) > 0 ){
            return true;
        } else return false;
    }

    public double getX(){
        double num = this.b * this.f - this.c * this.e;
        double deno = this.b * this.d - this.a * this.e;
        return num / deno;
    }

    public double getY(){
        double x = getX();
        return (this.c - this.a * x)/this.b;
    }

    public void testProgram(){
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter values for a, b, c, d, e, and f
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();

        System.out.print("Enter the value of d: ");
        double d = scanner.nextDouble();

        System.out.print("Enter the value of e: ");
        double e = scanner.nextDouble();

        System.out.print("Enter the value of f: ");
        double f = scanner.nextDouble();

        // Calculate determinant (ad - bc)
        double determinant = a * d - b * c;

        // Check if the equation has a solution
        if (determinant > 0) {
            // Calculate solutions for x and y using Cramer's rule
            double x = getX();
            double y = getY();

            // Display the solutions
            System.out.println("The solution for the system of equations is:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            // Equation has no solution
            System.out.println("The equation has no solution.");
        }

        scanner.close();
        }
    }

/*

The class contains:

OK Private data fields a, b, c, d, e, and f, the coefficients.
OK A constructor with the arguments for a, b, c, d, e, and f.
OK Six get methods for a, b, c, d, e, and f.
OK A method named isSolvable() that returns true if ad - bc is not 0 (why?)
OK Methods getX() and getY() that return the solution for the equation

Write a test program that prompts user to enter a, b, c, d, e and f and displays the result.

If ad – bc is 0, report that “The equation has no solution.”

*/

