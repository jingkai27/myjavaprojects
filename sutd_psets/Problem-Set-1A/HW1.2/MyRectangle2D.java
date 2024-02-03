public class MyRectangle2D {

    public static void main(String[] args){
        MyRectangle2D rect1 = new MyRectangle2D();
        System.out.println("This is the width: " + rect1.getWidth());
        MyRectangle2D rect2 = new MyRectangle2D(4,5,3.4,5.89);
        System.out.println("This is the width: " + rect2.getWidth());
        System.out.println("This is the area: " + rect2.getArea());
        System.out.println("This is the perimeter: " + rect2.getPerimeter());
        System.out.println("This is the boolean result " + rect2.pointInsideRectangle(100,100));
        System.out.println("Rect inside rect: " + rect1.rectangleInsideRectangle(rect2) + ".");

        System.out.println("----- NEW -------");
        MyRectangle2D rect3 = new MyRectangle2D(100,6,1,2);
        System.out.println("Rect inside rect: " + rect2.rectangleInsideRectangle(rect1) + ".");
        System.out.println("Rect overlap rect "+ rect2.rectOverlap(rect3)+".");

        }

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
        double half_width = this.getWidth() / 2;
        double half_height = this.getHeight()/2;
        if (x_new < this.getX() + half_width && x_new > this.getX() - half_width){
            if (y_new < this.getY() + half_height && y_new > this.getY() - half_height){
                return true;
            }
        }
    return false;
    }

    public boolean rectangleInsideRectangle(MyRectangle2D newRect){
        // Condition 1: Center must be inside self rectangle
        // get centers first
        double newRectX = newRect.getX();
        double newRectY = newRect.getY();

        if(pointInsideRectangle(newRectX, newRectY)==true){
            // Condition 2: ends of small rectangle must be within the ends of big rectangle
            double newRectHalfWidth = newRect.getWidth()/2;
            double newRectHalfHeight = newRect.getHeight()/2;

            double corner1 = newRectX + newRectHalfWidth;
            double corner2 = newRectX - newRectHalfWidth;
            double corner3 = newRectY + newRectHalfHeight;
            double corner4 = newRectY - newRectHalfHeight;

            if (pointInsideRectangle(corner1, corner3) && pointInsideRectangle(corner2, corner4)){
                return true;
            } else return false;
        }
    return false; }

    public boolean rectOverlap(MyRectangle2D newRect){
        // if any of the 4 points are inside the main rectangle, return true
        double newRectX = newRect.getX();
        double newRectY = newRect.getY();

        double halfWidth = newRect.getWidth()/2;
        double halfHeight = newRect.getHeight()/2;

        double corner1 = newRectX + halfWidth;
        double corner2 = newRectX - halfWidth;
        double corner3 = newRectY + halfHeight;
        double corner4 = newRectY - halfHeight;

        boolean overlap = false;

        if (pointInsideRectangle(corner1, corner3)){
            overlap = true;
        }

        if (pointInsideRectangle(corner1, corner4)){
            overlap = true;
        }

        if (pointInsideRectangle(corner2, corner3)){
            overlap = true;
        }

        if (pointInsideRectangle(corner2, corner4)){
            overlap = true;
        }

        return overlap;

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
• [OK] A method contains(double x, double y) that returns true if the specified point (x, y) is inside this rectangle. See Figure 1(a).
• [OK] A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside this rectangle. See Figure 1(b).
• A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this rectangle. See Figure 1(c).

(a) (b) (c)

Figure 1: (a) A point is inside the rectangle. (b) A rectangle is inside another rectangle. (c) A rectangle overlaps another rectangle.

Implement data fields, all constructors, methods getArea(), getPerimeter(), and contains(double x, double y), contains(MyRectangle2D r), and overlaps(MyRectangle2D r)

Please develop test cases to test your code properly before submission


 */