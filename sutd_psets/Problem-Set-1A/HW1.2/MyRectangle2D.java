public class MyRectangle2D {

    public static void main(String[] args){
        MyRectangle2D rect1 = new MyRectangle2D();
        System.out.println("This is the width: " + rect1.getWidth());
        MyRectangle2D rect2 = new MyRectangle2D(4,5,3.4,5.89);
        System.out.println("This is the width: " + rect2.getWidth());
        System.out.println("This is the area: " + rect2.getArea());
        System.out.println("This is the perimeter: " + rect2.getPerimeter());
        System.out.println("This is the boolean result " + rect2.pointInsideRectangle(3,4));
    }
    // data field
    private double x;
    private double y;
    private double width;
    private double height;

    // getter and setter method
    public double getX(){
        return x;
    }

    public void setX(double newVal){
        x = newVal;
    }

    public double getY(){
        return y;
    }

    public void setY(double newVal){
        y = newVal;
    }

    private double getWidth(){
        return width;
    }

    private void setWidth(double newVal){
        width = newVal;
    }

    private double getHeight(){
        return width;
    }

    private void setHeight(double newVal){
        height = newVal;
    }

    // constructor
    public MyRectangle2D(){
        this(0,0,1,1);
    }

    public MyRectangle2D(double x, double y, double h, double w){
        x = x;
        y = y;
        height = h;
        width = w;
    }

    // getArea()

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return 2 * this.width + 2*this.height;
    }

    public boolean pointInsideRectangle (double x_new, double y_new){
        if (x_new < this.getX() + this.getWidth() && x_new > this.getX() - this.getWidth()){
            if (y_new < this.getY() + this.getHeight() && y_new > this.getY() - this.getHeight()){
                return true;
            }
        }
    return false;
    }

}


/* [20 points] Geometry: The MyRectangle2D class

Define the MyRectangle2D class that contains:

• [OK] Two double data fields named x and y that specify the center of the rectangle with get and set methods: getX, setX, getY, setY. (Assume that the rectangle sides are parallel to x- or y- axes.)
• [OK] The double data fields width and height with get and set methods: getWidth, setWidth, getHeight, setHeight.
• [OK] A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and 1 for both width and height.
• [OK] A constructor that creates a rectangle with the specified x, y, width, and height: MyRectangle2D(double x, double y, double width, double height)
• [OK] A method getArea() that returns the area of the rectangle.
• [OK] A method getPerimeter() that returns the perimeter of the rectangle.
• A method contains(double x, double y) that returns true if the specified point (x, y) is inside this rectangle. See Figure 1(a).
• A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside this rectangle. See Figure 1(b).
• A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this rectangle. See Figure 1(c).

(a) (b) (c)

Figure 1: (a) A point is inside the rectangle. (b) A rectangle is inside another rectangle. (c) A rectangle overlaps another rectangle.

Implement data fields, all constructors, methods getArea(), getPerimeter(), and contains(double x, double y), contains(MyRectangle2D r), and overlaps(MyRectangle2D r)

Please develop test cases to test your code properly before submission


 */