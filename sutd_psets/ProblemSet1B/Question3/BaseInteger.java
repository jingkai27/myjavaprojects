import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BaseInteger {

    private String representation;
    private int base;

    private int[] digits;
    private int decimalValue;

    public static void main(String[] args){
        BaseInteger integer1 = new BaseInteger("2, 1", 2);
        System.out.println("--- IMPORTANT --" + integer1.getDigitsString());
        BaseInteger integer2 = new BaseInteger("22, 43, 5", 60);
        integer2.add(integer1, 5);
    }

    BaseInteger(String representation, int base){
        this.representation = deleteSpaces(representation);
        this.base = base;
        convertRepresentationToArray();
        setDecimalValue();
    }

    private ArrayList<Integer> convertRepresentationToArray(){
        /* convertRepresentationToArray()reads the information from representation and
        stores the digits as elements in the digits int array. */
        // split string into an array of strings
        String[] integerStrings = this.representation.split(",");

        // create array to store the integers
        this.digits = new int[integerStrings.length];

        // parse each string and store integers in the array
        for (int i = 0; i < integerStrings.length; i++){
            this.digits[i] = Integer.parseInt(integerStrings[i]);
        }

        return null;
    }

    private void setDecimalValue(){
        int sum = 0;
        int power = this.digits.length;
        for (int i = 0; i < this.digits.length; i++){
            power -= 1;
            sum += this.digits[i] * Math.pow(this.base, power);
        }
        this.decimalValue = sum;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    public String getDigitsString(){
        return Arrays.toString(this.digits);
    }

    public BaseInteger add(BaseInteger other, int base){
        // 1. find sum of the decimal values of this and other
        // a. sum of decimal values
        if (this.decimalValue == 0 && other.decimalValue == 0) {
            return new BaseInteger("0", base);
        } else if (this.decimalValue == 0) {
            return new BaseInteger(convertBase(other.decimalValue, base), base);
        } else if (other.decimalValue == 0) {
            return new BaseInteger(convertBase(this.decimalValue, base), base);
        } else {
            int sum = other.decimalValue + this.decimalValue;
            System.out.println(sum);

            return new BaseInteger(convertBase(sum, base), base);
        }
    }

    private String convertBase(int decimalValue, int base){
        StringBuilder nums = new StringBuilder();

        while (decimalValue > 0) {
            int remainder = decimalValue % base;
            nums.insert(0, remainder + ", ");
            decimalValue /= base;
            //System.out.println("this is the sum: " + decimalValue + " and this is the remainder " + remainder);
        }
        return nums.toString();
    }

    private String deleteSpaces( String representation){
        return representation.replace(" ", "");
    }

    @Override
    public String toString() {
        return representation + " Base " + base;
    }
}
