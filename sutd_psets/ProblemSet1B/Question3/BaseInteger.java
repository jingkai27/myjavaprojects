package ProblemSet1B.Question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BaseInteger {

    private String representation;
    private int base;

    private int[] digits;
    private int decimalValue;

    BaseInteger( String representation, int base){
        this.representation = deleteSpaces(representation);
        this.base = base;
        convertRepresentationToArray();
        setDecimalValue();
    }


    private ArrayList<Integer> convertRepresentationToArray(){
        /* convertRepresentationToArray()reads the information from representation and
        stores the digits as elements in the digits int array. */
        System.out.println(this.representation);
        return null;


    }

    private void setDecimalValue(){
    }

    public int getDecimalValue() {
        return 0;
    }

    public String getDigitsString(){
        return "";
    }


    public BaseInteger add(BaseInteger other, int base){
        return null;
    }

    private String convertBase(int decimalValue, int base){
        return "";
    }

    private String deleteSpaces( String representation){
        return "";
    }

    @Override
    public String toString() {
        return representation + " Base " + base;
    }
}
