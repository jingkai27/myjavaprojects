package week1;

public class HelloWorld{
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Accord", 2019);

        car1.drive(100);
        car2.drive(150);

        car1.displayInfo();
        car2.displayInfo();

        System.out.println("Total Cars: " + Car.totalCars);
    }
}