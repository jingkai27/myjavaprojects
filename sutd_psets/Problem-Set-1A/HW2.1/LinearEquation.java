// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit TestLinearEquation.java  

import java.util.Scanner;
class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;


    public double getA(){return a;}
    public double getB(){return b;}
    public double getC(){return c;}
    public double getD(){return d;}
    public double getE(){return e;}
    public double getF(){return f;}

    public LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean isSolvable(){
        if ((this.a * this.d - this.b * this.c) != 0 ){
            return true;
        } else return false;
    }

    public double getX(){
        double num = this.e * this.d - this.f * this.b;
        double deno = this.a * this.d - this.b * this.c;
        return num / deno;
    }

    public double getY(){
        double x = getX();
        return (this.e - this.a * x)/this.b;
    }
}

    /*public void testProgram(){
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
        // Check if the equation has a solution
        if (isSolvable() == true){
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
        }*/

/*

The class contains:

OK Private data fields a, b, c, d, e, and f, the coefficients.
OK A constructor with the arguments for a, b, c, d, e, and f.
OK Six get methods for a, b, c, d, e, and f.
OK A method named isSolvable() that returns true if ad - bc is not 0 (why?)
OK Methods getX() and getY() that return the solution for the equation

Write a test program that prompts user to enter a, b, c, d, e and f and displays the result.

OK If ad – bc is 0, report that “The equation has no solution.”

*/

