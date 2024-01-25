public class Question2 {

    public static void main(String[] args) {

        int a[] = {7, 10, 18, 27, 36, 45, 54, 63, 72, 81, 90};
        System.out.println(sumUpTo(10)); // 55
        System.out.println(sumUpToRecursion(10)); //55
        System.out.println(sumIntArrayAll(a)); // 503
        System.out.println(sumIntArrayTwenty(a)); // 468
        System.out.println(countEvenNumbers(a)); // 6
        // Write code here to execute the functions yourself

    }

    static int sumUpTo(int n) {
        int sum = 0;
        for (int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }

    static int sumUpToRecursion(int n){
        if (n == 1){
            return 1;
        } else {
            return n + sumUpToRecursion(n-1);
        }

    }

    static int sumIntArrayAll(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    static int sumIntArrayTwenty(int[] array) {
        int sum = 0;
        for (int j = 0; j < array.length; j++){
            if (array[j] > 20){
                sum += array[j];
            }
        }
        return sum;
    }

    static int countEvenNumbers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (((array[i] % 2) == 0)) {
                count++;
            }
        }
        return count;
    }
}