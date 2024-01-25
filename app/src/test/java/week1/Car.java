package week1;

/*
Task: Create a simple Car class in Java

Class Name: Car

Attributes (Instance Variables):
brand (String) - representing the brand of the car.
model (String) - representing the model of the car.
year (int) - representing the manufacturing year of the car.
mileage (double) - representing the current mileage of the car.

Static Variable:
totalCars (int) - representing the total number of cars created.
Increment this variable each time a new car object is instantiated.

Methods:
Car(String brand, String model, int year) - Constructor that initializes the brand, model, and year of the car. Also, increments the totalCars static variable.
void drive(double miles) - Method that takes the number of miles driven and updates the mileage instance variable accordingly.
void displayInfo() - Method that prints out the information about the car (brand, model, year, mileage).
*/

public class Car {
    // attributes
    String brand;
    String model;
    int year;
    double mileage;

    // methods
    // constructor to initialise car
    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;

        if (year <= 2024){
            this.year = year;
        }
        else{
            System.out.println("Invalid Year, setting year to 2024.");
            this.year = 2024;
        }
        this.mileage = 0.0;
        Car.totalCars += 1;
    }
    // Method to display information about the car
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage + " miles");
    }

    // drive method
    public void drive(double distanceTravel){
        System.out.println("Travelling " + distanceTravel + " miles now...");
        mileage += distanceTravel;
        System.out.println("mileage: " + mileage);
    }

    public static void main(String[] args){
        Car CarOne = new Car("Tesla", "E", 2021);

        // Use the display method
        int caryear = CarOne.year;

        // running displayInfo()
        CarOne.displayInfo();
        CarOne.drive(50);
        System.out.println("This car was manufactured in " + caryear);
    }

    // class function
    static int totalCars = 0;

    public static int getTotalCars(){
        return totalCars;
    }
}
