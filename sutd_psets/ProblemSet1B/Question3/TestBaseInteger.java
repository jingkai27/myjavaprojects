package ProblemSet1B.Question3;

import java.util.ArrayList;
import java.util.Collections;

public class TestBaseInteger {
    public static void main(String[] args) {

        BaseInteger baseInteger1 = new BaseInteger( "1,1", 17);
        System.out.println(baseInteger1.getDecimalValue());
        System.out.println(baseInteger1.getDigitsString());
        System.out.println(baseInteger1);

        BaseInteger baseInteger2 = new BaseInteger( "1,1", 60);
        BaseInteger baseInteger3 = baseInteger1.add( baseInteger2 , 16);
        System.out.println(baseInteger3.getDigitsString()); // [4, 15]
        System.out.println(baseInteger3.getDecimalValue()); // 79
    }

}
