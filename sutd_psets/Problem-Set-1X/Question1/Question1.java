public class Question1 {

    public static void main(String[] args) {

        System.out.println(addTime(6, 30, 4, 45));
        //write code to execute the other testcases
    }

    static String addTime(int hour1, int min1, int hour2, int min2){
        int totalMinutes = hour1 * 60 + min1 + hour2 * 60 + min2;

        int resultHour = totalMinutes / 60;
        int resultMin = totalMinutes % 60;

        return resultHour + " hours " + resultMin + " minutes";
    }
}
