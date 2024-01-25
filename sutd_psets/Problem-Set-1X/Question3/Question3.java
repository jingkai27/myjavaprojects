public class Question3 {

    public static void main(String[] args) {

        System.out.println( termsRequired(0.9)); // 6
        // Execute the function with your own test cases

    }

    static int termsRequired(double p){
        double sum = 0;
        int num = 0;
        double goal = p * Math.pow(Math.PI,2) / 6;
        System.out.println(goal);
        while (sum < goal){
            num += 1;
            double plus_one = 1 / Math.pow(num, 2);
            sum += plus_one;
            System.out.println(sum);
        }
        return num;
    }
}
