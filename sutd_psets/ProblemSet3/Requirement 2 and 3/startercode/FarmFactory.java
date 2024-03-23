// TODO Complete this 

public class FarmFactory implements AnimalFactory {

    @Override
    public Animal createAnimal(String type, String name) {
        if (type.equals("Cat")){
            return new Cat(name);
        } else if (type.equals("Dog")){
            return new Dog(name);
        } else if (type.equals("Cow")){
            return new Cow(name);
        } else {
            return null;
        }
    }
}
