

public class TestZoo {

    public static void main(String[] args) {

        Animal cat1 = new Cat("ichika");
        System.out.println(cat1.getName());
        System.out.println(cat1.makeSound());
        /** Output:
         * Cat:ichika
         * Cat:ichika says Meow */

        Animal cat2 = new Cat("nino");
        Animal cat3 = new Cat("ichika");
        System.out.println(cat1.equals(cat3));
        System.out.println(cat2.equals(cat3));
        /** Output:
         * true
         * false */
        System.out.println(cat3.hashCode());

        Animal dog1 = new Dog("Fido");
        System.out.println(dog1.getName());
        System.out.println(dog1.makeSound());
        /** Output
         * Dog:Fido
         * Dog:Fido says Woof
         */





        AnimalFactory animalFactory = new FarmFactory();
        Animal animal1 = animalFactory.createAnimal("Cat","miku");
        Animal animal2 = animalFactory.createAnimal("Dog","hachiko");
        System.out.println(animal1.getName());
        System.out.println(animal2.getName());
        System.out.println("toString" + animal1);
        /** Output
         * Cat:miku
         * Dog:hachiko */

        Zoo zoo = new Zoo( new FarmFactory());
        System.out.println(zoo);
        zoo.addAnimal("Cat", "Kuroneko");
        zoo.addAnimal("Dog", "Bond");
        zoo.addAnimal("Cow", "Gyudon");
        System.out.println(zoo.performConcert());
        System.out.println(zoo);
        /** Output
         * Cat:Kuroneko says Meow*Dog:Bond says Woof*Cow:Gyudon says Moo Moo*
         */
    }
}
