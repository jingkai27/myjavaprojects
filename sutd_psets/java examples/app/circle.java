public class circle extends abstractClass {
    public double radius;

    public circle(){
        this.radius = 1.0;
    }
    public circle(double r){
        this.radius = r;
    }

    public double getArea(){
        return 3.14 * this.radius * this.radius;
    }

    public double getPerimeter(){
        return 3.14 * 2 * this.radius;
    }

    public static void main(String[] args){
        circle c1 = new circle();
        System.out.println(c1.getPerimeter());
        circle c2 = new circle(5);
        System.out.println(c2.getArea());

    }



}
