package ProblemSet1B.Question1;

import java.util.ArrayList;

public class FilterPersonExample {
    // No need to modify this class
    public static void main(String[] args) {
        Person p1 = new Person("A", 90, 'F', false);
        Person p2 = new Person("B", 60, 'M', true);
        Person p3 = new Person("C", 30, 'F', true);
        Person[] p = {p1, p2, p3};

        System.out.println( Filter.seniorFilter(p) );
    }
}

class Filter {
    public static ArrayList<String> seniorFilter(Person[] p){
        ArrayList<String> newArray = new ArrayList<>();
        for (int i=0; i < p.length; i++){
            newArray.add(p[i].getName());
        }
        return newArray;
    }
}



class Person {
    private String name;
    private int age;
    private char gender;
    private boolean sharingConsent;

    public int getAge() {
        return age;
    }

    public void setAge(int newVal){
        this.age = newVal;
    }

    public char getGender(){
        return gender;
    }

    public boolean getSharingConsent(){
        return sharingConsent;
    }

    public String getName(){
        if (getSharingConsent() == true){
            return name;
        } else {
            return "Anonymous";
        }
    }

    Person(String n1, int a1, char g1, boolean sc1){
        this.name = n1;
        this.age = a1;
        this.gender = g1;
        this.sharingConsent = sc1;

    }
}


/*
Create a class named Person.
Implement the class with the following private attributes:
- [OK] name (type String), age (type int), gender (type char), sharingConsent (type bool).
- [OK] Provide constructor that takes 4 input arguments of name, age, gender, and sharing consent. The inputs are used to initiate the attributes of the same name.
· [OK] Provide public getter and setter methods to access and modify age attribute.
· [OK]Assume that the value of age passed to the Constructor and the setter for age will always be positive.
· Provide public getter for name and sharingConsent attributes
o If sharingConsent is true, name getter will return the name, otherwise return a String “Anonymous”.

Additionally, create a class named Filter.

· implement a static method named seniorFilter. The method takes an array of Person objects and return an ArrayList of names whose age equals to or above 60 years old.

Reminder: For an attribute named foo, by convention the getter and setter is named getFoo() and setFoo().

 */