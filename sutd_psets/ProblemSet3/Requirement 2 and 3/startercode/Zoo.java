

import java.util.*;

public class Zoo {

    private AnimalFactory animalFactory;
    private List<Animal> animalList;

    Zoo(AnimalFactory animalFactory){
        // TODO Complete the constructor
        this.animalFactory = animalFactory;
        this.animalList = new ArrayList<>();
    }

    public void addAnimal(String type, String name){
       // TODO Complete this method
        animalList.add(animalFactory.createAnimal(type,name));
    }

    public String performConcert(){
        // TODO Complete this method
        String song = "";
        for (Animal animal: animalList){
            song += animal.makeSound();
            song += "*";
        }
        return song;
    }

    @Override
    public String toString() {
        // TODO Complete this method 
        return this.animalList.toString();
    }
}
