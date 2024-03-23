// Copy and paste your solution for Cat here
public class Cat extends Animal {
    public Cat(String name) {
        super("Cat:"+name);
    }


    @Override
    public String makeSound() {
        return getName()+ " says Meow";
    }
}
