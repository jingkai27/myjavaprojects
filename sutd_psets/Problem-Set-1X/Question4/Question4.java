// Binary to Decimal //
public class Question4 {

    public static void main(String[] args) {

        System.out.println( binaryToDecimal("1011")); // 1011
        System.out.println(binaryToDecimal("1011001"));
        //execute your function with your own test cases
    }

    static int binaryToDecimal( String s){
        int i = s.length(); //i=4
        int power = 0; // setting starting power to be 0
        int sum = 0; // setting starting sum to be 0
        int coeff = 0;
        // finding individual characters
        for (int j = i-1; j > -1; j--){
            if (s.charAt(j) == '0'){
                coeff = 0;
            } else if (s.charAt(j)== '1') {
                coeff = 1;
            }
            double multiple = Math.pow(2,power);
            power += 1;
            double result = multiple * coeff;
            sum += result;
        }
        return sum;
    }
}
