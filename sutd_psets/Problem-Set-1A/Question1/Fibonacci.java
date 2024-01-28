// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit the Main.java file 

public class Fibonacci{
    
    public static String fibonacci( int n ){
        if (n <= 0){
            return "";
        } else if (n==1) {
            return "0";
        } else {
            StringBuilder sequence = new StringBuilder("0,1");
            int prev = 0;
            int current = 1;
            for (int i = 2; i < n;  i++){
                int sum = prev + current;
                sequence.append(",").append("sum");
                prev = current;
                current = sum;
            }
        return sequence.toString();
        }

    }
        
}