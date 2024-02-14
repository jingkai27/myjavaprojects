import java.util.Scanner;

public class handleZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Perform division here
            System.out.println("Answer: "+ numerator/denominator);

            // Print the result if successful

        } catch (ArithmeticException e) {
            // Handle division by zero exception
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            // Handle other exceptions if necessary
            System.out.println("An unexpected error occurred.");
        } finally {
            // Close resources if necessary (e.g., scanner)
            scanner.close();
        }
    }
}
