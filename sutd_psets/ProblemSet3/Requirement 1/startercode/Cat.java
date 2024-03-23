

public class Cat extends Animal {
    public Cat(String name) {
        super("Cat:"+name);
    }


    @Override
    public String makeSound() {
        return getName()+ " says Meow";
    }
}
