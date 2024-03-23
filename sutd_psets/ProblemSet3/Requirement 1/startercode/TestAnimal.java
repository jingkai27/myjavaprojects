public class TestAnimal {

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

        Animal dog1 = new Dog("Fido");
        System.out.println(dog1.getName());
        System.out.println(dog1.makeSound());
        /** Output
         * Dog:Fido
         * Dog:Fido says Woof
         */
    }
}
