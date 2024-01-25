package week1;

public class ReverseString {
    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o'};

        // Call the reverseString method
        reverseString(input);

        // Print the reversed string
        System.out.print("Reversed String: ");
        for (char c : input) {
            System.out.print(c + " ");
        }
    }

    public static void reverseString(char[] s) {
        int charNum = s.length;
        charNum -= 1;
        System.out.println(charNum);
        // initial condition i = last number
        for (int i=charNum; i != -1; i--){
            System.out.println(s[i]);
        }

        // add to list, minus one
    }
}
