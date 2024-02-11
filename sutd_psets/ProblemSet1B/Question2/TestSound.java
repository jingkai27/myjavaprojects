package ProblemSet1B.Question2;

public class TestSound {
    // You are not required to modify this class
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cow(), new SiberianCat()};

        System.out.println( AnimalConcert.performConcert(animals) );
    }
}

// define all classes (AnimalConcert, Animal, Dog, Cat, Cow, SiberianCat) below this line

class Animal{
    public String makeSound(){
        return "I am just an animal";
    }
}

class Dog extends Animal {
    @Override
    public String makeSound(){
        return "woof!";
    }
}

class Cat extends Animal {
    @Override
    public String makeSound(){
        return "meow!";
    }
}

class Cow extends Animal {
    @Override
    public String makeSound(){
        return "moo!";
    }
}

class SiberianCat extends Animal {
}

class AnimalConcert{
     public static String performConcert(Animal[] animals){
         String sounds = "";
         for (int i = 0; i < animals.length; i++){
             String sound = animals[i].makeSound();
             sounds += sound;
             if (i < animals.length-1){
                 sounds += ",";
             }
         }
         return sounds;
    }
}






/* Create a class Animal with a method makeSound.
There is no need to define a constructor.
This method takes no input and return a String object “I am just an animal”. OK

· Create 3 subclasses: Dog, Cat, and Cow.
Each subclass should override the makeSound() method to represent the unique sound that each animal makes.
The String each subclass return for Dog, Cat, and Cow are “Woof”, “Meow”, and “Moo”.

· Create a subclass of Cat named SiberianCat. The class does not contain any method.

· Create a class called AnimalConcert that has a static method named performConcert.

o The performConcert method should take an array of Animal objects as a parameter and return a String object as its output. The String is the sound of each animal joined with a comma and a space “, “.

o So, if the input argument is an array consists of a Dog and a Cat object, the output of performConcert method is “Woof, Meow”

 */
